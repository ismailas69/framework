@Register_user
Feature: TS_001_Register_Functionality

  Scenario Outline:
    Given user click on My Account dropdown
    When user clicks on register button from dropdownlist
    And user provides firstname <"firstname">
    And user provides lastname<"lastname">
    And user provides email <"email">
    And user provides telephone <"telephone">
    And user provides password <"password">
    When user confirms password <"confirm">
    And user click privacy policy
    When user click submit button
    Then user verify "Account Success" message appears
    Then user verify user takn to Account page and email should sent to registred email address



    Examples:
    |firstname|lastname|email|telephone|password|confirm|
    |Sam      |gun     |samgun@gmail.com|1234567890|12mnbvQw!|12mnbvQw!|
