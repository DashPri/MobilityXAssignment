package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(		
		features= {"src/test/java/com/features/AddExpense.feature"},
		glue = {"com/stepDefinitions","Hooks"},
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				},
		publish = true,
		monochrome = true		
		)

public class TestRunner extends AbstractTestNGCucumberTests {
	
}