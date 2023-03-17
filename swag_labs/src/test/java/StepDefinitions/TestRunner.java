package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources/features/Login.feature",
glue={"StepDefinitions"},
monochrome = true,
plugin={"pretty","html:target/html-reports.html","html:target/cucumber-reports.html"} )
public class TestRunner {
//,"html:target/cucumber-reports.html"
}