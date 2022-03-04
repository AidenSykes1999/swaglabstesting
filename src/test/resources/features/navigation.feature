@Navigation
Feature: As a customer I want to be able navigate round the website


#  Go to the cart from different places
  Scenario Outline: I want to access the cart
    Given I am on the <page> page
    When I click on the cart icon
    Then I am on the cart page
    Examples:

#  Continue shopping
  Scenario: I want to go back to the products from the cart
    Given I navigate to the cart page
    When I click continue shopping
    Then I arrive at the products page

#  Go back from individual products
  Scenario Outline: : I want to go back to the inventory from each product page
    Given I on on the <product> page
    When I click back to products
    Then I go back to the inventory page
    Examples:

#  Go to checkout your information
  Scenario: I want to checkout from the cart page
    Given I navigate to the cart page
    When I click checkout
    Then I am on the checkout your information page

#  Cancel from checkout: your information
  Scenario: I want to cancel checking out when I am entering my information
    Given I navigate to the checkout your information page
    When I click cancel
    Then I am on the cart page

#  Go to checkout: overview
  Scenario: I want to see an overview of the checkout
    Given I have entered my information
    When I click continue
    Then I am on the checkout: overview page

#  Cancel from checkout overview
  Scenario: I want to cancel checking out from the checkout overview page
    Given I am on the checkout overview page
    When I click on cancel
    Then I go back to the inventory page

#  Finish from checkout overview
  Scenario: I want to finish checking out
    Given I am on the checkout overview page
    When I click on finish
    Then I go back to the checkout complete page

#  After finishing go back to the home page
  Scenario: I want to go back to the home page after checking out
    Given I am on the checkout: finish page
    When I click on Back Home
    Then I go back to the inventory page

#  Go to facebook
  Scenario Outline: I want to click on the facebook link
    Given I am on the <page>
    When I click the facebook icon
    Then I go to the sauce labs facebook
    Examples:
#    inventory page, cart, check1, check2, individual products

#  Go to linkedin
  Scenario Outline: I want to click on the linkedin link
    Given I am on the <page>
    When I click the facebook icon
    Then I go to the sauce labs linkedin
    Examples:
#    inventory page, cart, check1, check2, individual products

  #  Go to twitter
  Scenario Outline: I want to click on the twitter link
    Given I am on the <page>
    When I click the facebook icon
    Then I go to the sauce labs twitter
    Examples:
#    inventory page, cart, check1, check2, finish, individual products


  ## might not need these as aiden might have covered it
  #  Use navbar to go to all items
  Scenario Outline: I want to click on navbar all items link
    Given I am on the <page>
    When I click the burger icon
    And I click all items
    Then I go back to the inventory page
    Examples:
#    inventory page, cart, check1, check2, finish, individual products

  #  Use navbar to go to all items
  Scenario Outline: I want to click on navbar about link
    Given I am on the <page>
    When I click the burger icon
    And I click about
    Then I go to the sauce labs website
    Examples:
#    inventory page, cart, check1, check2, finish, individual products

    #  Use navbar to logout
  Scenario Outline: I want to click on navbar logout link
    Given I am on the <page>
    When I click the burger icon
    And I click logout
    Then I go back to the login page
    Examples:
#    inventory page, cart, check1, check2, finish, individual products


