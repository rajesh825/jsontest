Feature: GETPosts
  Verify different GET operations using REST-assured

  Scenario Outline: Verify one author of the post
     Given I perform GET operation for post id "<postid>"
     Then I should see correct post details with id "<postid>"
  Examples: 
    | postid |
    |  1     |
    | 99     |
    

 