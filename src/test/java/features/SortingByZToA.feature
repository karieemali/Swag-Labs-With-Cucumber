Feature: Sorting Z To A Order
  I want to sort all products from high Alphabetic in our sauce demo

  Scenario Outline: Sorting Z To A Order
    Given the user is on the products page after logging in successfully With I enter "<username>" , "<password>"
    When the user selects Sort by Alphabetic (Descending) from the sorting options
    Then all products should be displayed in Descending alphabetical order

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |





