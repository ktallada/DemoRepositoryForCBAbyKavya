Scenario: Creates list of users with given input array 
    Given I Set POST service api endpoint
When I Set request body
    And Send a POST HTTP request 
Then I receive valid Response 200

Scenario: get user by username 
    Given I Set GET service api endpoint
When I Set request JSON
    And Send a GET HTTP request 
Then I receive valid Response

Scenario: Update a user
    Given I Set PUT service api endpoint
When I Set request JSON
    And Send a PUT HTTP request 
Then I receive valid Response

Scenario: Delete a user
    Given I Set DELETE service api endpoint
When I Set request JSON
    And Send a DELETE HTTP request 
Then I receive valid Response

Scenario: Logs user into the system
    Given I Set GET service api endpoint
When I Set request JSON
    And Send a GET HTTP request 
Then I receive valid Response

Scenario: Logs out current logged in user session
    Given I Set GET service api endpoint
When I Set request JSON
    And Send a GET HTTP request 
Then I receive valid Response

Scenario: create user
    Given I Set POST service api endpoint
When I Set request body
    And Send a POST HTTP request 
Then I receive valid Response 200
