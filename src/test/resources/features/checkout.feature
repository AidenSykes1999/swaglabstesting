Feature: As a customer I want to be able to buy a product that is in my cart

  Scenario: As a customer I need to be able to enter my first name last name
    and post code so that I can proceed with my purchase
    Given I am on the checkout step one page
    And I enter a first name, last name and postal code
    When I click on continue
    Then I should be on checkout step two

  @InvalidInput
  Scenario Outline: As a customer, if I don't enter in all my details then I shouldnt
                    be able to proceed with my purchase
    Given I am on the checkout step one page
    And I enter a first name of"<firstName>" last name of "<lastName>" and a postal code of "<postalCode>"
    When I click on continue
    Then I should be on the same page
    Examples:

      | firstName | lastName | postalCode |
      | Foo       |          | B14 12DS   |

  Scenario: As a customer, I want to be able to go back from the Checkout: your information page
            if I decide I do not want to continue checking out
    Given I am on the checkout step one page
    When I click on cancel
    Then I should go back to the cart page

  Scenario: As a customer, I want to be able to go back from the Checkout: overview page
            if I decide I do not want to continue checking out
    Given I am on the checkout step two page
    When I click on cancel on the overview
    Then I should go back to the inventory page

  Scenario: As a customer, I want to be able to see an overview of my order to confirm if it is correct
    Given I have a Backpack and a Bike light in the cart
    When I have navigated to the Checkout Step Two Page
    Then I should have an item total of thirty nine ninety eight

  Scenario: As a customer, I want to be able to complete my order if im happy with
            the result from the checkout overview
    Given I am on the checkout step two page
    When I click on finish
    Then I should go to the checkout complete page

