Feature: Add products to cart
  I want to Add products to cart in our sauce demo

  Scenario Outline: Add products to cart
    Given the user is on the products page after logging in successfully with I entered "<username>" , "<password>"
    When I add products to cart from the products page
    And I remove products to cart from the cart page
    Then user logout from site

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |






