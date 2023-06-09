package runner;





import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


import org.junit.runner.RunWith;




@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/functionalFeatures/4add_event.feature"

                , glue = "stepDefinitions",

                plugin = { "pretty", "html:target/reports/report.html","json:target/reports/report.json" }

)

public class TestRunner {

}
