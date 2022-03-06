package com.sparta.swaglabstesting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"progress","html:target/testReport.html", "json:target/jsonReport.json"},
        monochrome = true,
        publish = true

//        tags= "@inventory-sorting"
        )

public class TestRunner {
}