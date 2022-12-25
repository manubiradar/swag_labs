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
  Scenario Outline: Login with invalid credentials
    Given user is on the login page
    When User enters invalid <username> and <password>
    And user clicks on the login button
    Then user should not be able to login

    Examples: 
      | username                 | password     |
      | standard_user            | secret_sauc  |
      | problem_users            | secret_sauce |
      | performance_glitch_users | secret_sauc  |
      | locked_out_user          | secret_sauce |
      |                          |              |
      | standard_user            |              |
      |                          | secret_sauce |
