package StepDefination;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

//Parent class
public class BaseClass {

	
	public static WebDriver driver;
	public LoginPage loginpg;
	public AddNewCustomerPage addNewCustPg;
	public SearchCustomerPage Searchcustpg;
	public static Logger log;
	public ReadConfig readConfig;
	
	//generate unique email id
		public String generateEmailId()
		{
			return(RandomStringUtils.randomAlphabetic(5));
		}
	
	
}
