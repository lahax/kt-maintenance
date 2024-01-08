Feature: E2EMonitoring

  Scenario: First Login
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    And I type "rdmcntest001@enel.com" into the element LoginPage.emailInputFirstLogin
    Then I click LoginPage.emailInputFirstLoginSubmitBtn
    And I type "dmcNtest$000000" into the element LoginPage.passwordInput
    And I cancel text from the input box element LoginPage.usernameInput
    And I type "ENELINT\rdmcntest001" into the element LoginPage.usernameInput

    Then I click LoginPage.submitLoginBtn
    Then I click LoginPage.keepSignInYES