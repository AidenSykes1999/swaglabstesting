# Swag Lab Testing Project

> Contributors:
>
> • Roberto Lovece - Junior Java SDET Consultant | [Portfolio](https://robertolovece.github.io/Portfolio-Website/) | [GitHub](https://github.com/RobertoLovece) | [LinkedIn](https://www.linkedin.com/in/roberto-lovece-20abb121a/) |
>
> • Antony Ademefun - Junior Java SDET Consultant | [GitHub](https://github.com/antonya3) | [LinkedIn](https://www.linkedin.com/in/antony-ademefun/) |
>
> • Mihai Udrea - Junior Java SDET Consultant | [GitHub](https://github.com/udreamihai) | [LinkedIn](https://www.linkedin.com/in/mihai-udrea-307885b7/) |
>
> • Aiden Sykes - Junior Java SDET Consultant | [GitHub](https://github.com/AidenSykes1999) | [LinkedIn](https://www.linkedin.com/in/aiden-sykes/) |
>
> • Piotr Sulek - Junior Java SDET Consultant | [GitHub](https://github.com/piotr02) | [LinkedIn](https://www.linkedin.com/in/piotr-sulek/) |
>
> • Harry Lewis - Junior Java SDET Consultant | [GitHub](https://github.com/harrylewis955) |
> 
> • Brandon Johnson - Junior Java SDET Consultant | [GitHub](https://github.com/brandonj987) |
>
>

## **Table Of Contents**
* [**Overview**](#overview)
* [**Project Requirements**](#project-requirements)
* [**Project Management**](#project-management)
* [**Testing**](#testing)
* [**Software & Dependencies**](#software--dependencies)
* [**How To Use**](#how-to-use)
  * [Downloading and opening the project](#downloading-and-opening-the-project)
  * [Setting up the web drivers](#setting-up-the-web-drivers)
  * [Running the tests](#running-the-tests)
* [**Future Work**](#future-work)

### Overview
This is a testing framework for the [Swag Labs](https://www.saucedemo.com/)
website, developed as part of the [Sparta Global](https://www.spartaglobal.com/) 
training. The purpose of this project is to allow the website to be
tested easily by providing modular methods that can be used to check
different web elements. The project includes Cucumber and JUnit tests,
but further tests can be created based on the framework.

### Project Requirements
Web API Project For this project, you will be building a testing framework to test [Saucedemo.com](https://www.saucedemo.com/)

Page Object Model You will need to create a Page object model that testers could use. This will abstract away the webdriver and provide helper methods to make testing easier.

BDD You will also be implementing a BDD layer using Cucumber. This will allow testing to happens against acceptance criteria using feature files.

Artifacts  - Kanban Board - README file explaining how to use the framework to perform tests.

Git - Master branch can only contain production ready code. No code can be submitted to the master branch without being approved by the scrum master - Dev branch should contain development features that have been tested, reviewed and approved. No code can be submitted to the dev branch without being approved by 2 members of the team - Feature branches contain features that are being worked on. These will be numerous and a suitable naming strategy needs to be used. Aim to have a branch for each feature you are working on. - Web drivers should **NOT** be pushed to Github.

Presentation At the end of the week, you will be presenting your framework. The aim will be to demonstrate how it works. This will be aimed at testers looking to use your framework.

### Project Management
The project has been developed in 3 days, by a 7-person-team. The agile approach
has been used, with SCRUM meetings in the morning and evening on each day.

* The tools used for communication within the team were Discord and MS Teams.
* GitHub and GitHub Desktop were used for version control.
* Trello was used for planning the work and distributing tasks.
Below image shows the Kanban board created using Trello:

![Trello](images/trello.png)

### Testing
The project followed the Behavior Driver Development (BDD) approach.
User stories were written to define what behavior needs to be tested, based
on the potential user's needs.

User stories used for the tests:

![BDD1](images/bdd1.png)
![BDD2](images/bdd2.png)
![BDD3](images/bdd3.png)

Some internal JUnit testing has also been done to test the web drivers.

### Software & Dependencies
#### [IntelliJ IDEA 2021.3.1 (Ultimate Edition)](https://www.jetbrains.com/idea/download/#section=windows)
#### [JDK 17.0.2](https://jdk.java.net/17/)
#### [Apache Maven](https://maven.apache.org/)
  * _**Note:** This dependency can be imported using IntelliJ._
  * _Go to **"File" > "New Project"** and then selecting **"Maven"** as the project structure._
#### [JUnit Jupiter API 5.8.2](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.2)
  * _**Note:** This dependency can be imported within Intellij using Apache Maven and IntelliJ's built-in dependency generator._
  * Alternatively you can open the Maven **"pom.xml"** file and paste in the following code within the **"dependencies"** section of the file:
```xml
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.8.2</version>
    </dependency>
```
#### [Cucumber JVM: Java 7.2.3](https://mvnrepository.com/artifact/io.cucumber/cucumber-java/7.2.3)
  * _**Note:** This dependency can be imported within Intellij using Apache Maven and IntelliJ's built-in dependency generator._
  * Alternatively you can open the Maven **"pom.xml"** file and paste in the following code within the **"dependencies"** section of the file:
```xml
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.2.3</version>
    </dependency> 
```
#### [Cucumber JVM: JUnit 7.2.3](https://mvnrepository.com/artifact/io.cucumber/cucumber-java/7.2.3)
  * _**Note:** This dependency can be imported within Intellij using Apache Maven and IntelliJ's built-in dependency generator._
  * Alternatively you can open the Maven **"pom.xml"** file and paste in the following code within the **"dependencies"** section of the file:
```xml
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>7.2.3</version>
    </dependency>
```
#### [Selenium Java 4.1.2](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.1.2)
  * _**Note:** This dependency can be imported within Intellij using Apache Maven and IntelliJ's built-in dependency generator._
  * Alternatively you can open the Maven **"pom.xml"** file and paste in the following code within the **"dependencies"** section of the file:
```xml
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.1.2</version>
    </dependency>
```

### How To Use

#### Downloading and opening the project
1. Download the project by clicking Code > Download ZIP as shown below

![HowToDownload](images/howToDownload.png)

2. Right-click on the downloaded file and press "Extract all"
3. Open IntelliJ Community or Ultimate Edition and navigate to File > Open
4. Select the unzipped project folder and press Ok

#### Setting up the web drivers
1. Download the web driver for the browser you wish to use.
Available browsers are: Chrome, Firefox, Opera, and Edge.
Make sure the version of the driver matches the version
of the browser you have installed.
2. Place the web driver in src/test/resources/drivers
3. Create a "WebDriver.properties" file in src/test/resources
4. Inside the file, specify the path to the web driver/s as shown below, do not include file extensions (e.g. .exe)
```properties
ChromeDriverPath= src/test/resources/drivers/chromedriver
FirefoxDriverPath= src/test/resources/drivers/geckodriver
OperaDriverPath= src/test/resources/drivers/operadriver
EdgeDriverPath= src/test/resources/drivers/msedgedriver
```
The project structure should look like this:

![projectStructure](images/projectStructure.png)

5. Inside stepDef files, specify which browser you wish to use, as shown below.
You only need to change the word "CHROME". Available options are
"CHROME", "OPERA", "EDGE", "FIREFOX".

![webDriverSetup](images/webDriverSetup.png)

#### Running the tests
You can run each .feature file separately. Feature files
are found in src/test/resources/features.
You can also run tests by using the TestRunner found in
src/test/java/com/sparta/swaglabtesting.
You can use tags to specify which tests to run or leave the tag
empty to run them all.

![testRunner](images/testRunner.png)

### Future Work
Possible extensions of the projects could include:
- adding support for more browsers
- adding support for MAC OS
