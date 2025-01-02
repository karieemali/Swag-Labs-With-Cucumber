Feature: Automated End2End Tests
  User can add some products to your cart and finally checkout price this products added our sauce demo

  Scenario Outline: Automated End2End Tests
    Given The user Is on the products page after logging in successfully with I entered "<username>" , "<password>"
    When The user selects Sort by Alphabetic (Ascending) from the sorting options
    And I Will Add products to cart from the products page
    And I will Navigate to Checkout page and entered "<firstname>" , "<lastname>" ,"<postalCode>"
    And Print to a successfully message and back home
    And I will Reset App State from all actions in site
    Then User Logout From Site

    Examples:
      | username      | password     | firstname | lastname | postalCode |
      | standard_user | secret_sauce | karim     | ali      | 17352      |






