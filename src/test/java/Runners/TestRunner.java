package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/EndToEndWorkFlow.feature",
        glue = {"stepDefinations", "ApplicationHooks"},
        plugin= {"pretty","html:test-outout", "json:json_output/cucumber.json"
                , "junit:junit_xml/cucumber.xml",
                "html:target/cucumber-reports.html"},
        monochrome = false,
        dryRun = false
)

public class TestRunner {

}
