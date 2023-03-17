@scenario1
Feature: Login Functionality

  @positive
  Scenario Outline: Login with valid credentials using multiple data
    Given user is on login page
    When user enters valid <username> and <password>
    And user clicks on login button
    Then user should be navigated to home page

    Examples: 
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @negetive
  Scenario Outline: Login with invalid credentials using multiple data
    Given user is on the login page
    When User enters invalid <username> and <password>
    And user clicks on the login button
    Then user verifies Actual and <ExpectedError>

    Examples: 
      | username        | password     | ExpectedError                                                             |
      | standard_user   | Invalid_pass | Epic sadface: Username and password do not match any user in this service |
      | Invalid_user    | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | Invalid_user    | Invalid_pass | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      |                 |              | Epic sadface: Username is required                                        |
      | standard_user   |              | Epic sadface: Password is required                                        |
      |                 | secret_sauce | Epic sadface: Username is required                                        |
