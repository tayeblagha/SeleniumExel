package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// RUn it with:          mvn test -Dtest=testrunners.MyTestRunner  -DfailIfNoTests=false
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/parallel"},
		glue = {"parallel"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"

				
		},
		tags= "@contact_us"
		
		)

public class MyTestRunner {

}
