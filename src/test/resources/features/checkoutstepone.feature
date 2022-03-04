Feature: As a Buyer I expect to have to input a valid first name last name and Post code

  Scenario: Valid Name and Post code input
    Given I have Access to Checkout Step One Page
    And I Enter a valid first name
    And I enter a valid last name
    And I enter a valid postal code
    And I click continue expecting success
    Then I should be on checkout step two

  @InvalidInput
  Scenario Outline: At least one of the Inputs are Invalid
    Given I have Access to Checkout Step One Page
    And I enter a first name "<firstName>" on the page
    And I enter a last name of "<lastName>" on the page
    And I enter a post code of "<postalCode>" on the page
    And I click continue expecting failure
    Then I should be on the same page

    Examples:

      | firstName | lastName | postalCode |
      | Foo       |          | B14 12DS   |

