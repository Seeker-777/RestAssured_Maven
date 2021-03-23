package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestwithParam {
	
	@Test
	public void test1() {
		
		 RestAssured.baseURI = "http://localhost:3000/employees";
		 
		 RequestSpecification request = RestAssured.given();
		 
		 Response response = request.param("id", "1").get();
		 
		 String responsebody = response.getBody().asString();
		 
		 System.out.println("Response Body" + responsebody);
		 
		 
		 //checking the response code
		 int responsecode = response.getStatusCode();
		 
		 Assert.assertEquals(200,responsecode);
		
		 
		 String contenttype = response.header("Content-Type");
		 
		 System.out.println("Content Type"+ contenttype);
		 
		 Assert.assertEquals("application/json; charset=utf-8", contenttype);
		 
		 //checking name in the response
		 Assert.assertTrue(responsebody.contains("Pankaj"));
		 
		 //checking the exact node
		 JsonPath jpath = response.jsonPath();
		 
		 List <String> name = jpath.get("name");
		 
		 Assert.assertTrue(name.get(0).contains("Pankaj"));
		 
		 
		 
	}

}
