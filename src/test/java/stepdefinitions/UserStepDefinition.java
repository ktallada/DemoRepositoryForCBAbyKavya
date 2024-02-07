package tfa.FUJI.CustomerService.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dx.ceres.logging.LogHelper;
import tfa.FUJI.CustomerService.businessLayer.ThreeSixtyDegreeViewDomain;
import tfa.FUJI.CustomerService.businessLayer.UpdateContactDomain;

@SuppressWarnings({ "static-access" })
public class UpdateCustomerDetailsStepDefinition {

	UpdateContactDomain contactDomain = new UpdateContactDomain();
	ThreeSixtyDegreeViewDomain customerView = new ThreeSixtyDegreeViewDomain();

	@When("CSR selects Add task button to update individual customer details")
	public void csr_selects_Add_task_button_to_update_individual_customer_details() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.clickUpdateContactDetails();
	}

	@When("^CSR selects and updates driver license details for \"([^\"]*)\"$")
	public void csr_selects_and_updates_driver_license_details_for(String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.updateDriverLicenceDetails(Customer);
	}

	@Then("^CSR can verify change updated for \"([^\"]*)\"$")
	public void csr_can_verify_change_updated_for(String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.assertDriverLicenceDetails(Customer);
	}

	@When("CSR submits the task details screen")
	public void csr_submits_the_task_details_screen() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.submitPage();
	}

	@Then("^navigate to edit contact details screen and update email and phone number details of \"([^\"]*)\" by clicking on edit icon$")
	public void navigate_to_edit_contact_details_screen_and_update_email_and_phone_number_details_of_by_clicking_on_edit_icon(
			String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.updateCommunicationDetails(Customer);
	}

	@And("^verify that the changes for \"([^\"]*)\" are reflected in update contact details screen and commit the changes$")
	public void verify_that_the_changes_for_are_reflected_in_update_contact_details_screen_and_commit_the_changes(
			String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.assertUpdateCommunicationDetails(Customer);
	}

	@Then("^verify that the primary contact details are updated in 360degree view of the customer$")
	public void verify_that_the_primary_contact_details_are_updated_in_360degree_view_of_the_customer() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		customerView.assertPrimaryCommunicationDetails();
	}

	@Then("^verify that the secondary contact details for \"([^\"]*)\" are updated in 360degree view of the customer$")
	public void verify_that_the_secondary_contact_details_for_are_updated_in_360degree_view_of_the_customer(
			String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		customerView.assertSecondaryCommunicationDetails(Customer);
	}

	@When("^CSR selects and updates personal details for \"([^\"]*)\"$")
	public void csr_selects_and_updates_personal_details_for(String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.updatePersonalDetails(Customer);
	}

	@Then("^CSR can verify personal details updated for \"([^\"]*)\"$")
	public void csr_can_verify_personal_details_updated_for(String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.assertPersonalDetails(Customer);
	}

	@When("^CSR selects and updates passport and visa details for \"([^\"]*)\"$")
	public void csr_selects_and_updates_passport_and_visa_details_for(String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.updatePassportVisaDetails(Customer);
	}

	@Then("^CSR can verify passport and visa details updated for \"([^\"]*)\"$")
	public void csr_can_verify_passport_and_visa_details_updated_for(String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.assertPassportVisaDetails(Customer);
	}

	@Then("^CSR can verify updated personal details for \"([^\"]*)\" in 360view$")
	public void csr_can_verify_updated_personal_for_in_360view(String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.assert360PersonalDetails(Customer);
	}

	@When("^CSR selects add new address with existing address and fills out using \"([^\"]*)\" with \"([^\"]*)\" address type$")
	public void csr_selects_add_new_address_with_existing_address_and_fills_out_using_with_address_type(String Customer,
			String addressType) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.updateNewAddressWithExistingAddress(Customer, addressType);
	}

	@Then("^CSR can verify Address updated for \"([^\"]*)\" with \"([^\"]*)\" address type$")
	public void csr_can_verify_address_for(String Customer, String addressType) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.assertUpdatedExistingAddress(Customer, addressType);
	}

	@Then("^CSR can verify updated Address details for \"([^\"]*)\" in 360view$")
	public void csr_can_verify_updated_address_for_in_360view(String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.assert360addressUpdate(Customer);
	}

	@When("^CSR selects add new address with lookup address and fills out using \"([^\"]*)\" with \"([^\"]*)\" address type$")
	public void csr_selects_add_new_address_with_lookup_address_and_fills_out_using(String Customer,
			String addressType) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.updateNewAddressWithLookupAddress(Customer, addressType);
	}

	@When("^CSR selects edit button for address and uses lookup address and edits address for \"([^\"]*)\" with \"([^\"]*)\" address type$")
	public void csr_selects_edit_button_for_address_and_uses_lookup_address_and_fills_out_using(String Customer,
			String addressType) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.EditAddressWithLookupAddress(Customer, addressType);

	}

	@Then("^verify that the primary contact details of \"([^\"]*)\" are updated in the banner$")
	public void verify_that_the_primary_contact_details_of_are_updated_in_the_banner(String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		customerView.assertCommunicationDetailsInIndividualBanner(Customer);

	}

	@Then("^navigate to edit org contact details screen and update email and phone number details of \"([^\"]*)\" by clicking on edit icon$")
	public void navigate_to_edit_org_contact_details_screen_and_update_email_and_phone_number_details_of_by_clicking_on_edit_icon(
			String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.updateOrgCommunicationDetails(Customer);
	}

	@And("^verify that the org changes for \"([^\"]*)\" are reflected in update contact details screen and commit the changes$")
	public void verify_that_the_org_changes_for_are_reflected_in_update_contact_details_screen_and_commit_the_changes(
			String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.assertUpdateOrgCommunicationDetails(Customer);
	}

	@Then("^verify that the primary contact details are updated in 360degree view of the \"([^\"]*)\"$")
	public void verify_that_the_primary_contact_details_are_updated_in_360degree_view_of_the(String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		customerView.assertCommunicationDetailsInOrg360View(Customer);
	}
	
	@When("CSR selects Add task button to add bank account details")
	public void csr_selects_Add_task_button_to_add_bank_account_details() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.clickAddBankAccountDetailsTask();
	}
	
	@When("^CSR selects and add Bank Account details for \"([^\"]*)\"$")
	public void csr_selects_and_add_Bank_Account_details_for(String name) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.addBankAccountDetails(name);
	}
	
	@And("Assert the passport and visa details for \"([^\"]*)\"$")
	public void Assert_the_passport_and_visa_details(String Customer) {

		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());
		customerView.assertPassportVisaDetails(Customer);
	} 
	
	@When("CSR submit and confirm the task")
	public void csr_submit_and_confirm_the_task() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.submitAndConfirmPage();
	}
	
	@When("CSR selects the confirm task button")
	public void csr_select_the_confirm_task_button() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.confirmPageOnly();
	}
	
	@When("^CSR selects and updates bank account details for \"([^\"]*)\"$")
	public void csr_selects_and_updates_bank_account_details_for(String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.updateBankAccountDetails(Customer);
	}
	
	@When("CSR selects Add task button to one Time Payment details")
	public void csr_selects_Add_task_button_to_one_time_payment_details() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.clickOneTimePaymentTask();
	}
	
	@When("CSR asserts and adds One Time Payment details")
	public void csr_asserts_and_adds_one_time_payment_details() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		customerView.assertAndAddOneTimePayment();
	}
	
	
	@When("CSR asserts One Time Payment details within payment and fees tab")
	public void csr_asserts_and_adds_one_time_payment_details_within_payment_and_fees_tab() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		customerView.assertPaymentAndFeesOneTimePayment();
	}

	@When("CSR selects Add task button to send form")
	public void csr_selects_Add_task_button_to_send_form() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.clickSendFormTask();
	}

	@And("^CSR complete send form details for \"([^\"]*)\"$")
	public void csr_complete_send_form_details_for(String name) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.sendFormDetails(name);
		//contactDomain.submitPage();
	}

	@Then("^navigate to edit org details screen and update marketing and communication preferences of \"([^\"]*)\" by clicking on edit icon$")
	public void navigate_to_edit_org_details_screen_and_update_marketing_and_communication_preferences_of_by_clicking_on_edit_icon(
			String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.updateOrgMarketingAndCommunicationPreferences(Customer);
	}

	@When("^navigate to edit personal details screen and update marketing and communication preferences of \"([^\"]*)\" by clicking on edit icon$")
	public void navigate_to_edit_personal_details_screen_and_update_marketing_and_communication_preferences_of_by_clicking_on_edit_icon(String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.updateIndividualMarketingAndCommunicationPreferences(Customer);
	}

	@And("^verify Marketing and Communication Preference changes for \"([^\"]*)\" are reflected$")
	public void verify_marketing_and_communication_changes_for_are_reflected(
			String Customer) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.assertUpdateMarketingAndCommunicationPreference(Customer);
	}

		@When("CSR selects Customer Enquiry toggle")
		public void csr_selects_customer_equiry_toggle() {
			LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
			}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

			contactDomain.clickCustomerEnquiryToggle();
		}

		@And("CSR selects Customer Enquiry areas")
		public void csr_selects_customer_equiry_areas() {
			LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
			}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

			contactDomain.clickCustomerEnquiryArea();

	}

	@When("CSR selects Add task button to generate a POQ")
	public void csr_selects_Add_task_button_to_generate_a_POQ() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.clickGeneratePOQLink();
	}

	@And("CSR selects reason for requesting POQ from {string} using {string} POQExpirydate and clicks on Generate to get Payout Quote")
	public void csrSelectsReasonForRequestingPOQFromUsingPOQExpirydateAndClicksOnGenerateToGetPayoutQuote(String customer, String Reason) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.selectReason(customer, Reason);

	}

	@Then("CSR clicks on Fees and charges link and breakdown of Fees and charges details should be displayed")
	public void CSR_clicks_on_Fees_and_charges_link_and_breakdown_of_Fees_and_charges_details_should_be_displayed() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.clickFeesAndChargesIncludedLink();
	}

	@And("CSR should see current Loan Details on the screen")
	public void csrShouldSeeCurrentLoanDetailsOnTheScreen() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.loanDetails();
	}

	@And("CSR should capture compliance to continue to send correspondence screen")
	public void csrShouldCaptureComplianceToContinueToSendCorrespondenceScreen() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.captureCompliance();

	}

	@And("For {string} select {string} and {string} if applicable from who will be paying list")
	public void forSelectAndIfApplicableFromWhoWillBePayingList(String customer, String payoutOption, String PaymentMethod) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.selectPayoutOption(customer, payoutOption, PaymentMethod);
	}

	@And("CSR complete send correspondence POQ details for {string} using {string}")
	public void csrCompleteSendCorrespondencePOQDetailsForUsing(String customer, String mode) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.sendCorrespondencePOQ(customer, mode);
	}

	@When("CSR selects Add task button to update individual Asset details")
	public void csr_selects_Add_task_button_to_update_individual_Asset_details() {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.clickUpdateAssetDetails();
	}


	@When("^CSR selects and updates vehicle identifiers details for \"([^\"]*)\"$")
	public void csr_selects_and_updates_vehicle_identifiers_details_for(String vehicleIdentifiers) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.updateAssetDetails(vehicleIdentifiers);
	}

	@When("^CSR selects and add Bank Account details for org \"([^\"]*)\"$")
	public void csr_selects_and_add_Bank_Account_details_for_org(String name) {
		LogHelper.createCeresTestLogBasedOnAnnotations(new Object() {
		}.getClass().getEnclosingMethod().getAnnotations(), this.getClass());

		contactDomain.addOrgBankAccountDetails(name);
	}
}

