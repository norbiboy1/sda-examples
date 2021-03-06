Feature: User Creation For Application Under Test
  https://gorest.co.in/

  Scenario Outline: User Creation
    Given I want to create a new user with name <name>, gender <gender> and email address <email>
    When I create the user resource
    Then the user will be created in the database with the name <name>
    And an id will be assigned to this new user
    And response status code will be <statusCode>
    Examples:
      | name       | gender | email      | statusCode |
      | Cris Aurel | Male   | cris.aurel | 200        |
