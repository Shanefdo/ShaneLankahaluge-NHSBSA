# ShaneLankahaluge-NHSBSA
This project created to test the functionality of the NHS Jobs search

# Read me First
This document has been created to show how test the functionality of the NHS Jobs search.

* Functionality carried out with Cucumber Framework with Java Selenium

  # Getting Started

  ### Guides
  Following are the guidlines which needs to be followed to run the project
  * Latest version chrome for testing can be downloaded from: https://googlechromelabs.github.io/chrome-for-testing/
    * User have to have latest Chrome version: 124
    * User have to have latest Chromedriver version: 124
  * Latest version for geckodriver can be downloaded from: https://github.com/mozilla/geckodriver/releases
    * Use have to have Firefox browser: 126

  # Technology used
  * selenium-java: 4.20.0
  * Java 11
  * cucumber-java: 7.11.1
  * testng: 7.5.1
  * maven-surefire-plugin: 2.20
  * maven-project-info-reports-plugin: 3.0.0
 
  # Command Line options to run the project
  * Run all tests: mvn test
  * Run Specific feature: mvn test -Dcucumber.options="src/test/resources/features/searchjobspage.feature"
  * Run specific scenario: mvn test -Dcucumber.options="src/test/resources/features/searchjobspage.feature:8"
  * Run with tags: mvn test -Dcucumber.options="-- tags @SmokeTest” / mvn test -Dcucumber.options=“-t @SmokeTest” 
