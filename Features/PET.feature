Scenario: Upload PET Image 
Given I Set POST service api endpoint for "petID" to create PET
When I Set POST headers and Send a HTTP request parameters "additionalMetadata" and "Imagefile"
Then I receive valid Response for POST API
 
Scenario: Add a new PET to the store 
Given I Set POST service api endpoint
When I Set request JSON and Send a POST HTTP request
Then I receive valid Response after updating PET

Scenario: Update an Existing pet 
    Given I Set PUT service api endpoint to update an existing PET
When I Set request JSON and Send a PUT HTTP request
Then I receive valid response after updating PET

Scenario: find PET by status 
    Given I Set GET service api endpoint to find PET by status
When I Set request JSON and Send a GET HTTP request with status
Then I receive valid Response

Scenario: find PET by ID
    Given I Set GET service api endpoint to find PET by Id
When I Set request JSON and Send a GET HTTP request with Id
Then I receive valid Response

Scenario: Updates a PET in the store with form data
    Given I Set POST service api endpoint to update name and status of the PET
When I Set request JSON and Send a POST HTTP request "name", "status" and "Id"
Then I receive valid Response after updating name and status of PET

Scenario: Deletes a PET
    Given I Set DELETE service api endpoint
When I Set request JSON
    And Send a DELETE HTTP request 
Then I receive valid Response

