@tag
Feature: admin login
  I want to use this template to validate admin login

  @login_valid
  Scenario: check admin login with valid data
    Given i open browser with the url "http://orangehrm.qedgetech.com"
    Then i should see login page
    When i enter username as "Admin"
    And i enter password as "Qedge123!@#"
    And i click login
    Then i should see admin module
    When i click logout
    Then i should see login page
    When i close browser

  @login_invalid
  Scenario Outline: check admin login with invalid data
    Given i open browser with the url "http://orangehrm.qedgetech.com"
    Then i should see login page
    When i enter username as "<username>"
    And i enter password as "<password>"
    And i click login
    Then i should see error message
    When i close browser

    Examples: 
      | username | password |
      | Admin    | Qedge123 |
      | abc      | xyz      |
