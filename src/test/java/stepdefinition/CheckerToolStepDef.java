package stepdefinition;

import org.junit.jupiter.api.Assertions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CircumstancesPage;

/**
 * This is step definition class
 * 
 * @author ankurd
 */
public class CheckerToolStepDef {

	CircumstancesPage cp = new CircumstancesPage();

	@Given("Open the NHS Cost Checker tool url")
	public void open_the_nhs_cost_checker_tool_url() {
		cp.navigateToUrl();
	}

	@And("Accept the analytics cookies")
	public void accept_the_analytics_cookies() {
		cp.clickAnalyticsCookies();
	}

	@And("Click on Start Now")
	public void click_on_start_now() {
		cp.clickStartNow();
	}

	@Given("^I am living in Country as (.*)$")
	public void i_am_living_in_country_as_country(String country) {
		cp.clickCountryLiveRadioButton(country);
	}

	@When("I put circumstances as GP practice in Scotland or live in Highland and Island")
	public void i_put_circumstances_as_gp_practice_in_scotland_or_live_in_highland_and_island() {
		cp.clickGpPracticeOrHighlandIslandRadioButton();
	}

	@And("Select Random Country is your dental practise in")
	public void select_random_country_is_your_dental_practise_in() {
		cp.clickdentalCountryPracticeRadioButton();
	}

	@And("Enter Date of Birth")
	public void enter_date_of_birth() {
		cp.enterDOB();
	}

	@And("Enter Random Details about Live with partner")
	public void enter_random_details_about_live_with_partner() {
		cp.clickLivePartnerRadioButton();
	}

	@And("^Enter details about claim any benefit or tax credit as (.*) and universal credit as (.*)$")
	public void enter_details_about_claim_any_benefit_or_tax_credit_as_yes_and_universal_credit_as_no(String claim,
			String credit) throws InterruptedException {
		cp.clickTaxClaimRadioButton(claim, credit);
	}

	@And("^Enter details about pregnant or given birth as (.*)$")
	public void enter_details_about_pregnant_or_given_birth_as_field(String field) {
		cp.clickPregnantOrGivenBirthRadioButton(field);
	}

	@And("^Enter details about injury or illness in armed forces as (.*)$")
	public void enter_details_about_injury_or_illness_in_armed_forces_as_war(String war) {
		cp.clickInjuryOrIllnessArmedForcesRadioButton(war);
	}

	@And("^Enter details about home care as (.*) and (.*)$")
	public void enter_details_about_home_care_as_permanent_and_careLocalCouncil(String permanent,
			String careLocalCouncil) {
		cp.clickHomeCare(permanent, careLocalCouncil);
	}

	@And("^Enter about diabetes as (.*)$")
	public void enter_about_diabetes_as_disease(String disease) {
		cp.clickDiabetesRadioButton(disease);
	}

	@And("^Enter about diabetes medication as (.*)$")
	public void enter_about_diabetes_medication_as_medicine(String medicine) {
		cp.clickDiabetesMedicationRadioButton(medicine);
	}

	@And("Enter details about savings or investment")
	public void enter_details_about_savings_or_investment() {
		cp.clickSavingsRadioButton();
	}

	@And("Enter about glaucoma")
	public void enter_about_glaucoma() {
		cp.clickGlaucomaRadioButton();
	}

	@Then("^Get a result and check whether you get any help with NHS cost pass parameter as (.*) and (.*) and (.*)$")
	public void get_a_result_and_check_whether_you_get_any_help_with_nhs_cost_pass_parameter_as_claim_and_credit_and_careLocalCouncil(
			String claim, String credit, String careLocalCouncil) throws InterruptedException {
		TaggedHooks.scenario.log("***User get a result and see whether he/she will get help or not***");
		if (claim.equalsIgnoreCase("No") && credit.equalsIgnoreCase("No") && careLocalCouncil.equalsIgnoreCase("No")) {
			TaggedHooks.scenario.log("*" + cp.getNHSCostResult() + "*");
			Assertions.assertTrue(cp.getNHSCostResult().size() >= 1, "You will get free :" + cp.getNHSCostResult());
		} else if (claim.equalsIgnoreCase("Yes") && credit.equalsIgnoreCase("No")) {
			TaggedHooks.scenario.log("*" + cp.dontGetNHSCostResult() + "*");
			Assertions.assertTrue(cp.dontGetNHSCostResult().trim().contains("Universal Credit decision"),
					"Don't get any help:" + cp.dontGetNHSCostResult().trim());
		} else if (claim.equalsIgnoreCase("Yes") && credit.equalsIgnoreCase("Yes")) {
			TaggedHooks.scenario.log("*" + cp.getNHSCostResultForUniversalCredit() + "*");
			Assertions.assertTrue(cp.getNHSCostResultForUniversalCredit().size() >= 1,
					"You will get free :" + cp.getNHSCostResultForUniversalCredit());
		} else if (claim.equalsIgnoreCase("No") && credit.equalsIgnoreCase("No")
				&& careLocalCouncil.equalsIgnoreCase("Yes")) {
			TaggedHooks.scenario.log("*" + cp.careLocalCouncilNHSCostResult() + "*");
			TaggedHooks.scenario.log("*" + cp.getNHSCostResultForUniversalCredit() + "*");
			Assertions.assertTrue(
					cp.careLocalCouncilNHSCostResult().trim().contains("You can apply for help with NHS costs"),
					"Need to apply for Help" + cp.careLocalCouncilNHSCostResult().trim());
			Assertions.assertTrue(cp.getNHSCostResultForUniversalCredit().size() >= 1,
					"What you will get free :" + cp.getNHSCostResultForUniversalCredit());
		} else if (claim.equalsIgnoreCase("NA") && credit.equalsIgnoreCase("NA")
				&& careLocalCouncil.equalsIgnoreCase("NA")) {
			TaggedHooks.scenario.log("*" + cp.northernIrelandNHSCostResult() + "*");
			Assertions.assertTrue(
					cp.northernIrelandNHSCostResult().trim()
							.equalsIgnoreCase("You cannot use this service because you live in Northern Ireland"),
					"Not Eligibile : " + cp.northernIrelandNHSCostResult().trim());
		}
	}
}