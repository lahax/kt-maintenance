package UtilShell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.function.Consumer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CommandExecutor {

    private static final Logger LOG = LoggerFactory.getLogger(CommandExecutor.class);

    public CommandResult executeCommand(String command) throws IOException {
        return executeCommand(command, null, null, null, null, null, false, null);
    }

    public CommandResult executeCommand(String baseCommand, List<String> params, boolean silent) throws IOException {
        return executeCommand(baseCommand, params, null, null, silent);
    }

    public CommandResult executeCommand(String command, List<String> params, Path workingDir, Map<String, String> env,
                                        boolean silent) throws IOException {

        return executeCommand(command, params, workingDir, env, null, null, silent, null);
    }

    public CommandResult executeCommand(String baseCommand,
                                        List<String> params,
                                        Path workingDir,
                                        Map<String, String> env,
                                        Consumer<String> stderrLineElaborator,
                                        Consumer<String> stdoutLineElaborator,
                                        boolean silent,
                                        Path logFile) throws IOException {
        Process process = null;
        try {
            List<String> arguments = Arrays.stream(baseCommand.split(" ")).collect(Collectors.toList());
            if (params != null) {
                arguments.addAll(
                        params.stream().map(p -> p.replace("[]", " ")
                                        .replace("-jar", "-Xmx512m -jar")).collect(Collectors.toList())
                );
            }

            String[] paramsArray = arguments.toArray(new String[0]);

            if (!silent) {
                LOG.debug("Executing command: {}", String.join(" ", paramsArray));
            }

            Map<String, String> privateEnv = new HashMap<>(System.getenv()); // Add the current system env
            if (env != null) { // No other env is needed other than the system one
                privateEnv.putAll(env);
            }

            String[] envStrings = privateEnv.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).toArray(String[]::new);

            StringBuilder stdoutBuilder = new StringBuilder();
            StringBuilder stderrBuilder = new StringBuilder();

            if (workingDir == null) {
                workingDir = Paths.get("."); // So that we can execute commands in the current folder passing null
            }

            process = Runtime.getRuntime().exec(paramsArray, envStrings, workingDir.toFile());
            Thread stdoutThread = logOutput(process.getInputStream(), Arrays.asList(stdoutBuilder::append, stdoutLineElaborator), silent, logFile);
            Thread stderrThread = logOutput(process.getErrorStream(), Arrays.asList(stderrBuilder::append, stderrLineElaborator), silent, logFile);

            stdoutThread.start();
            stderrThread.start();

            process.waitFor();
            stdoutThread.join();
            stderrThread.join();

            return new CommandResult(stdoutBuilder.toString(), stderrBuilder.toString(), process.exitValue());
        } catch (InterruptedException e) {
            LOG.warn("Command needs to be stopped, destroying process");
            process.destroy();
        }

        return null;
    }

    private Thread logOutput(InputStream inputStream, List<Consumer<String>> lineElaborators, boolean silent, Path logFile) {
        return new Thread(() -> {
            try (Scanner scanner = new Scanner(inputStream, "UTF-8")) {
                while (scanner.hasNextLine()) {
                    synchronized (this) {
                        String line = scanner.nextLine();
                        if (!silent) {
                            LOG.debug(line);
                        }

                        if (logFile != null) {
                            try {
                                Files.write(logFile, (line + "\n").getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                            } catch (IOException e) {
                                LOG.error("Cannot write log line to file", e);
                            }
                        }

                        for (Consumer<String> lineElaborator : lineElaborators) {
                            if (lineElaborator != null) {
                                lineElaborator.accept(line + "\n");
                            }
                        }
                    }
                }
            }
        });
    }
}

