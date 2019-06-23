package apiAutomationWithRestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003_POST_Request {
	
	
	@SuppressWarnings("unchecked")
	public void register()
	{
		
		RestAssured.baseURI = "";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		
		JSONObject httpParams = new JSONObject();
		
		httpParams.put("FirstName", "Seraj");
		httpParams.put("LastName", "Islam");
		httpParams.put("Email", "serajislam1988@gmail.com");
		httpParams.put("UserName", "serajislam1988");
		httpParams.put("Password", "seraj@1988");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(httpParams.toJSONString());
		
		
		Response response = httpRequest.request(Method.POST,"/register");
		String responseBody = response.getBody().asString();
		System.out.println("Response body is " + responseBody);
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		System.out.println("Status code is "+statusCode);
		
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		System.out.println("Status line is "+statusLine);
		
		
	}

}
