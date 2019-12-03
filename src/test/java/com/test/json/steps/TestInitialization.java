package com.test.json.steps;

import com.test.json.util.RestAssuredExtension;
import cucumber.api.java.Before;

public final class TestInitialization {

    @Before
    public void TestSetup() {
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
    }
}