Feature: Sorting A To Z Order
  I want to sort all products from low Alphabetic in our sauce demo

  Scenario Outline: Sorting A To Z Order
    Given the user is on the products page after logging in successfully with I enter "<username>" , "<password>"
    When the user selects Sort by Alphabetic (Ascending) from the sorting options
    Then all products should be displayed in alphabetical order

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |





