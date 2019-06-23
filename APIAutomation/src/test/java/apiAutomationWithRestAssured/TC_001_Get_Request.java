package apiAutomationWithRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_Get_Request {
	
	@Test
	void getWeatherDetails()
	{
		//base url
		RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
		
		// request specification
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.headers("Content-Type","applicatiob/json");
		
		Response response = httpRequest.request(Method.GET, "/Dhaka");
		
		//printing response body
		String responseBody = response.getBody().asString();
		System.out.println("Response body is " + responseBody);
		
		//validating response code & printing
		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode, 200);
		System.out.println("Response code is " +responseCode);
		
		//validating status line & printing
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		System.out.println("Status line is " + statusLine);
		
		
		
	}

}
