Feature: Checkout Step One

  Scenario: Valid Name and Post code input
    Given I have Access to Checkout Step One Page
    And I Enter a valid first name
    And I enter a valid last name
    And I enter a valid postal code
    And I click continue expecting success
    Then I should be on checkout step two

  Scenario: At least one of the Inputs are Invalid
    Given I have Access to Checkout Step One Page
    And I enter a <first name>
    And I enter a <last name>
    And I enter a  <postal code>
    And I click continue expecting failure
    Then I should see an error message in the Checkout Step One Page
