package apiAutomationWithRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_Get_Request {
	
	@Test
	public void googleMapTest()
	{
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		
		Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response body is "+ responseBody);
		
		int statusCode = response.getStatusCode();
		System.out.println("Stattus code is " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		System.out.println("Status line is " + statusLine);
		

		
		String contentType = response.getHeader("Content-Type");
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
		
		
		String contentEncoding = response.getHeader("Content-Encoding");
		Assert.assertEquals(contentEncoding, "gzip");
		
		
		String server = response.getHeader("Server");
		Assert.assertEquals(server, "scaffolding on HTTPServer2");
		
		
		
	}

}
