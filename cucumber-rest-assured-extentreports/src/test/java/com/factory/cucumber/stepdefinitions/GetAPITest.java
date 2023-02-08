package com.factory.cucumber.stepdefinitions;



import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.logging.Logger;
import org.junit.Assert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



import com.aventstack.extentreports.Status;
import com.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;

public class GetAPITest {

    private RequestSpecification request;
    private Response response;
	private final static Logger logger = Logger.getLogger(GetAPITest.class.getName());
	public static String apiEndPointUri;
	public static String testName;
	public static String CONTENT_TYPE;
	public static String STATUS_CODE;
	public static String FILE_PATH;
	public static String REQUESTBODY;
	public static String RESPONSEBODY;
 
        
	@Given("^Color Lover Patterns API endpoint exists as \"([^\"]*)\" for test case \"([^\"]*)\"$")
	public void color_Lover_Patterns_API_endpoint_exists_as_for_test_case(String URL, String testCaseName)
     {
    	RestAssured.baseURI = URL;
		String apiHostName = URL;
		apiEndPointUri = String.format("%s%s", apiHostName, URL);
		testName = testCaseName;
		Reporter.addStepLog(Status.PASS + " :: Cucumber Hostname URL is :: " + apiEndPointUri);
		logger.info("Cucumber Hostname URL is :: " + apiEndPointUri);
		logger.info("Cucumber Test case name is :: " + testName);
        request = RestAssured.given().
                header("User-Agent", "PostmanRuntime/7.28.4");

    }

	@When("^I send a valid Get Request to Get Patterns API XML File$")
	public void i_send_a_valid_Get_Request_to_Get_Patterns_API_XML_File() {
        response = request.get();
        STATUS_CODE = String.valueOf(response.getStatusCode());
		RESPONSEBODY = response.getBody().asString();
		Reporter.addStepLog(Status.PASS + " :: Request successfully processed");
		Reporter.addStepLog("Response is :: " + RESPONSEBODY);
    }

	@Then("^I try to verify the status code is \"([^\"]*)\"$")
	public void i_try_to_verify_the_status_code_is(String statusCode)
     {
    	if (statusCode.equals(String.valueOf(STATUS_CODE))) {
			Assert.assertEquals(STATUS_CODE, statusCode);
			Reporter.addStepLog(Status.PASS + " :: Status Code is :: " + STATUS_CODE);
			logger.info("Status Code is :: " + STATUS_CODE);
		} else {
			Assert.assertEquals(STATUS_CODE, statusCode);
			Reporter.addStepLog(Status.FAIL + " :: Status Code is :: " + STATUS_CODE);
			logger.info("Status Code is not as expected :: " + STATUS_CODE);
		}
    }

	@Then("^I should see the Number of Views of Pattern \"([^\"]*)\" Greater Than \"([^\"]*)\"$")
	public void i_should_see_the_Number_of_Views_of_Pattern_Greater_Than(String patternNum, String expectedNum) throws Throwable{
    	String actualNum =response.then().extract().path("patterns.pattern[" + patternNum + "].numViews").toString();
    	Reporter.addStepLog("Actual Value is  ::" +actualNum );
		Reporter.addStepLog("Expected Value Greater Than  ::" + expectedNum);
		
		logger.info("Actual Value is  ::" + actualNum);
		logger.info("Expected Value is  ::" + expectedNum);
		
		
		if (Integer.parseInt(actualNum)> Integer.parseInt(expectedNum)) {
			 assertThat(actualNum, greaterThan(expectedNum));
			Reporter.addStepLog(Status.PASS + " " + patternNum + " : Expected value : " + expectedNum
					+ " mathches with Actual Value : " + actualNum);
		} else {
			Reporter.addStepLog(Status.FAIL + " " + patternNum + " : Expected value : " + expectedNum
					+ " do not matches with Actual Value : " + actualNum);
			 assertThat(actualNum, greaterThan(expectedNum));
		}
		
		
    	// System.out.println(response.then().extract().path("patterns.pattern[" + patternNum + "].numViews").toString());
     //   assertThat(actualNum, greaterThan(expectedNum));
       
    }
    

   
}