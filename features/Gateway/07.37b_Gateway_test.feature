@Gateway_Test_7.37b
Feature: Gateway

  Background:

    #Step 1- Login on DMC
    Given I navigate to "https://dmc-iot-test.enel.com/#/auth/login"
    Then I click LoginPage.loginBtn
    Then I perform login as "admin" user
    And I click HomePage.infoUserLoggedIn
    Then I click HomePage.languageSubOption
    When I click HomePage.buttonEnglishSubOption

  Scenario: Test case 7.37b
    Then I enter on "esol-ap29551-qa" project
    #----------------------------------Step 2
    #Access to Devices Section then select a connected Gateway, enter the detail section then click on the + on thing section and select Activate thing
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
    Then I type "gateway" into the element DevicesPage.searchBox
    #Then I check the presence of DevicesPage.filterBox Element and then i click it
    #And I check the presence of DevicesPage.checkboxNeverConnected Element and then i click it
    #And I check the presence of DevicesPage.confirmFilters Element and then i click it
    And I wait 10 seconds
    Then I click DevicesPage.iconDetailsFirstRow
    And I click DevicesDetailsPage.enterToThingsList
    And I click DevicesDetailsPage.threeDotsButton
    And I click DevicesDetailsPage.activateThingsBTN

    #Select an IoT Gateway Template different to "Other":
        #Check that each field of each template has a validation:
    #The validation must be compliant to the specification reported in the following confluence page per each protocol fo the IoT Gateway template selection:
    #
    #    modbus_tcp
    #    modbus_rtu
    #    opc_da
    #    iec104
    #    lora_ns
    And I click ActivateThingPage.inputField
    And I click ActivateThingPage.DDMOption that contains "modbus_tcp"

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.modelInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.makerInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. #, $, %, &, *, è) are not valid." for ActivateThingPage.aliasInputField with these characters
      | # |
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.radioTypeInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |
    And I click ActivateThingPage.interactionModeField without scroll
    And I should see these options
      | gateway    |
      | greengrass |
      | direct     |

    And I click ActivateThingPage.exitInteractionModeField without scroll
    And I validate error "The IP address must have the IPv4 format (example: 192.168.1.100)" for ActivateThingPage.IPAddressInputField with these characters
      | Test |
    And I validate error "Only numbers are valid characters." for ActivateThingPage.portNumberInputField with these characters
      | Test |
    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.serialNumberInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.deviceTypeInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |
    And I validate error "Only numbers are valid characters." for ActivateThingPage.externalIDInputField with these characters
      | Test |

    ################################################
    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
