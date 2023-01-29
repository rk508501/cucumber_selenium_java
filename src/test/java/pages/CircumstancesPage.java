package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepdefinition.TaggedHooks;

/**
 * This is Page class contains methods for entering the different circumstances
 * as per requirement and get the result
 * 
 * @author ankurd
 */
public class CircumstancesPage extends BrowserInitial {

	Random random = new Random();

	public CircumstancesPage() {
		PageFactory.initElements(finalDriver, this);
		// PageFactory.initElements(finalDriver, CircumstancesPage.class);
	}

	/*
	 * Navigate to NHS Cost Checker Tool URl
	 *
	 * @author ankurd
	 */
	public void navigateToUrl() {
		TaggedHooks.scenario.log("***Navigate to NHS Checker Tool URL***");
		finalDriver.get(Utility.getPropertyValue("./data/config.properties", "nhsCostCheckCalUrl"));
		Utility.waitForElementToBeVisibleFastAndFluent(finalDriver, 100, acceptCookiesButton);
	}

	/*
	 * Click on Cookies Agreement button
	 *
	 * @author ankurd
	 */
	public void clickAnalyticsCookies() {
		TaggedHooks.scenario.log("***Click on Analystics Cookies button to Accept***");
		acceptCookiesButton.click();
		Utility.waitForElementToBeVisibleFastAndFluent(finalDriver, 100, startNowButton);
	}

	/*
	 * Click on Start Now button
	 *
	 * @author ankurd
	 */
	public void clickStartNow() {
		TaggedHooks.scenario.log("***Click on Start Now button and User enter the circumstances into checker tool***");
		startNowButton.click();
		Utility.waitForElementToBeVisibleFastAndFluent(finalDriver, 100, question1);
	}

	/*
	 * Click on Country you live in
	 *
	 * @author ankurd
	 * 
	 * @param String
	 */
	public void clickCountryLiveRadioButton(String country) {
		TaggedHooks.scenario.log("***Select the country where you live in***");
		for (int i = 0; i < countryLive.size(); i++) {
			if (countryLive.get(i).getAttribute("value").trim().equalsIgnoreCase(country)) {
				countryLive.get(i).click();
			}
		}
		nextButton.click();
	}

	/*
	 * Click randomly on Gp Practice Or Highland and Island radio button
	 *
	 * @author ankurd
	 */
	public void clickGpPracticeOrHighlandIslandRadioButton() {
		TaggedHooks.scenario.log("***User randomly select about GP practise in Scotland/Wales***");
		Utility.waitForElementToBeVisibleFastAndFluent(finalDriver, 100, nextButton);
		int index = random.nextInt(gpPracticeOrHighLandRadioButton.size());
		gpPracticeOrHighLandRadioButton.get(index).click();
		nextButton.click();
	}

	/*
	 * Click on Random Dental Country Practice radio button
	 *
	 * @author ankurd
	 */
	public void clickdentalCountryPracticeRadioButton() {
		TaggedHooks.scenario.log("***User randomly select the option in which country dental practise***");
		Utility.waitForElementToBeVisibleFastAndFluent(finalDriver, 100, nextButton);
		int index = random.nextInt(dentalPracticeCountryRadioButton.size());
		dentalPracticeCountryRadioButton.get(index).click();
		nextButton.click();
	}

	/*
	 * Enter random DOB
	 *
	 * @author ankurd
	 */
	public void enterDOB() {
		TaggedHooks.scenario.log("***User enter the data of birth***");
		Utility.waitForElementToBeVisibleFastAndFluent(finalDriver, 100, day);
		day.sendKeys(Utility.generateRandomIntInRange(1, 28));
		month.sendKeys(Utility.generateRandomIntInRange(1, 12));
		year.sendKeys(Utility.generateRandomIntInRange(1980, 2000));
		nextButton.click();
	}

	/*
	 * Click on Random Live with Partner radio button
	 *
	 * @author ankurd
	 */
	public void clickLivePartnerRadioButton() {
		TaggedHooks.scenario.log("***User randomly select the option whether he/she live with partner or not***");
		Utility.waitForElementToBeVisibleFastAndFluent(finalDriver, 100, nextButton);
		int index = random.nextInt(livePartnerRadioButton.size());
		livePartnerRadioButton.get(index).click();
		nextButton.click();
	}

