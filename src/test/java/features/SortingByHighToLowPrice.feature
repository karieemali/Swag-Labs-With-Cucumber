Feature: Sorting From High Price
  I want to sort all products from high price in our sauce demo

  Scenario Outline: Sorting From High Price
    Given the user is on the products page after Logging in Successfully With I enter "<username>" , "<password>"
    When the user selects Sort by Price (High) from the sorting options
    Then all products should be displayed in High Price order

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |





