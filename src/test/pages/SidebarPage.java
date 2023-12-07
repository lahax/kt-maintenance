package test.pages;

import ta.annotations.elements.Element;
import ta.entities.elements.PageElement;

public class SidebarPage {

    /*Xpath SideBar buttons EN*/
    @Element(xpath = "//i[@dmcicon='arrow-square-left']", desc = "Back sidebar Button ")
    private static PageElement backButtonSideBar;
    @Element(xpath = "//div[contains(text(), 'Home')]/ancestor::div[contains(@class, 'dmc-sidebar-item')]", desc = "Home Option Sidebar ")
    private static PageElement homeOption;
    @Element(xpath = "//div[contains(text(), 'Devices')]/ancestor::div[contains(@class, 'dmc-sidebar-item')]", desc = "Devices Option Sidebar ")
    private static PageElement devicesOption;
    @Element(xpath = "//div[contains(text(), 'Activities')]/ancestor::div[contains(@class, 'dmc-sidebar-item')]", desc = "Activities Option Sidebar ")
    private static PageElement activitiesOption;
    @Element(xpath = "//div[contains(text(), 'Diagnostic')]/ancestor::div[contains(@class, 'dmc-sidebar-item')]", desc = "Diagnostic Option Sidebar ")
    private static PageElement diagnosticOption;
    @Element(xpath = "(//i[@dmcicon='chevron-down'])[position()=1]", desc = "Diagnostic Option Sidebar Drop Down Item")
    private static PageElement diagnosticDropDownOption;
    @Element(xpath = "//div[contains(text(), 'Lambdas')]/ancestor::div[contains(@class, 'dmc-sidebar-subitem')]", desc = "Lambdas sub option")
    private static PageElement lambdasSubOption;
    @Element(xpath = "//div[contains(text(), 'MQTT Client')]", desc = "Mqtt Client sub option")
    private static PageElement mqttSubOption;
    @Element(xpath = "//div[contains(text(), 'MQTT Client')]/ancestor::div[contains(@class, 'dmc-sidebar-subitem')]", desc = "Mqtt Client sub option")
    private static PageElement mqttSubOptionEntry;
    @Element(xpath = "//div[contains(text(), 'Step function')]/ancestor::div[contains(@class, 'dmc-sidebar-subitem')]", desc = "Step function sub option")
    private static PageElement stepFunctionSubOption;
    @Element(xpath = "//div[contains(text(), 'Load Certificate')]/ancestor::div[contains(@class, 'dmc-sidebar-subitem')]", desc = "Load Certificate sub option")
    private static PageElement loadCertificateSubOption;
    @Element(xpath = "//div[contains(text(), 'API Invocation')]/ancestor::div[contains(@class, 'dmc-sidebar-subitem')]", desc = "API Invocation sub option")
    private static PageElement apiInvocationSubOption;
    @Element(xpath = "//div[contains(text(), 'Log')]/ancestor::div[contains(@class, 'dmc-sidebar-item')]", desc = "Log Option Sidebar ")
    private static PageElement logOption;
    //Alarms xpath specific, otherwise it finds also -Device Alarms Configurations-
    @Element(xpath = "//div[contains(text(), 'Alarms & Events') and @class = 'item-label']/ancestor::div[contains(@class, 'dmc-sidebar-item')]", desc = "Alarms Option Sidebar ")
    private static PageElement alarmsOption;
    @Element(xpath = "//div[contains(text(), 'Software Manager')]/ancestor::div[contains(@class, 'dmc-sidebar-item')]", desc = "Software Manager Option Sidebar ")
    private static PageElement softwareManagerOption;
    @Element(xpath = "(//i[@dmcicon='chevron-down'])[position()=2]", desc = "Sofware Manager Option Sidebar Drop Down Item")
    private static PageElement softwareManagerDropDownOption;
    @Element(xpath = "//div[contains(text(), 'Software Catalogue')]/ancestor::div[contains(@class, 'dmc-sidebar-subitem')]", desc = "Software Catalogue sub option")
    private static PageElement softwareCatalogueOption;
    @Element(xpath = "//div[contains(text(), 'Deployments History')]/ancestor::div[contains(@class, 'dmc-sidebar-subitem')]", desc = "Deployments History sub option")
    private static PageElement deploymentsHistoryOption;
    @Element(xpath = "//div[contains(text(), 'Campaign Management')]/ancestor::div[contains(@class, 'dmc-sidebar-subitem')]", desc = "Campaign Management sub option")
    private static PageElement campaignManagementOption;
    @Element(xpath = "//div[contains(text(), 'RDE')]/ancestor::div[contains(@class, 'dmc-sidebar-item')]", desc = "RDE Option Sidebar ")
    private static PageElement rdeOption;
    @Element(xpath = "//div[contains(text(), 'E2E Monitoring')]/ancestor::div[contains(@class, 'dmc-sidebar-item')]", desc = "E2E Monitoring Option Sidebar ")
    private static PageElement e2eMonitoringOption;
    @Element(xpath = "(//i[@dmcicon='chevron-down'])[position()=3]", desc = "E2E Option Sidebar Drop Down Item")
    private static PageElement e2eMonitoringDropDownOption;
    @Element(xpath = "//div[contains(text(), 'Device Alarms Configurations')]/ancestor::div[contains(@class, 'dmc-sidebar-subitem')]", desc = "Device Alarms Configuration sub option ")
    private static PageElement deviceAlarmsConfigurationSubOption;
    @Element(xpath = "//div[contains(text(), 'Notifications Configurations')]/ancestor::div[contains(@class, 'dmc-sidebar-subitem')]", desc = "Notifications Configuration sub option ")
    private static PageElement notificationsConfigurationSubOption;
    @Element(xpath = "//div[contains(text(), 'Custom Groups')]/ancestor::div[contains(@class, 'dmc-sidebar-subitem')]", desc = "Custom Groups sub option ")
    private static PageElement customGroupsSubOption;

