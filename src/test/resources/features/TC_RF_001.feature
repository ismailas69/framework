@Deneme
Feature: TS_001_Register_Functionality

  Scenario Outline:
    Given user navigates to Morningstar
    When user sends keyword "<keyword>" to keyword search box
    And user clicks on enter button
    Then user should be able to see "<keyword>" in all Index Name field

    Examples:
    |keyword|
    |wide   |
    |xxxxx  |
    |x1y1   |
    |!?@&   |



