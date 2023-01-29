package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", 
                 glue = { "stepdefinition" }, 
                 plugin = { "pretty","html:target/reports.html", "junit:target/cucumber-reports/reports.xml", "json:target/cucumber.json",
		                  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class TestRunner {

}