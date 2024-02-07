Scenario: Place an order for a PET 
    Given I Set POST service api endpoint
When I Set request JSON
    And Send a POST HTTP request 
Then I receive valid Response

Scenario: find purchase order by ID 
    Given I Set GET service api endpoint
When I Set request JSON
    And Send a GET HTTP request 
Then I receive valid Response

Scenario: Delete purchase order by ID
    Given I Set DELETE service api endpoint
When I Set request JSON
    And Send a DELETE HTTP request 
Then I receive valid Response

Scenario: returns pet inventories by status 
    Given I Set GET service api endpoint
When I Set request JSON
    And Send a GET HTTP request 
Then I receive valid Response