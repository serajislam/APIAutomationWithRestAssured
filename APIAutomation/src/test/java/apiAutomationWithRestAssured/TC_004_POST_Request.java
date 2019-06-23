package apiAutomationWithRestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_004_POST_Request {
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void addData()
	{
		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.headers("Content-Type","application/json");
		
		JSONObject params = new JSONObject();
		params.put("Student id", "103");
		params.put("Student Name", "Satveek Islam");
		params.put("Student Roll No", "3");
		params.put("id", "3");
		
		httpRequest.body(params.toJSONString());
		
		Response httpResponse = httpRequest.request(Method.POST, "/posts");
		
		String responseBody = httpResponse.getBody().asString();
		System.out.println(responseBody);
		
		int responseCode = httpResponse.getStatusCode();
		System.out.println("Response code is" + responseCode);
		
		String statusLine = httpResponse.getStatusLine();
		System.out.println("Status line is" + statusLine);
		
	}

}
