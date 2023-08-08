package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/EndToEndWorkFlow.feature",
        glue = {"stepDefinations", "ApplicationHooks"},
        plugin= {"pretty","json:json_output/cucumber.json"
                , "junit:junit_xml/cucumber.xml",
                "html:target/cucumber-reports.html"},
        publish = true,
        monochrome = false,
        dryRun = false
)

public class TestRunner {

}
