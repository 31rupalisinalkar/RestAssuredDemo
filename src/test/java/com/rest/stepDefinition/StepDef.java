package com.rest.stepDefinition;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.rest.base.BaseClass;
import com.rest.utils.RestUtil;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
/**
 * 
 * @author rupali.sinalkar@cognizant.com
 *
 */

public class StepDef extends BaseClass {
	private String baseUrl,httpMethod,endPoint;
	private Response response;
	

	@Before
	public void executeBeforeScenario() throws IOException
	{
		BaseClass.loadProperties();
	}

	@Given("Set the base url")
	public void setBaseUrl() throws IOException
	{
		baseUrl=BaseClass.getBaseUri();
		//System.out.println(baseUrl);
	}
	@When("^(.+) endpoint is accessed for (.+) method$")
	public void testGetMethod(String endpoint,String httpMethod) throws IOException
	{
		this.endPoint=endpoint;
		this.httpMethod=httpMethod;
		if(httpMethod.equals("get"))
		{
			response = RestUtil.executeGetMethod(baseUrl,endpoint);
		}
		else if(httpMethod.equals("post") && endpoint.equals("users"))
		{
			String userRequest = BaseClass.getUserDetails();
			response = RestUtil.executePostMethod(baseUrl,endpoint,userRequest);
		}
		else if(httpMethod.equals("post") && endpoint.equals("posts"))
		{
			String postsRequest = BaseClass.getPostDetails();
			response = RestUtil.executePostMethod(baseUrl,endpoint,postsRequest);
		}
	}

	@Then("^validate the status code$")
	public void validateStatusCode()
	{
		//System.out.println("status code: "+response.getStatusCode());
		if(httpMethod.equals("get"))
				Assert.assertEquals(response.getStatusCode(), 200,"GET API status code is not 200 for "+endPoint +" endpoint");
		else if(httpMethod.equals("post"))
			Assert.assertEquals(response.getStatusCode(), 201,"POST API status code is not 201 for "+endPoint +" endpoint");
	}
	
	@And("^validate the json response received for user id (.+)$")
	public void validateNewUserId(int userId) throws ParseException
	{
		String jsonResponse = response.getBody().asString();
		JSONParser jsonParser = new JSONParser();		
		JSONArray obj= (JSONArray) jsonParser.parse(jsonResponse);
		JSONObject userDetails = (JSONObject) obj.get(userId-1);
		//System.out.println(userDetails.get("name"));		
		Assert.assertEquals(userDetails.get("name"),"Clementina DuBuque" ,"Name retrieved for user 10 is invalid");
		
	}
	
	@And("^validate the json response and check new user id generated$")
	public void validateNewUserDetails() throws ParseException
	{
		String jsonResponse = response.getBody().asString();
		JSONParser jsonParser = new JSONParser();		
		JSONObject obj = (JSONObject) jsonParser.parse(jsonResponse);
		Assert.assertEquals(Integer.parseInt(obj.get("id").toString()),11 ,"User Id generated is not correct");		
	}
	
	@And("^validate the title in response for post id (.+)$")
	public void validateTitle(int postId) throws ParseException
	{
		String jsonResponse = response.getBody().asString();
		JSONParser jsonParser = new JSONParser();		
		JSONArray obj= (JSONArray) jsonParser.parse(jsonResponse);
		JSONObject postDetails = (JSONObject) obj.get(postId-1);
		//System.out.println(postDetails.get("title"));		
		Assert.assertEquals(postDetails.get("title"),"at nam consequatur ea labore ea harum" ,"Title retrieved for user 10 is invalid");
	}
	
	@And("^validate the name of id (.+)$")
	public void validateNameForCommentId4(int commentId) throws ParseException
	{

		String jsonResponse = response.getBody().asString();
		JSONParser jsonParser = new JSONParser();		
		JSONArray obj= (JSONArray) jsonParser.parse(jsonResponse);
		JSONObject postDetails = (JSONObject) obj.get(commentId-1);
		//System.out.println(postDetails.get("name"));
		Assert.assertEquals(postDetails.get("name"),"alias odio sit" ,"Name retrieved for user 10 is invalid");
		
	}
   @And("^validate the json response and check new post id generated$")
   public void validateNewPostId() throws ParseException
   {
	   String jsonResponse = response.getBody().asString();
		JSONParser jsonParser = new JSONParser();		
		JSONObject obj = (JSONObject) jsonParser.parse(jsonResponse);
		//System.out.println(obj.get("id").toString());
		Assert.assertEquals(Integer.parseInt(obj.get("id").toString()),101 ,"User Id generated is not correct");
   }
   
}
