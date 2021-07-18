package com.sample.cucumber.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = { "src/test/resources/features/" }, glue = {
		"com.sample.cucumber.stepdefinations.SampleStepDefination" }, plugin = { "pretty" }, dryRun = true)

public class TestRunner {

}
