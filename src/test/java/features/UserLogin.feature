Feature: User Login
  I want to check that the user can login with standard_user in our sauce demo

  Scenario Outline: User Login
    Given The user in the login page
    When I entered "<username>" , "<password>"
    And I click on login bottom
    Then Move to the products page successfully
    Then user can logout from site

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |




