
@tag
Feature: employee registration
  I want to use this template to check new employee registration
  

  @employee_reg
  Scenario: check new employee registration with valid inputs
    Given i open browser with the url "http://orangehrm.qedgetech.com"
    Then i should see login page
    When i enter username as "Admin"
    And  i enter password as "Qedge123!@#"
    And  i click login
    Then i should see admin module
    When i goto new employee registration page
    And i enter firstname as "Richards"
    And  i enter lastname as "j"
    And click save
    Then i should see registered employee in employee list
    When i click logout
    Then i should see login page
    When i close browser 

