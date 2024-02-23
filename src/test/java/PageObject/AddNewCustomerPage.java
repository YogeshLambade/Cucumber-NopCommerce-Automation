package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {

	
	public WebDriver ldriver;
	
	public AddNewCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	//Find web elements on the web page
		@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")	 
		WebElement lnkCustomers_menu;


		//@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
		@FindBy(xpath="/html[1]/body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]")
		WebElement lnkCustomers_menuitem;

		@FindBy(xpath = "//a[@class='btn btn-primary']")	 
		WebElement btnAddnew;


		@FindBy(xpath = "//input[@id='Email']")
		WebElement txtEmail;


		@FindBy(xpath = "//input[@id='Password']")
		WebElement txtPassword;

		@FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")
		WebElement txtCustomerRoles;


		@FindBy(xpath = "//li[contains(text(),'Administrators')]")
		WebElement listItemAdministrators;


		@FindBy(xpath = "//li[contains(text(),'Registered')]")
		WebElement listItemRegistered;

		@FindBy(xpath = "//li[contains(text(),'Guests')]")
		WebElement listItemGuests;


		@FindBy(xpath = "//li[contains(text(),'Vendors')]")
		WebElement listItemVendors;
		//VendorId

		@FindBy(xpath = "//*[@id='VendorId']")
		WebElement dropdownVendorMgr;

		@FindBy(id = "Gender_Male")
		WebElement MaleGender;


		@FindBy(id = "Gender_Female")
		WebElement FeMaleGender;


		@FindBy(xpath = "//input[@id='FirstName']")
		WebElement txtFirstName;


		@FindBy(xpath = "//input[@id='LastName']")
		WebElement txtLastName;

		@FindBy(xpath = "//input[@id='DateOfBirth']")
		WebElement txtDob;

		@FindBy(xpath = "//input[@id='Company']")
		WebElement txtCompanyName;

		@FindBy(xpath = "//textarea[@id='AdminComment']")
		WebElement txtAdminContent;

		@FindBy(xpath = "//button[@name='save']")
		WebElement btnSave;

		//Actions Methods for web elements

		public String getPageTitle()
		{
			return ldriver.getTitle();
		}

		public void clickOnCustomersMenu() {
			lnkCustomers_menu.click();
		}

		public void clickOnCustomersMenuItem() throws InterruptedException {
			Thread.sleep(1000);
			lnkCustomers_menuitem.click();
		}

		public void clickOnAddnew() {
			btnAddnew.click();
		}

		public void enterEmail(String email)
		{
			//ldriver.findElement(By.className("card-tools float-right")).click();
			txtEmail.sendKeys(email);
		}

		public void enterPassword(String password)
		{
			txtPassword.sendKeys(password);
		}
		public void enterFirstName(String firstName)
		{
			txtFirstName.sendKeys(firstName);
		}

		public void enterLastName(String lastName)
		{
			txtLastName.sendKeys(lastName);
		}

		public void enterDob(String dob)
		{
			txtDob.sendKeys(dob);
		}

		public void enterCompanyName(String coName)
		{
			txtCompanyName.sendKeys(coName);
		}

		public void enterAdminContent(String content)
		{
			txtAdminContent.sendKeys(content);
		}

		/*public void enterCustomerRoles(String role)  
		{

		}*/

		public void enterManagerOfVendor(String value)
		{
			Select drp=new Select(dropdownVendorMgr);
			drp.selectByVisibleText(value);
		}

		public void enterGender(String gender)
		{
			if(gender.equals("Male"))
			{
				MaleGender.click();
			}
			else if(gender.equals("Female"))
			{
				FeMaleGender.click();
			}
			else//default set Male gender
			{
				MaleGender.click();
			}

		}

		

		public void clickOnSave()
		{
			btnSave.click();
		}
	
	
	
	
	
	
	
	
	
	
	
}