    @Element(xpath = "//div[contains(text(), 'Usage Statistics')]/ancestor::div[contains(@class, 'dmc-sidebar-item')]", desc = "Usage statistics Sidebar ")
    private static PageElement usageStatisticOption;

    @Element(xpath = "//div[contains(text(), 'Trend ID Registry')]/ancestor::div[contains(@class, 'dmc-sidebar-item')]", desc = "Trend ID Registry Sidebar ")
    private static PageElement trendIdRegistryOption;

    @Element(xpath = "//div[contains(text(), 'Trend ID Registry')]/ancestor::div[contains(@class, 'dmc-sidebar-item')]", desc = "Trend ID Registry Sidebar")
    private static PageElement trendIdRegistry;

    @Element(xpath = "//div[contains(text(), 'Tickets Management')]/ancestor::div[contains(@class, 'dmc-sidebar-item')]", desc = "Tickets management Sidebar ")
    private static PageElement ticketsManagementOption;


    /*Xpath SideBar buttons IT*/
    //Dispositivi xpath specific, otherwise it finds also -Configurazione Allarmi Dispositivi-
    @Element(xpath = "//div[contains(text(), 'Dispositivi') and @class='item-label']", desc = "Devices Option Sidebar IT")
    private static PageElement devicesOptionIT;
    @Element(xpath = "//div[contains(text(), 'Attività')]", desc = "Activities Option Sidebar IT")
    private static PageElement activitiesOptionIT;
    @Element(xpath = "//div[contains(text(), 'Diagnostica')]", desc = "Diagnostic Option Sidebar IT")
    private static PageElement diagnosticOptionIT;
    @Element(xpath = "//div[contains(text(), 'Lambda')]", desc = "Lambdas sub option IT ")
    private static PageElement lambdasSubOptionIT;
    //MQTT Client same xPath
    //Step function same xPath
    @Element(xpath = "//div[contains(text(), 'Caricamento certificati')]", desc = "Load Certificate sub option IT")
    private static PageElement loadCertificateSubOptionIT;
    //API Invocation same xPath
    //LOG same xpath
    //Allarmi xpath specific, otherwise it finds Configurazione allarmi dispositivi
    @Element(xpath = "//div[contains(text(), 'Allarmi & Eventi') and @class = 'item-label']", desc = "Alarms Option Sidebar IT")
    private static PageElement alarmsOptionIT;
    @Element(xpath = "//div[contains(text(), 'Gestione Software')]", desc = "Software Manager Option Sidebar IT")
    private static PageElement softwareManagerOptionIT;
    @Element(xpath = "//div[contains(text(), 'Catalogo software')]", desc = "Software Catalogue sub option IT")
    private static PageElement softwareCatalogueOptionIT;
    @Element(xpath = "//div[contains(text(), 'Cronologia Distribuzioni')]", desc = "Software Catalogue sub option IT")
    private static PageElement deploymentsHistoryOptionIT;
    @Element(xpath = "//div[contains(text(), 'Campagne Aggiornamenti')]", desc = "Campaign Management sub option IT")
    private static PageElement campaignManagementOptionIT;
    @Element(xpath = "//i[@dmcicon='arrow-square-left']", desc = "left arrow on sidebar")
    private static PageElement leftArrowOnSidebar;


