@AcceptanceTest
Feature: Buying from amazon

  Scenario: Add items to cart
    Given I have open HomePage
    When I search item "Hats for men"
    When I open the item "1"
    When I add "2" in quantity
    When I open the cart
    Then Verify price and quantity
    When I change quantity in cart to "1"
    Then Verify price and quantity