	/*
	 * Click on Tax Claim radio button and pass the yes/no value from feature file
	 *
	 * @author ankurd
	 * 
	 * @param String, String
	 */
	public void clickTaxClaimRadioButton(String claim, String credit) throws InterruptedException {
		if (claim.equalsIgnoreCase("No")) {
			TaggedHooks.scenario.log("***User select the option he/she don't claim any benefits or tax credits***");
			claimTaxNoButton.click();
			nextButton.click();
		} else {
			TaggedHooks.scenario.log("***User select the option he/she claim any benefits or tax credits***");
			claimTaxYesButton.click();
			nextButton.click();
			if (credit.equalsIgnoreCase("Yes")) {
				TaggedHooks.scenario.log("***User select the option he/she recieve Universal Credit payments***");
				yesUniversalCreditButton.click();
				nextButton.click();
				universalCreditPaymentYesButton.click();
				nextButton.click();
				universalCreditTakeHomePayYesButton.click();
				nextButton.click();
			} else {
				TaggedHooks.scenario.log("***User select he/she don't get any paid Universal Credit but applied***");
				notYetUniversalCreditButton.click();
				nextButton.click();
			}
		}
	}

	/*
	 * Click on Pregnant or Given Birth radio button and pass the yes/no value from
	 * feature file
	 *
	 * @author ankurd
	 * 
	 * @param String
	 */
	public void clickPregnantOrGivenBirthRadioButton(String field) {
		TaggedHooks.scenario
				.log("***User randomly select whether she is pregnant or not or given birth in the last 12 month***");
		Utility.waitForElementToBeVisibleFastAndFluent(finalDriver, 100, nextButton);
		for (int i = 0; i < pregnantOrBirthRadioButton.size(); i++) {
			if (pregnantOrBirthRadioButton.get(i).getAttribute("value").equalsIgnoreCase(field)) {
				pregnantOrBirthRadioButton.get(i).click();
			}
		}
		nextButton.click();
	}

	/*
	 * Click on Injury or Illness in armed forces radio button and pass the yes/no
	 * value from feature file
	 *
	 * @author ankurd
	 * 
	 * @param String
	 */
	public void clickInjuryOrIllnessArmedForcesRadioButton(String war) {
		TaggedHooks.scenario.log("***User randomly select whether he/she have an injury or illness***");
		Utility.waitForElementToBeVisibleFastAndFluent(finalDriver, 100, nextButton);
		for (int i = 0; i < injuryOrIllnesRadioButton.size(); i++) {
			if (injuryOrIllnesRadioButton.get(i).getAttribute("value").equalsIgnoreCase(war)) {
				injuryOrIllnesRadioButton.get(i).click();
			}
		}
		nextButton.click();
	}

	/*
	 * Click on Home Care and help from Local council radio button and pass the
	 * yes/no value from feature file
	 *
	 * @author ankurd
	 * 
	 * @param String,String
	 */
	public void clickHomeCare(String permanent, String careLocalCouncil) {
		if (permanent.equalsIgnoreCase("Yes")) {
			TaggedHooks.scenario.log("***User select he/she permanently live in home care***");
			careHomeYesRadioButton.click();
			nextButton.click();
			if (careLocalCouncil.equalsIgnoreCase("Yes")) {
				TaggedHooks.scenario.log("***User select he/she need help from Local Council***");
				careLocalCouncilYesRadioButton.click();
				nextButton.click();
			} else {
				TaggedHooks.scenario.log("***User select he/she don't help from Local council***");
				careLocalCouncilNoRadioButton.click();
				nextButton.click();
			}
		} else {
			TaggedHooks.scenario.log("***User select he/she permanently not live in home care***");
			careHomeNoRadioButton.click();
			nextButton.click();
		}
	}

	/*
	 * Click on Diabetes radio button and pass the yes/no value from feature file
	 *
	 * @author ankurd
	 * 
	 * @param String
	 */
	public void clickDiabetesRadioButton(String disease) {
		TaggedHooks.scenario.log("***User select he/she is having diabetes or not***");
		Utility.waitForElementToBeVisibleFastAndFluent(finalDriver, 100, nextButton);
		for (int i = 0; i < diabetesRadioButton.size(); i++) {
			if (diabetesRadioButton.get(i).getAttribute("value").equalsIgnoreCase(disease)) {
				diabetesRadioButton.get(i).click();
			}
		}
		nextButton.click();
	}

