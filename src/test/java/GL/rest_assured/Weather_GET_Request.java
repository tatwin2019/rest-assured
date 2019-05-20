package GL.rest_assured;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Weather_GET_Request {
	
	@org.testng.annotations.Test
	public void getWeatherDetails() {
		
		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5";
		
		Response response = 
		RestAssured.given()
			.when()
				.get("/weather?q={cityName}&units={unit}&appid={appid}","Koszalin","metric","9a6afd6a2a2d212bee68e2f8533bf395")
			.then()
				.assertThat()
				.contentType(ContentType.JSON)
				.extract().response();
		
		String jsonAsString = response.asString();
		System.out.println(jsonAsString);
	}

}
