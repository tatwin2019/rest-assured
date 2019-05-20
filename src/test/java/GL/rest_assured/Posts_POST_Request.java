package GL.rest_assured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Posts_POST_Request {
	
	@Test
	public void postRequest() {
		
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3000;
		
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.header("Content-type", "application/json");
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("title", "Lorem ipsum");
		requestParams.put("author", "TATWIN");
		
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.POST, "posts");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		
/*		Response response = 
		RestAssured.given()
			.contentType("application/json")
			.body(requestParams.toJSONString())
			.when()
			.post("/posts")
			.then()
			.statusCode(201)
			.extract()
			.response();*/
			
	}

}
