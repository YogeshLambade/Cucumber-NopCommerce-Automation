package TestRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;






@CucumberOptions(
		features = {".//Features/NCLoginPage.feature",".//Features/Customers.feature"},
				//features = ".//Features/",
		glue="StepDefination",
		dryRun = false,
		monochrome = true,
		tags="@Sanity",
		//plugin = {"pretty","html:target/cucumber-reports/report.html"}
				plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class Run extends AbstractTestNGCucumberTests {

}
