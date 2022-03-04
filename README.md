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
* [**Software & Dependencies**](#software-&-dependencies)
  - [IntelliJ IDEA 2021.3.1 (Ultimate Edition)](#intellij-idea-2021.3.1-(ultimate-edition))
  - [JDK 17.0.2](#jdk-17.0.2)
  - [Apache Maven](#apache-maven)
  - [JUnit Jupiter API 5.8.2](#junit-jupiter-api)
  - 

### Overview
This is a testing framework for the [Swag Labs](https://www.saucedemo.com/)
website, developed as part of the [Sparta Global](https://www.spartaglobal.com/) 
training. The purpose of this project is to allow the website to be
tested easily by providing modular methods that can be used to check
different web elements. The project includes Cucumber and JUnit tests,
but further tests can be created based on the framework.

### Software & Dependencies
* [IntelliJ IDEA 2021.3.1 (Ultimate Edition)](https://www.jetbrains.com/idea/download/#section=windows)
* [JDK 17.0.2](https://jdk.java.net/17/)
* Apache Maven
    * _**Note:** This dependency can be imported using IntelliJ._
    * _Go to **"File" > "New Project"** and then selecting **"Maven"** as the project structure._
* [JUnit Jupiter API 5.8.2](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.2)
  * _**Note:** This dependency can be imported within Intellij using Apache Maven and IntelliJ's built-in dependency generator._
  * Alternatively you can open the Maven **"pom.xml"** file and paste in the following code within the **"dependencies"** section of the file:
```xml
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.8.2</version>
    </dependency>
```

