Feature: Navbar Features

  @navbar
  Scenario: Navbar is responsive to user input
    Given I have logged into swaglabs
    When I go to the inventory page
    And The navigation sidebar should exist
    Then I click on the navbar icon

  @navbar
  Scenario Outline: Clicking on a sidebar feature should bring you to it's respective destination
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