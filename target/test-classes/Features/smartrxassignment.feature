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
