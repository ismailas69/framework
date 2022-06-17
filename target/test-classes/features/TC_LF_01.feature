@Test
Feature: Filter

  Scenario Outline:FilterBy

    Given navigates to Monrningstar page
    And click on Login option
    Then validate user is on Login page
    When user enters email "<email>"  and password "<password>"
    And user click login button
    Then verify user logged in and taken to Account page

Examples: