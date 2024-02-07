package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import businessLayer.createPET;


@SuppressWarnings({ "static-access" })
public class PetStepDefinition
 {

	createPET createPET = new createPET();
	findPET findPET = new findPET();
	updatePET updatepet = new updatePET();

	@Given("^I Set POST service api endpoint for \"([^\"]*)\" to create PET$")
    	public void createPetPOSTAPI(int petID)
		{
        		addURI = "http://petstore.swagger.io/v2/pet/""+petID+""/uploadImage";
        		System.out.println("Add URL :"+addURI);
   		}		

	@When(^I Set POST headers and Send a HTTP request parameters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void sendRequestParameterstoUploadImageOfPET(String AMD, String ImageFile) {


		createPET.UploadImage(ADM,Imagepath);
	}

	@Then(^I receive valid response for POST API$")
	public void ReceiveResponse()
	{
		createPET.returnResponse();
	}
 					
@Given("^I Set PUT service api endpoint to update an existing PET$")
	public void updatePetPUTAPI()
		{
        		addURI = "http://petstore.swagger.io/v2/pet";
        		System.out.println("Add URL :"+addURI);
   		}
@When("When I Set request JSON and Send a PUT HTTP request")
	public void updatePETStatus()
	{
	updatepet.UpdateExistingPET();
	}
@Then(^I receive valid response after updating PET$")
	public void ReceiveResponse()
	{
		updatepet.returnResponse();
	}
	
	@Given("^I Set GET service api endpoint to find PET by status$")
	public void findPETByStatus()
		{
        		addURI = "http://petstore.swagger.io/v2/pet/findByStatus";
        		System.out.println("Add URL :"+addURI);
   		}
	@When("^I Set request JSON and Send a GET HTTP request with status$")
	public void PETByStatus()
	{
		findPET.getPETByStatus();
	}
	@Given("^I Set GET service api endpoint to find PET by Id")
	public void findPETById()
		{
        		addURI = "http://petstore.swagger.io/v2/pet/findById";
        		System.out.println("Add URL :"+addURI);
   		}

	@When("^I Set request JSON and Send a GET HTTP request with status$")
	public void PETByID()
	{
		findPET.getPETById();
	}
	@Then("^I receive valid Response$")
	public void getResponse()
	{
		findPET.returnResponse();	
	}

   @Given("^I Set POST service api endpoint to update name and status, \"([^\"]*)\" of the PET$")
	public void updateNameAndStatus(int Id)
	{
		addURI = "http://petstore.swagger.io/v2/pet/"+Id+"";
        	System.out.println("Add URL :"+addURI);
	}

	@When("^I Set request JSON and Send a POST HTTP request \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	{
		public void updatePETByFormData()
		{
			updatepet.updatePetByFormData();
		}
	}
	@Then("^I receive valid Response after updating name and status of PET$")
	{
		updatepet.returnResponse();
	}
 }
