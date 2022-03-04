Feature: Testing the elements on the cart page

  Scenario Outline: Product page can be accessed by clicking on product names
    Given <product> has been added to the cart
    When I click on <product>
    Then I go to <product> page

    Examples:
      |product|
      |Bike Light|
      |Backpack  |
      |Bolt T-Shirt|
      |Fleece Jacket|
      |Onesie       |
      |Test.allTheThings() T-Shirt (Red)|


  Scenario Outline: Items can be removed from the cart
    Given <product> has been added to the cart
    When I click remove for <product>
    Then <product> is not in cart

    Examples:
    |product|
    |Bike Light|
    |Backpack  |
    |Bolt T-Shirt|
    |Fleece Jacket|
    |Onesie       |
    |Test.allTheThings() T-Shirt (Red)|
