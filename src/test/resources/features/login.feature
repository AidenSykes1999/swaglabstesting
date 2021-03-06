Feature: As a customer I want to be able to login onto the website, so I can access my account and shop

  @login
  Scenario: As a customer I want that the login functionality exists
    Given I have opened the browser
    When I open Swaglabs website
    Then username box should exist
    And password box should exist
    And login button should exist

  @login
  Scenario Outline: As a customer I want the login to work for <username> with correct credentials
    Given I have opened the browser
    When I open Swaglabs website
    And I enter the username <username>
    And I enter the password <password>
    And I click login button
    Then the inventory page should be displayed
    Examples:
      | username                | password      |
      | standard_user           | secret_sauce  |
      | problem_user            | secret_sauce  |
      | performance_glitch_user | secret_sauce  |

  @login
  Scenario Outline: As a customer, I want that the login doesn't work for <username> with incorrect <password>
    Given I have opened the browser
    When I open Swaglabs website
    And I enter the username <username>
    And I enter the password <password>
    And I click login button
    Then the error <message> is displayed
    Examples:
      | username                | password      | message                                                                   |
      | locked_out_user         | secret_sauce  | Epic sadface: Sorry, this user has been locked out.                       |
      |                         |               | Epic sadface: Username is required                                        |
      | standard_user           |               | Epic sadface: Password is required                                        |
      | standard_user           | test          | Epic sadface: Username and password do not match any user in this service |
      | test                    | secret_sauce  | Epic sadface: Username and password do not match any user in this service |