    //RDE same xpath
    @Element(xpath = "//div[contains(text(), 'Monitoraggio E2E')]", desc = "E2E Monitoring Option Sidebar IT")
    private static PageElement e2eMonitoringOptionIT;
    @Element(xpath = "//div[contains(text(), 'Configurazione Allarmi Dispositivi')]", desc = "Device Alarms Configuration sub option IT")
    private static PageElement deviceAlarmsConfigurationSubOptionIT;
    @Element(xpath = "//div[contains(text(), 'Configurazione notifiche')]", desc = "Notifications Configuration sub option ")
    private static PageElement notificationsConfigurationSubOptionIT;
    @Element(xpath = "//div[contains(text(), 'Gruppi Personalizzati')]", desc = "Custom Groups sub option IT")
    private static PageElement customGroupsSubOptionIT;
    @Element(xpath = "//div[contains(text(), 'Statistiche di utilizzo')]", desc = "Usage statistics Sidebar IT")
    private static PageElement usageStatisticOptionIT;
    @Element(xpath = "//div[contains(text(), 'Gestione Cartellini')]", desc = "Tickets management Sidebar IT ")
    private static PageElement ticketsManagementOptionIT;

    @Element(xpath = "//div[contains(text(), 'Registro Trend ID')]/ancestor::div[contains(@class, 'dmc-sidebar-item')]", desc = "Trend ID Registry Sidebar IT")
    private static PageElement trendIdRegistryOptionIT;


    /*Getters SideBar buttons EN*/

    public static PageElement getHomeOption() {return homeOption;}
    public static PageElement getDevicesOption() {return devicesOption;}
    public static PageElement getActivitiesOption() {return activitiesOption;}
    public static PageElement getDiagnosticOption() {return diagnosticOption;}
    public static PageElement getLambdasSubOption() {return lambdasSubOption;}
    public static PageElement getMqttSubOption() {return mqttSubOption;}
    public static PageElement getStepFunctionSubOption() {return stepFunctionSubOption;}
    public static PageElement getLoadCertificateSubOption() {return loadCertificateSubOption;}
    public static PageElement getApiInvocationSubOption() {return apiInvocationSubOption;}
    public static PageElement getLogOption() {return logOption;}
    public static PageElement getAlarmsOption() {return alarmsOption;}
    public static PageElement getSoftwareManagerOption() {return softwareManagerOption;}
    public static PageElement getSoftwareCatalogueOption() {return softwareCatalogueOption;}
    public static PageElement getDeploymentsHistoryOption() {return deploymentsHistoryOption;}
    public static PageElement getCampaignManagementOption() {return campaignManagementOption;}
    public static PageElement getRdeOption() {return rdeOption;}
    public static PageElement getE2eMonitoringOption() {return e2eMonitoringOption;}
    public static PageElement getDeviceAlarmsConfigurationSubOption() {return deviceAlarmsConfigurationSubOption;}
    public static PageElement getNotificationsConfigurationSubOption() {return notificationsConfigurationSubOption;}
    public static PageElement getCustomGroupsSubOption() {return customGroupsSubOption;}
    public static PageElement getUsageStatisticOption() {return usageStatisticOption;}
    public static PageElement getTicketsManagementOption() {return ticketsManagementOption;}

    public static PageElement getDiagnosticDropDownOption() {
        return diagnosticDropDownOption;
    }

    public static PageElement getSoftwareManagerDropDownOption() {
        return softwareManagerDropDownOption;
    }

    public static PageElement getE2eMonitoringDropDownOption() {
        return e2eMonitoringDropDownOption;
    }

    /*Getters SideBar buttons IT*/

    public static PageElement getDevicesOptionIT() {return devicesOptionIT;}
    public static PageElement getActivitiesOptionIT() {return activitiesOptionIT;}
    public static PageElement getDiagnosticOptionIT() {return diagnosticOptionIT;}
    public static PageElement getLambdasSubOptionIT() {return lambdasSubOptionIT;}
    public static PageElement getLoadCertificateSubOptionIT() {return loadCertificateSubOptionIT;}
    public static PageElement getAlarmsOptionIT() {return alarmsOptionIT;}
    public static PageElement getSoftwareManagerOptionIT() {return softwareManagerOptionIT;}
    public static PageElement getSoftwareCatalogueOptionIT() {return softwareCatalogueOptionIT;}
    public static PageElement getDeploymentsHistoryOptionIT() {return deploymentsHistoryOptionIT;}
    public static PageElement getCampaignManagementOptionIT() {return campaignManagementOptionIT;}
    public static PageElement getE2eMonitoringOptionIT() {return e2eMonitoringOptionIT;}
    public static PageElement getDeviceAlarmsConfigurationSubOptionIT() {return deviceAlarmsConfigurationSubOptionIT;}
    public static PageElement getNotificationsConfigurationSubOptionIT() {return notificationsConfigurationSubOptionIT;}
    public static PageElement getCustomGroupsSubOptionIT() {return customGroupsSubOptionIT;}
    public static PageElement getUsageStatisticOptionIT() {return usageStatisticOptionIT;}
    public static PageElement getTicketsManagementOptionIT() {return ticketsManagementOptionIT;}

    public static PageElement getTrendIdRegistryOptionIT() {return trendIdRegistryOptionIT;}
}