	/*
	 * Click on Diabetes Medication radio button and pass the yes/no value from
	 * feature file
	 *
	 *
	 */
	public void clickDiabetesMedicationRadioButton(String medicine) {
		Utility.waitForElementToBeVisibleFastAndFluent(finalDriver, 100, nextButton);
		for (int i = 0; i < diabetesMedicationRadioButton.size(); i++) {
			if (diabetesMedicationRadioButton.get(i).getAttribute("value").equalsIgnoreCase(medicine)) {
				diabetesMedicationRadioButton.get(i).click();
			}
		}
		nextButton.click();
	}

	/*
	 * Click on Random Savings radio button
	 *
	 * @author ankurd
	 * 
	 * @param String
	 */
	public void clickSavingsRadioButton() {
		TaggedHooks.scenario.log("***User randomly select he/she is having savings or not***");
		Utility.waitForElementToBeVisibleFastAndFluent(finalDriver, 100, nextButton);
		int index = random.nextInt(savingsRadioButton.size());
		savingsRadioButton.get(index).click();
		nextButton.click();
	}

	/*
	 * Get the list of help that you get with NHS cost
	 *
	 * @author ankurd
	 * 
	 * @return List
	 */
	public List<String> getNHSCostResult() {
		List<String> li = new ArrayList<String>();
		for (int i = 0; i < nhsResult.size(); i++) {
			li.add(nhsResult.get(i).getText());
		}
		return li;
	}

	/*
	 * Don't get any help with NHS cost
	 *
	 * @author ankurd
	 * 
	 * @return String
	 */
	public String dontGetNHSCostResult() {
		String result = nhsResultNotYetUniversalCredit.getText();
		return result;
	}

	/*
	 * Verify the user get any help or not
	 *
	 * @author ankurd
	 * 
	 * @return String
	 */
	public String careLocalCouncilNHSCostResult() {
		String result = nhsResultCareLocalCouncil.getText();
		return result;
	}

	/*
	 * Verify the user get any help or not as living in NortherIreland
	 *
	 * @author ankurd
	 * 
	 * @return String
	 */
	public String northernIrelandNHSCostResult() {
		String result = nhsResultNortherIreland.getText();
		return result;
	}

	/**
	 * Click on Random Glaucoma radio button
	 *
	 * @author ankurd
	 */
	public void clickGlaucomaRadioButton() {
		TaggedHooks.scenario.log("***User randomly select he/she is having glaucoma or not***");
		Utility.waitForElementToBeVisibleFastAndFluent(finalDriver, 100, nextButton);
		int index = random.nextInt(glaucomaRadioButton.size());
		glaucomaRadioButton.get(index).click();
		nextButton.click();
	}

	/*
	 * Click on Random Highland or Island radio button
	 *
	 * @author ankurd
	 */
	public void clickHighlandOrIslandRadioButton() {
		TaggedHooks.scenario.log("***User randomly select he/she lives in Highlands/Islands***");
		Utility.waitForElementToBeVisibleFastAndFluent(finalDriver, 100, nextButton);
		int index = random.nextInt(highlandIslandRadioButton.size());
		highlandIslandRadioButton.get(index).click();
		nextButton.click();
	}

	/*
	 * Get the list of help that you get with NHS cost
	 *
	 * @author ankurd
	 * 
	 * @return List
	 */
	public List<String> getNHSCostResultForUniversalCredit() {
		List<String> li = new ArrayList<String>();
		for (int i = 0; i < nhsResultYesUniversalCredit.size(); i++) {
			li.add(nhsResultYesUniversalCredit.get(i).getText());
		}
		return li;
	}

