package com.rest.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * 
 * @author rupali.sinalkar@cognizant.com
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
glue= {"com.cognizant.stepDefinition"}
//tags= {"@test5"}
)
public class TestRunner {

}
