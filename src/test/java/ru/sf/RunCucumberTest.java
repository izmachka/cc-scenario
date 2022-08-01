package ru.sf;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features")
public class RunCucumberTest {
    @AfterClass
    public static void finalizeResources() {
        StepDefinitions.webDriver.close();
    }
}
