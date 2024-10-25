@api
Feature: Get a rate


  Scenario: Verify that a user can get a correct rate
    Given that a user make a Get request to get rate
    And i should get a 200 status code
    Then i should be able to get a correct rate
      | rate | fromCurrency | toCurrency |
      | 2000 | GBP          | NGN        |


  @createRate
  Scenario: Verify that a user can set a rate successfully
    Given that a user make a Post request to set rate
      | rate | fromCurrency | toCurrency |
      | 2000 | GBP          | NGN        |
    And i should get a 200 status code
    Then the response message should be "Rate changed successfully!"
