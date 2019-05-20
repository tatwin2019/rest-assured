package GL.rest_assured;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Country_GET_Request {

	@org.testng.annotations.Test
	public void getCountryDetails() {
		
		RestAssured.baseURI="http://restcountries.eu/rest/v2/name";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET, "/Poland");
				
		String responseBody = response.getBody().asString();
		System.out.println("Body: " + responseBody);
		
		int statusCode = response.getStatusCode();
		System.out.println("StatusCode: " + statusCode);
		
		JsonPath json = new JsonPath(responseBody);
		String capital = json.getString("capital[0]");
		Assert.assertEquals("Warsaw", capital);
	}
}
