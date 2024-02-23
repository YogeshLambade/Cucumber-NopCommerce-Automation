package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Features/NCLoginPage.feature",".//Features/Customers.feature"},
				//features = ".//Features/",
		glue="StepDefination",
		dryRun = false,
		monochrome = true,
		//tags="@Sanity",
		//plugin = {"pretty","html:target/cucumber-reports/report.html"}
				plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class Run {

}
