# PEGA TFA Automation Suite

This repository contains functional automated UI tests for Pega at TFA.

For more information, refer to the [Confluence page](https://tfal.atlassian.net/wiki/spaces/TEST/pages/49774935/Pega+Test+Automation).

## Setup

The automation suite has a dependency on DX' Ceres Core:

    git clone https://bitbucket.org/dxdevops/dx_ceres_core.git
    cd dx_ceres_core
    mvn install
    cd ..

## Executing

The project uses [cucumber-java](https://github.com/cucumber/cucumber-jvm) with [TestNG runners](https://github.com/cucumber/cucumber-jvm/tree/main/testng).

Tests are run using standard Maven commands:

    # Run with default QuotesTestSuite.xml and Test test group
    mvn clean install
        
    # Specifying a different TestNG .xml file  
    mvn clean install -Dtestng.suitefile="SuiteFiles/QuotesTestSuite.xml"
    
    # Specifying a specific test:
    mvn clean install -Dtestng.testnames=Shakeout
    
    # Specifying cucumber options
    # Refer to https://cucumber.io/docs/cucumber/api/#options for more details
    # NOTE This overwrites existing cucumber options in the Runner class
    mvn clean test "-Dcucumber.execution.dry-run=true" "-Dcucumber.plugin=tfa.PEGA.custommethods.CustomLogger"
# DemoRepositoryForCBAbyKavya
