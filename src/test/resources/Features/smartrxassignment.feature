Feature: feature to test smartrxassignment functionality

  #smartrx Login scenario
  Scenario Outline: Check the login is successful when given valid credentials
    Given browser is open
    When user is on login page
    And user enters <username> and <password>
    Then clicks on login button
    Then the result should be <message>

    Examples: 
      | username | password   | message   |
      | nishtha  | hello123   | incorrect |
      | shubham  | Sure@12345 | success   |

  #Location Selection Scenarios
  Scenario: Choose clinic location from dropdown
    Given click on select location dropdown
    When choose location from dropdown
    And click confirm
    Then land on trillium smartrx homepage

  #Open patient check in module from dashboard
  Scenario: Expand menu and sub-menu, open patient check in module
    Given Expand main menu
    When click on Administration
    And click on patient check in
    Then patient check in module opens

  #Health card field test
  Scenario: check the health card is selected from drop down
    Given click on health card select field
    When select one option from dropdown
    Then check the dropdown option is selected

  #check card number field and add new patient button
  Scenario: check the search of card number field works and new patient can be added from there.
    Given check record not found is displayed
    When click on Add New Patient button
    Then click on card number and search with text

  #check for phone number field
  Scenario: Search phone number in system
    Given Enter new number not in the system
    When record not found is displayed for phone number 
    Then show suggestions related to phone number

  #check for first name field
  Scenario: Search first name in system
    Given Enter new first name not in the system 
    When record not found is displayed for first name
    Then show suggestions related to first name

  #check for last name field
  Scenario: Search last name in system
    Given Enter new last name not in the system 
    When record not found is displayed for last name
    Then show suggestions related to last name
