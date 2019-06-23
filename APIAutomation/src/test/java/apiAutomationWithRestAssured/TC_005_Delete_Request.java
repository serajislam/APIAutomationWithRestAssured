package apiAutomationWithRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_005_Delete_Request {
	
	
	@Test
	public void delData()
	{
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response httpResponse = httpRequest.request(Method.DELETE, "posts/3");
		
		String responseBody = httpResponse.getBody().asString();
		System.out.println("Response body is " + responseBody);
		
		int responseCode = httpResponse.getStatusCode();
		System.out.println("Response code is " + responseCode);
	}

}
