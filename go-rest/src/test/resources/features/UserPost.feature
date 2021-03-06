Feature: User Post Creation For Application Under Test
  https://gorest.co.in/

  Scenario Outline: User Post Creation
    Given the previous created user wants to publish a new post with title <title>
    And the post will contain the message <message>
    When he will publish the post
    Then the post will be available for my followers

    Examples:
      | title        | message            |
      | Postarea mea | o postare jmechera |
