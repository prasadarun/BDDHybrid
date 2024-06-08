Feature: Login Functionality

  # repeated statement are represented with background keyword sho that will remove steps duplication
  Background: 
    Given Navigate to login page

  @login
  Scenario: Login with valid credentails
    When User enters the valid email address "durgaprasad534211@gmail.com" into email text field
    And User enters the valid password "Test@1234" into password text field
    And Click on Login button

  @login
  Scenario: Login with invalid email
    When User enters the invalid email address "durgaprasad" into email text field
    And User enters the valid password "Test@1234" into password text field
    And Click on Login button
    Then User should not be login successfully

  @login
  Scenario: Login with invalid password
    When User enters the invalid password "durgaprasad534211@gmail.com" into password text field
    And User enters the valid password "Test@1234" into password text field
    And Click on Login button
    Then User should not be login successfully

  @login
  Scenario: Login with empty email
    And User enters the valid password "Test@1234" into password text field
    And Click on Login button
    Then User should not be login successfully

 @loginWithDB
  Scenario: User logs in using credentials from a database
    Given I have a valid database connection with "username" "password" "account" "query"
    And enter the fetched "username" and "password" in login page
    And Click on Login button
    Then User should not be login successfully

  @DBlogin
  Scenario: User logs in using credentials from a database
    Given I have a valid database connection with "<user>" "<password>" "<account>" "<query>"
    And enter the fetched "<username>" and "<password>" in login page and check the login status
    
    
 @ExcelDataLogin
   Scenario: Login with valid credentials from Excel
    Given I have valid credentials in Excel sheet "lgn"
    And enter the fetched "<username>" and "<password>" in login page and check the login status
