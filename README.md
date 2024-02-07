# CBA Automation Suite

This repository contains functional automated tests for Swagger APIs

## Setup

The automation suite has a dependency on Java, selenium and Cucumber 


## Executing

The project uses [cucumber-java](https://github.com/cucumber/cucumber-jvm) with [TestNG runners](https://github.com/cucumber/cucumber-jvm/tree/main/testng).

Tests are run using standard Maven commands:

    # Run with default TestSuite.xml and Test test group
    mvn clean install
        
    # Specifying a different TestNG .xml file  
    mvn clean install -Dtestng.suitefile="SuiteFiles/TestSuite.xml"
    
    # Specifying a specific test:
    mvn clean install -Dtestng.testnames=Shakeout
    
    # Specifying cucumber options
    # Refer to https://cucumber.io/docs/cucumber/api/#options for more details
    
# DemoRepositoryForCBAbyKavya
