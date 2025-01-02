Feature: Checkout products
  I want to Checkout Added products to cart in our sauce demo

  Scenario Outline: Checkout products
    Given The user is on the products page after logging in successfully with I entered "<username>" , "<password>"
    When I will add products to cart from the products page
    And I will navigate to Checkout page and entered "<firstname>" , "<lastname>" ,"<postalCode>"
    Then print to a successfully message and back home
    Then User logout from site

    Examples:
      | username      | password     | firstname | lastname | postalCode |
      | standard_user | secret_sauce | karim     | ali      | 17352      |






