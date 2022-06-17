@loginOpenChart
Feature: TS_002 login functionality
  @login_valid
  Scenario Outline:TC_LF_001_validate_with_valid_credentials

    Given user click on My Account dropdown
    And click on Login option
    Then validate user is on Login page
    When user enters email "<email>"  and password "<password>"
    And user click login button
    Then verify user logged in and taken to Account page


Examples:valid_credential
    |email|password|
    |ismailasan1@gmail.com|ismail1234|

@Login_invalid
    Scenario Outline: TC_LF_002_validate_with_invalid_email_invalid_password
      Given user click on My Account dropdown
      And click on Login option
      Then validate user is on Login page
      When user enters email "<email>"  and password "<password>"
      And user click login button
      Then verify user cannot logged in and warning message visible


      Examples: invalid_credential
        |email|password|
        |@gmail.com|ismail12|

  @Login_invalid
  Scenario Outline: TC_LF_003_validate_with_invalid_email_valid_password
    Given user click on My Account dropdown
    And click on Login option
    Then validate user is on Login page
    When user enters email "<email>"  and password "<password>"
    And user click login button
    Then verify user cannot logged in and warning message visible


    Examples: invalid_credential
      |email|password|
      |@gmail.com|ismail1234|

  @Login_invalid
  Scenario Outline: TC_LF_004_validate_with_valid_email_invalid_password
    Given user click on My Account dropdown
    And click on Login option
    Then validate user is on Login page
    When user enters email "<email>"  and password "<password>"
    And user click login button
    Then verify user cannot logged in and warning message visible


    Examples: invalid_credential
      |email|password|
      |ismailasan1@gmail.com|ismail12|

  @Login_invalid
  Scenario Outline: TC_LF_005_validate_without_providing_credential
    Given user click on My Account dropdown
    And click on Login option
    Then validate user is on Login page
    When user enters email "<email>"  and password "<password>"
    And user click login button
    Then verify user cannot logged in and warning message visible


    Examples: invalid_credential
      |email|password|
      |     |        |

  Scenario: TC_LF_006_Validate_forgetten_password_link
    When user click on My Account dropdown
    And click on Login option
    Then validate user is on Login page and forgotten password link is displayed
    When user clicks on forgotten password link
    Then verify user is in forgotten password page


@Tabs
  Scenario Outline: TC_LF_007_validate_login_with_TAB_ENTER_keys
    Given user click on My Account dropdown
    And click on Login option
    And user navigates to emailtextbox by clicking Keys.tab
    And user enters email "<email>"
    And user navigates to passwordtextbox by clicking Keys.tab
    And user enters password "<password>"
    And user navigates to login button by clicking Keys.tab
    And user click login button by Keys.Enter
    Then verify user logged in and taken to Account page


    Examples:valid_credential
      |email|password|
      |ismailasan1@gmail.com|ismail1234|

  @placeholder
  Scenario: TC_LF_008_verify_placeholder_email_password_textbox
  Given user click on My Account dropdown
  And click on Login option
  Then verify placeholder text in the email and address textbox

  @login_navigate_back
  Scenario Outline:TC_LF_009_Validate Logging into the Application and browsing back using Browser back button

    Given user click on My Account dropdown
    And click on Login option
    When user enters email "<email>"  and password "<password>"
    And user click login button
    And user click on Browser back button
    Then verify user logged in and taken to Account page

    Examples:valid_credential
      |email|password|
      |ismailasan1@gmail.com|ismail1234|

  @login_navigate_back_2
  Scenario Outline:TC_LF_0010_Validate Loggingout from the Application and browsing back using Browser back button
    Given user click on My Account dropdown
    And click on Login option
    When user enters email "<email>"  and password "<password>"
    And user click login button
    And user click on My Account dropdown loggedin
    When user click logout button
    And user click on Browser back button
    Then verify user not logged in again

    Examples:valid_credential
      |email|password|
      |ismailasan1@gmail.com|ismail1234|

    @test
    Scenario:right_click
      Given user click on My Account dropdown
      And click on Login option
      And user right clicks to password text box
      Then verify copy is disabled