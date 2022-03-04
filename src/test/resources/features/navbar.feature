Feature: As a customer, I should be able to use the navigation menu to navigate to different areas of the website.

  Scenario: As a customer the navbar should be responsive to user interaction
    Given I have logged into swaglabs
    When I go to the inventory page
    And The navigation sidebar should exist
    Then I click on the navbar icon

  @navbar
  Scenario Outline: As a customer clicking on a sidebar feature should bring me to it's respective destination
    Given I have logged into swaglabs
    When I go to the inventory page
    And I click on the navbar icon
    And I click on "<option>"
    Then I should be taken to "<result>"

    Examples:
      | option          | result                                   |
      | All Items       | https://www.saucedemo.com/inventory.html |
      | About           | https://saucelabs.com/                   |
      | Logout          | https://www.saucedemo.com/               |
      | Reset App State | https://www.saucedemo.com/inventory.html |