	@FindBy(xpath = "//*[@id='nhsuk-cookie-banner__link_accept_analytics']")
	WebElement acceptCookiesButton;
	@FindBy(xpath = "//*[@value='Start now']")
	WebElement startNowButton;
	@FindBy(xpath = "//*[@id='question-heading']")
	WebElement question1;
	@FindAll(@FindBy(xpath = "//*[@id='livingCountry_fieldset']//div/input"))
	List<WebElement> countryLive;
	@FindAll(@FindBy(xpath = "//*[@name='gpPracticeInScotlandOrWales']"))
	List<WebElement> gpPracticeRadioButton;
	@FindAll(@FindBy(xpath = "//*[@type='radio']"))
	List<WebElement> gpPracticeOrHighLandRadioButton;
	@FindBy(xpath = "//*[@value='Next']")
	WebElement nextButton;
	@FindAll(@FindBy(xpath = "//*[@id='dentalPracticeCountry_fieldset']//div/input"))
	List<WebElement> dentalPracticeCountryRadioButton;
	@FindBy(id = "dob-day")
	WebElement day;
	@FindBy(id = "dob-month")
	WebElement month;
	@FindBy(id = "dob-year")
	WebElement year;
	@FindAll(@FindBy(xpath = "//*[@id='partner_fieldset']//div/input"))
	List<WebElement> livePartnerRadioButton;
	@FindAll(@FindBy(xpath = "//*[@id='benefits-or-tax-credit_fieldset']//div/input"))
	List<WebElement> taxClaimRadioButton;
	@FindAll(@FindBy(xpath = "//*[@id='pregnant-or-giving-birth_fieldset']//div/input"))
	List<WebElement> pregnantOrBirthRadioButton;
	@FindAll(@FindBy(xpath = "//*[@id='warPension_fieldset']//div/input"))
	List<WebElement> injuryOrIllnesRadioButton;
	@FindAll(@FindBy(xpath = "//*[@id='inCareHome_fieldset']//div/input"))
	List<WebElement> homeCareRadioButton;
	@FindAll(@FindBy(xpath = "//*[@id='diabetes_fieldset']//div/input"))
	List<WebElement> diabetesRadioButton;
	@FindAll(@FindBy(xpath = "//*[@id='diabetesMedication_fieldset']//div/input"))
	List<WebElement> diabetesMedicationRadioButton;
	@FindAll(@FindBy(xpath = "//*[@id='savings_fieldset']//div/input"))
	List<WebElement> savingsRadioButton;
	@FindAll(@FindBy(xpath = "//*[@id='FREE-heading']//following-sibling::ul//li/span[2]"))
	List<WebElement> nhsResult;
	@FindAll(@FindBy(xpath = "//*[@id='glaucoma_fieldset']//div/input"))
	List<WebElement> glaucomaRadioButton;
	@FindAll(@FindBy(xpath = "//*[@id='livingInHighlandsAndIslands_fieldset']//div/input"))
	List<WebElement> highlandIslandRadioButton;
	@FindBy(xpath = "//*[@id='radio-yes']")
	WebElement claimTaxYesButton;
	@FindBy(xpath = "//*[@name='benefitsOrTaxCredits' and @value='No']")
	WebElement claimTaxNoButton;
	@FindBy(xpath = "//*[@name='paidUniversalCredit' and @id='yes-universal']")
	WebElement yesUniversalCreditButton;
	@FindBy(xpath = "//*[@name='paidUniversalCredit' and @id='not-yet']")
	WebElement notYetUniversalCreditButton;
	@FindBy(xpath = "//*[@name='paidUniversalCredit' and @id='different-benefit']")
	WebElement noUniversalCreditButton;
	@FindBy(xpath = "//*[@name='universalCreditIncludePayments' and @id='radio-yes']")
	WebElement universalCreditPaymentYesButton;
	@FindBy(xpath = "//*[@name='universalCreditTakeHomePay' and @id='radio-yes']")
	WebElement universalCreditTakeHomePayYesButton;
	@FindBy(xpath = "//*[@id='question-heading']")
	WebElement nhsResultNotYetUniversalCredit;
	@FindAll(@FindBy(xpath = "//*[@class='form-hint-list']//li"))
	List<WebElement> nhsResultYesUniversalCredit;
	@FindBy(xpath = "//*[@name='localCouncilAssessed' and @id='radio-yes']")
	WebElement careLocalCouncilYesRadioButton;
	@FindBy(xpath = "//*[@name='localCouncilAssessed' and @id='radio-no']")
	WebElement careLocalCouncilNoRadioButton;
	@FindBy(xpath = "//*[@name='inCareHome' and @id='radio-yes']")
	WebElement careHomeYesRadioButton;
	@FindBy(xpath = "//*[@name='inCareHome' and @id='radio-no']")
	WebElement careHomeNoRadioButton;
	@FindBy(xpath = "//*[@class='heading-xlarge']//following-sibling::h2")
	WebElement nhsResultCareLocalCouncil;
	@FindBy(xpath = "//*[@id='result-heading']")
	WebElement nhsResultNortherIreland;
}