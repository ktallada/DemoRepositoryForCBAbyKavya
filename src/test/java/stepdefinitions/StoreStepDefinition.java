package tfa.FUJI.CustomerService.stepdefinitions;

import static org.testng.Assert.fail;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dx.ceres.logging.LogHelper;
import org.json.simple.parser.ParseException;
import tfa.FUJI.CustomerService.businessLayer.CaptureVulnerabilities;
import tfa.FUJI.CustomerService.businessLayer.ThreeSixtyDegreeViewDomain;
import tfa.FUJI.CustomerService.businessLayer.UpdateContactDomain;

import java.io.IOException;

public class UpdateOrganisationDetailsStepDefinition {
	
	UpdateContactDomain contactDomain = new UpdateContactDomain();
	CaptureVulnerabilities vulnerable = new CaptureVulnerabilities();
	
		@When("CSR selects Add task button to update organisation customer details")
		public void csr_selects_Add_task_button_to_update_organisation_customer_details() {
			LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
			}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

			contactDomain.clickUpdateOrganisationDetails();
		}

		@When("^CSR selects and updates organisation details for \"([^\"]*)\"$")
		public void csr_selects_and_updates_organisation_details_for(String Customer) {
			LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
			}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

			contactDomain.updateOrganisationDetails(Customer);
		}

		@Then("^CSR can verify organisation details updated for \"([^\"]*)\"$")
		public void csr_can_verify_organisation_details_updated_for(String Customer) {
			LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
			}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

			contactDomain.assertOrganisationDetails(Customer);
		}
		
		@When("^CSR selects add new organisation address with existing address and fills out using \"([^\"]*)\" with \"([^\"]*)\" address type and \"([^\"]*)\" existing address$")
		public void csr_selects_add_new_organisation_address_with_existing_address_and_fills_out_using_with_address_type(String Customer, String addressType, String existingAddress) {
			LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
			}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());
			if(addressType.contentEquals(existingAddress)) {
				fail("The new address type cannot be identical to existing address type");
			}
			contactDomain.addNewOrganisationAddressWithExistingAddress(Customer, addressType, existingAddress);
		}

	@And("CSR adds multiple Vulnerabilities for the customer \"([^\"]*)\"$")
	public void csr_adds_multiple_Vulnerabilities_for_the_customer(String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		vulnerable.addVulnerability(Customer);
	}

	@When("CSR selects Add task button to capture vulnerability")
	public void csr_selects_Add_task_button_to_capture_vulnerability() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		vulnerable.clickCaptureVulnerability();
	}
	@And("CSR delete Vulnerability for the customer \"([^\"]*)\"$")
	public void csr_delete_Vulnerability_for_the_customer(String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		vulnerable.deleteVulnerability(Customer);
	}
}
