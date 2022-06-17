@Dropdown
Feature: Dropdown
  Scenario Outline: Test_dropdown
    Given user navigates to Morningstar
    When user select value "<value>" show number of index per page dropdown
Examples:
    |value|
    |10|
    |20|
    |50|
