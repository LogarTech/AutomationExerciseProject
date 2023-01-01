package com.mentoringwithAhmet.automationexecise.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/automationexercisementoring",
        glue = "com/mentoringwithAhmet/automationexecise/stepdefinitions",
        dryRun = false,   // true-->  // it gives only the snips that we have highlighted in .feature file and are not implemented in stepDef class
        tags = "@testCase13",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}
)

public class AutomationExerciseRunner {
}

