package com.test.json.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "json:target/cucumber_apm.json"},
        glue = {"com.test.json.steps"},
        features = {"src/test/resources/features/"},
        strict = true,
        tags = {"~@Ignore"},
        snippets = SnippetType.CAMELCASE
)
public class CukesRunnerTest {
    //Nothing needed here
}