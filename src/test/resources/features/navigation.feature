Feature: As a customer I want to be able navigate round the website

  @navigation
  Scenario Outline: I want to access the cart
    Given I navigate to the <page> page
    When I click on the <page> page cart icon
    Then I am on the cart page
    Examples:
      |page|
      |cart|
      |products|
      |checkout finish|
      |checkout overview|
      |checkout your information|
      |random product|

  @navigation
  Scenario: I want to go back to the products from the cart
    Given I navigate to the cart page
    When I click continue shopping
    Then I arrive at the products page

  @navigation
  Scenario: I want to go back to the inventory from each product page
    Given I navigate to the random product page
    When I click back to products
    Then I go back to the inventory page

  @navigation
  Scenario: I want to checkout from the cart page
    Given I navigate to the cart page
    When I click checkout
    Then I am on the checkout your information page

  @navigation
  Scenario: I want to cancel checking out when I am entering my information
    Given I navigate to the checkout your information page
    When I click cancel from your information
    Then I am on the cart page

  @navigation
  Scenario: I want to see an overview of the checkout
    Given I navigate to the checkout your information page
    And I have entered my information
    When I click continue
    Then I am on the checkout overview page

  @navigation
  Scenario: I want to cancel checking out from the checkout overview page
    Given I navigate to the checkout overview page
    When I click on cancel from overview
    Then I go back to the inventory page

  @navigation
  Scenario: I want to finish checking out
    Given I navigate to the checkout overview page
    When I click on finish checkout
    Then I go to the checkout complete page

  @navigation
  Scenario: I want to go back to the home page after checking out
    Given I navigate to the checkout finish page
    When I click on Back Home
    Then I go back to the inventory page

  @navigation
  Scenario Outline: I want to click on the linkedin link
    Given I navigate to the <page> page
    When I click the <page> page linkedin icon
    Then I go to the sauce labs linkedin
    Examples:
      |page|
      |cart|
      |products|
      |checkout finish|
      |checkout overview|
      |checkout your information|
      |random product|


  @navigation
  Scenario Outline: I want to click on the twitter link
    Given I navigate to the <page> page
    When I click the <page> page twitter icon
    Then I go to the sauce labs twitter
    Examples:
      |page|
      |cart|
      |products|
      |checkout finish|
      |checkout overview|
      |checkout your information|
      |random product|

  @navigation
  Scenario Outline: I want to click on the facebook link
    Given I navigate to the <page> page
    When I click the <page> page facebook icon
    Then I go to the sauce labs facebook
    Examples:
      |page|
      |cart|
      |products|
      |checkout finish|
      |checkout overview|
      |checkout your information|
      |random product|

  @navigation
  Scenario Outline: I want to click on navbar all items link
    Given I navigate to the <page> page
    When I click the <page> page burger icon
    And I click all items
    Then I go back to the inventory page
    Examples:
      |page|
      |cart|
      |products|
      |checkout finish|
      |checkout overview|
      |checkout your information|
      |random product|


  @navigation
  Scenario Outline: I want to click on navbar about link
    Given I navigate to the <page> page
    When I click the <page> page burger icon
    And I click about
    Then I go to the sauce labs website
    Examples:
      |page|
      |cart|
      |products|
      |checkout finish|
      |checkout overview|
      |checkout your information|
      |random product|

  @navigation
  Scenario Outline: I want to click on navbar logout link
    Given I navigate to the <page> page
    When I click the <page> page burger icon
    And I click logout
    Then I go back to the login page
    Examples:
    |page|
    |cart|
    |products|
    |checkout finish|
    |checkout overview|
    |checkout your information|
    |random product|