#    Then I type "gateway" into the element DevicesPage.searchBox
    And I wait 10 seconds
    Then I click DevicesPage.iconDetailsFirstRow
    And I click DevicesDetailsPage.enterToThingsList
    And I click DevicesDetailsPage.threeDotsButton
    And I click DevicesDetailsPage.activateThingsBTN

    And I click ActivateThingPage.inputField
    And I click ActivateThingPage.DDMOption that contains "modbus_rtu"
    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.modelInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.makerInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. #, $, %, &, *, è) are not valid." for ActivateThingPage.aliasInputField with these characters
      | # |
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.radioTypeInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.deviceTypeInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.portNameInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Only numbers are valid characters." for ActivateThingPage.baudRateInputField with these characters
      | Test |

    And I validate error "Only numbers are valid characters." for ActivateThingPage.dataBitsInputField with these characters
      | Test |

    And I validate error "Only numbers are valid characters." for ActivateThingPage.parityInputField with these characters
      | Test |

    And I validate error "Only numbers are valid characters." for ActivateThingPage.stopBitsInputField with these characters
      | Test |

    And I validate error "Only numbers are valid characters." for ActivateThingPage.externalIDInputField with these characters
      | Test |

    And I click ActivateThingPage.interactionModeField without scroll
    And I should see these options
      | gateway    |
      | greengrass |
      | direct     |

    #########################

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
#    Then I type "gateway" into the element DevicesPage.searchBox
    And I wait 10 seconds
    Then I click DevicesPage.iconDetailsFirstRow
    And I click DevicesDetailsPage.enterToThingsList
    And I click DevicesDetailsPage.threeDotsButton
    And I click DevicesDetailsPage.activateThingsBTN

    And I click ActivateThingPage.inputField
    And I click ActivateThingPage.DDMOption that contains "opc_da"

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.modelInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.makerInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. #, $, %, &, *, è) are not valid." for ActivateThingPage.aliasInputField with these characters
      | # |
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.radioTypeInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |
    And I validate error "The IP address must have the IPv4 format (example: 192.168.1.100)" for ActivateThingPage.IPAddressInputField with these characters
      | Test |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.serialNumberInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.CLSIDInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.usernameInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Blank space is not valid." for ActivateThingPage.passwordInputField with these characters
      | \s |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.domainNameInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Only numbers are valid characters." for ActivateThingPage.externalIDInputField with these characters
      | Test |

    And I click ActivateThingPage.interactionModeField without scroll
    And I should see these options
      | gateway    |
      | greengrass |
      | direct     |

    ########################

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
#    Then I type "gateway" into the element DevicesPage.searchBox
    And I wait 10 seconds
    Then I click DevicesPage.iconDetailsFirstRow
    And I click DevicesDetailsPage.enterToThingsList
    And I click DevicesDetailsPage.threeDotsButton
    And I click DevicesDetailsPage.activateThingsBTN

    And I click ActivateThingPage.inputField
    And I click ActivateThingPage.DDMOption that contains "iec104"

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.modelInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.makerInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. #, $, %, &, *, è) are not valid." for ActivateThingPage.aliasInputField with these characters
      | # |
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.radioTypeInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |
    And I validate error "The IP address must have the IPv4 format (example: 192.168.1.100)" for ActivateThingPage.IPAddressInputField with these characters
      | Test |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.serialNumberInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.deviceTypeInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.interrogationAddressInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |
    And I validate error "Only numbers are valid characters." for ActivateThingPage.externalIDInputField with these characters
      | Test |

    And I verify that "aria-checked" for ActivateThingPage.interrogationPeriodInputField is set to "false"
    Then I click Element ActivateThingPage.interrogationPeriodSwitcher using Javascript
    And I verify that "aria-checked" for ActivateThingPage.interrogationPeriodInputField is set to "true"
    And I click ActivateThingPage.interactionModeField
    And I should see these options
      | gateway    |
      | greengrass |
      | direct     |

        ########################

    Then I click HomePage.hamburgerMenuIcon
    Then I click SidebarPage.devicesOption
#    Then I type "gateway" into the element DevicesPage.searchBox
    And I wait 10 seconds
    Then I click DevicesPage.iconDetailsFirstRow
    And I click DevicesDetailsPage.enterToThingsList
    And I click DevicesDetailsPage.threeDotsButton
    And I click DevicesDetailsPage.activateThingsBTN

    And I click ActivateThingPage.inputField
    And I click ActivateThingPage.DDMOption that contains "lora_ns"
    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.modelInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.makerInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. #, $, %, &, *, è) are not valid." for ActivateThingPage.aliasInputField with these characters
      | # |
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.radioTypeInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |
    And I validate error "The IP address must have the IPv4 format (example: 192.168.1.100)" for ActivateThingPage.IPAddressInputField with these characters
      | Test |
    And I validate error "Only numbers are valid characters." for ActivateThingPage.portNumberInputField with these characters
     | Test |
    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.serialNumberInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Special characters (eg. $, %, &, *, è) are not valid." for ActivateThingPage.deviceTypeInputField with these characters
      | $ |
      | % |
      | & |
      | * |
      | è |

    And I validate error "Only numbers are valid characters." for ActivateThingPage.externalIDInputField with these characters
      | Test |

    And I click ActivateThingPage.interactionModeField without scroll
    And I should see these options
      | gateway    |
      | greengrass |
      | direct     |

    Then I click on the user icon and log out.
