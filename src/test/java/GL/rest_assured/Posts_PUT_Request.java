package GL.rest_assured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Posts_PUT_Request {
	
	@Test
	public void putRequest() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3000;
		
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.header("Content-type", "application/json");
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("title", "Lorem ipsum dolor sit amet");
		requestParams.put("author", "mwojciechowski");
		
		httpRequest.body(requestParams.toJSONString());
		
		Response response = httpRequest.request(Method.PUT, "posts/3");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
}
