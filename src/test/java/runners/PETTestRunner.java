package runners;

import org.json.simple.parser.ParseException;
import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.testng.annotations.AfterSuite;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"./Features/PET.feature"},
		tags={},
		glue={"stepdefinitions"},
		plugin={"pretty:STDOUT",
				"html:.\\target\\Reports\\cucumber-pretty",
				"json:.\\target\\Reports\\cucumber-json\\cucumber.json"
		},monochrome = true)

public class PetTestRunner extends CucumberSeleniumTest{

	@AfterSuite
	public void afterExecution() 
	{
	}
	
}
