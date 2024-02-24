package StepDefination;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
//import cucumber.api.java.en.*;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
/*child class*/
public class Stepdef extends BaseClass{

	
	

	@Before()
	public void setup2()
	{
		
		readConfig = new ReadConfig();
		//initialise logger
				log = LogManager.getLogger("Stepdef");
		System.out.println("Setup2-Regression method executed..");
		
		String browser = readConfig.getBrowser();
		
		
		//launch browser
				switch(browser.toLowerCase())
				{
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;

				case "msedge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;

				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				default:
					driver = null;
					break;

				}


//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		log.info("Setup2 executed...");
	}

	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		loginpg = new LoginPage(driver);
		addNewCustPg= new AddNewCustomerPage(driver);
		Searchcustpg = new SearchCustomerPage(driver);
		log.info("chrome browser launched");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.manage().window().maximize();
		driver.get(url);
		log.info("url opened");
		
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String em, String pass) {
	   loginpg.enterEmail(em);
	   loginpg.enterPassword(pass);
	   log.info("email address and password entered");

	}

	@When("Click on Login")
	public void click_on_login() {
	  loginpg.clickOnLoginButton();
	  log.info("Clicked on login button");
	}

	
	
	////login feature////
	
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String exptitle) {
	    String actualtitle = driver.getTitle();
	    if(actualtitle.equals(exptitle)) {
	    	log.warn("Test passed: Login feature :Page title matched.");
	    	Assert.assertTrue(true);
	    }
	    else {
	    	log.warn("Test Failed: Login feature- page title not matched.");
	    	Assert.assertTrue(false);	
	    }
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		Thread.sleep(3000);
	 loginpg.clickOnLogOutButton();   
	 log.info("user clicked on logout link.");
	}

//	@Then("close browser")
//	public void close_browser() {
//	   driver.quit();
//	}

//   Add new customer scenario
	
	

	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{
			log.info("user can view dashboard test passed.");
			Assert.assertTrue(true);

		}
		else
		{
			Assert.assertTrue(false);
			log.warn("user can view dashboard test failed.");

		}
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		addNewCustPg.clickOnCustomersMenu();
		log.info("customer menu clicked");
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(3000);
		addNewCustPg.clickOnCustomersMenuItem();
		log.info("customer menu item clicked");
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addNewCustPg.clickOnAddnew();
		log.info("clicked on add new button.");
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{
			log.info("User can view Add new customer page- passed");

			Assert.assertTrue(true);//pass
		}
		else
		{
			log.info("User can view Add new customer page- failed");

			Assert.assertTrue(false);//fail
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
	     
		//addNewCustPg.enterEmail("l17@gmail.com");
		addNewCustPg.enterEmail(generateEmailId()+"@gmail.com");
				addNewCustPg.enterPassword("test3");
				addNewCustPg.enterFirstName("John3");
				addNewCustPg.enterLastName("Doe2");
				addNewCustPg.enterGender("Male");
				addNewCustPg.enterDob("6/13/1988");
				addNewCustPg.enterCompanyName("YlStudio");
				addNewCustPg.enterAdminContent("Admin content");
				addNewCustPg.enterManagerOfVendor("Vendor 1");
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
				log.info("customer information entered");
	}

	@When("click on Save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();
		log.info("clicked on save button");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String exptectedConfirmationMsg) {
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(exptectedConfirmationMsg))
		{
			Assert.assertTrue(true);//pass
			log.info("User can view confirmation message - passed");

		}
		else
		{
			log.warn("User can view confirmation message - failed");

			Assert.assertTrue(false);//fail

		}
	}


	//////Search customer by Email///////////////
	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
		Searchcustpg.enterEmailAdd("pVmQr@gmail.com");
		log.info("Email address entered");
	}

	@When("Click on search button")
	public void click_on_search_button() {
	    Searchcustpg.clickOnSearchButton();
	    log.info("Clicked on search button.");
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String expectedEmail = "pVmQr@gmail.com";

		  //Assert.assertTrue(Searchcustpg.searchCustomerByEmail(expectedEmail));

		if( Searchcustpg.searchCustomerByEmail(expectedEmail) ==true)
		{
			Assert.assertTrue(true);
			log.info("User should found Email in the Search table - passed");

		}
		else {
			log.info("User should found Email in the Search table - passed");
			Assert.assertTrue(false);

		}
	}
	
	

	///////search by customer name///////
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		Searchcustpg.enterFirstName("John3");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		Searchcustpg.enterLastName("Doe2");;
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String expectedName = "John3 Doe2";


		if( Searchcustpg.searchCustomerByName(expectedName) ==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);

	}
	}
	
	
/*	@After
	public void teardown(Scenario sc)
	{
		System.out.println("Tear Down method executed..");
		if(sc.isFailed()==true)
		{
			//Convert web driver object to TakeScreenshot

			String fileWithPath = "C:\\Users\\ACER\\eclipse-workspace\\NCAutomation\\Screenshot\\failedScreenshot.png";
			TakesScreenshot scrShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination
			File DestFile=new File(fileWithPath);

			//Copy file at destination

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		driver.quit();
	}
*/
	
	
	@AfterStep
	public void addScreenshot(Scenario scenario){

		//validate if scenario has failed
		
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName()); 
		}
		
	}
	
	/*@After
	public void end() {
		driver.quit();
	}*/
	
}
