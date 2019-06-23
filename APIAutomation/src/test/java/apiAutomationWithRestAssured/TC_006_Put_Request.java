package apiAutomationWithRestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_006_Put_Request {
	
	@SuppressWarnings("unchecked")
	@Test
	public void updateData()
	{
		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject params = new JSONObject();
		params.put("id", "111");
		params.put("Book Name", "Bastobota");
		params.put("author", "Seraj islam");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(params.toJSONString());
		
		Response httpResponse = httpRequest.request(Method.PUT, "/posts/111");
		String responseBody = httpResponse.getBody().asString();
		System.out.println("Response body is " +responseBody);
		
		int responseCode = httpResponse.getStatusCode();
		System.out.println("Response code is " + responseCode);
	}

}
