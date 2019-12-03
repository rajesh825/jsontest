Feature: Post Functionality
  Scenario Outline: Check Post Functionality
    Given I want to execute service "<serviceName>"
    When I invoke the end point "<endpoint>"
    Then I validate "<statusCode>"
    
  Examples:
    | serviceName          | endpoint   |  statusCode |
    | createPost           |  posts     |   201       |

    