package restAPI;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {
	
	@Test
	public void test1() {
		
		 RestAssured.baseURI = "http://localhost:3000/employees";
				 
				 RequestSpecification request = RestAssured.given();
				 
				 JSONObject jobj = new JSONObject();
				 
				 jobj.put("name", "Lakshman");
				 jobj.put("salary", "38000");
				 
				 
				 
				 
				 Response response = request.contentType(ContentType.JSON)
						 			 .accept(ContentType.JSON)
						 			 .body(jobj.toString())
						 			 .put("/update/8");
				 		
				String responsebody = response.getBody().asString();
				
				System.out.println(responsebody);

}

}
