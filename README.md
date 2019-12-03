# API Test Automation

 This repository contains API Automated tests for JsonPlaceholder


# Installation

#### Dependencies : Maven, RestAssured, Cucumber JVM, Faker


# Usage

User can run the tests either from Command Line or using InelliJ

To Run tests using Maven --
run from Project Root Directory

  #### in Windows 10:  mvn clean test -DtestEnv="test"   
  
 

# NOTE

1.  As JSONPlaceholder is a free online REST API  (read-only), only validating response code for POST request
    Not validating data successfully stored on backend
    
2.  Added tests to cover "Create Post" only, as rest of operation would be similar


# TO-DO IMPROVEMENTS
   