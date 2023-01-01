package com.mentoringwithAhmet.automationexecise.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/uiFailedTests.txt",
        glue = "com/test/weborder/stepdefinitions",
        dryRun = false,   // true-->  // it gives only the snips that we have highlighted in .feature file and are not implemented in stepDef class
        tags = "@regression",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"} // in Cucumber we need the plugin to be able to generate reports

)

public class AutomationExerciseReRunner {
}
