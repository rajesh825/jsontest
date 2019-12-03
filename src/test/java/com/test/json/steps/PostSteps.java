package com.test.json.steps;


import com.test.json.datamodels.Post;
import com.test.json.util.RestAssuredExtension;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.test.json.Utils.TestUtil.getPost;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class PostSteps {
    private static final Logger logger = LoggerFactory.getLogger(PostSteps.class);
    private static final String endPoint = "https://jsonplaceholder.typicode.com/Posts/";
    public static ResponseOptions<Response> response;


    @Given("^I want to execute service \"([^\"]*)\"$")
    public void iWantToExecuteService(String serviceName) throws Throwable {
        logger.info("User about to invoke " + serviceName);

    }

    @When("^I invoke the end point \"([^\"]*)\"$")
    public void iInvokeTheEndPoint(String endpoint) throws Throwable {

        response = RestAssuredExtension.PostOpsWithBody(endpoint, getPost());

    }


    @Then("^I validate \"([^\"]*)\"$")
    public void iValidate(String arg1) throws Throwable {
        assertEquals("Status Check Failed!", 201, response.getStatusCode());

    }


    // GET POST STEPS

    @Given("^I perform GET operation for post id \"([^\"]*)\"$")
    public void i_perform_GET_operation_for_post_id(String postID) throws Throwable {
        response = RestAssuredExtension.getOperation(endPoint + postID);
    }

    @Then("^I should see correct post details with id \"([^\"]*)\"$")
    public void i_should_see_correct_post_details_with_id(String postID) throws Throwable {
        Post post = response.getBody().as(Post.class);
        assertThat(post.getId(), equalTo(postID));
    }



   /* @Then("^I should see correct post details$")
    public void i_should_see_correct_post_details() throws Throwable {
        
        Post post = response.getBody().as(Post.class);
         assertThat(post.getId(), equalTo(streetName));
        
         
    }*/


}