package testrunner_excel;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {"src/test/resources/Features/Excel.feature"},
		glue = {"excel_stepdefinition", "apphooks"},
				 plugin= {"pretty" ,
						 "html:target/creport/cucumber",
						 "json:target/creport/cucumber.json",
				 		 "junit:target/creport/cucumber.xml"}
		
		)
public class Excel_TestRunner extends AbstractTestNGCucumberTests {

}
