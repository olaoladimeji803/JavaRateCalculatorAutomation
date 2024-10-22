Feature: RateCalculator
  @web
  Scenario: 01_Verify that a user can convert pounds to naira
    Given that a user loads an application under test
    When a user inputs 5 into GBP text field
    Then a user sees 10000.00 value in NGN text field
    When a user clicks on Send Now button
    And a user selects "Union Bank" as the bank option
    And a user inputs "1234567891" as the account number
    And a user clicks on Send button
    Then the text "Transaction successful!" message should appear