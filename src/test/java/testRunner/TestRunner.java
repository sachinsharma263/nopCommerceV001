package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./Features/",
       // features = {"./Features/Customer.feature","./Features/Customer.feature"},
        glue = "stepDefinitions",
        monochrome=true,
        dryRun =false,
        plugin={"pretty","html:test-output"},
        tags = {"@smoke,@regression"}//smoke OR regression
        //tags = {"@smoke","@regression"} scenerio whih falls under both tags smoke AND regression

)
public class TestRunner {
}
