package com.rest.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * 
 * @author rupali.sinalkar@cognizant.com
 *
 */

public class RestUtil {
	
	public static Response executeGetMethod(String baseUrl,String endPoint)
	{
		RestAssured.baseURI=baseUrl;
		Response res = RestAssured.given()
				.get("/"+endPoint);
		return res;
	}
	
	public static Response executePostMethod(String baseUrl,String endPoint,String request)
	{
		RestAssured.baseURI=baseUrl;
		Response res = RestAssured.given()
				.header("Content-Type","application/json")
				.body(request)
				.post("/"+endPoint);
		return res;
	}

}
