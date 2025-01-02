Feature: Sorting From Low Price
  I want to sort all products from low price in our sauce demo

  Scenario Outline: Sorting From Low Price
    Given the user is on the products page after logging in Successfully With I enter "<username>" , "<password>"
    When the user selects Sort by Price (Low) from the sorting options
    Then all products should be displayed in Low Price order

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |





