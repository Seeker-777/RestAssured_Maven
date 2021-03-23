package restAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void test1() {
		
 RestAssured.baseURI = "http://localhost:3000/employees";
		 
		 RequestSpecification request = RestAssured.given();
		 
		 Response response = request.contentType(ContentType.JSON)
				 			 .accept(ContentType.JSON)
				 			 .body("{\r\n"
				 			 		+ "    \"name\": \"Ganga\",\r\n"
				 			 		+ "    \"salary\": \"40000\",\r\n"
				 			 		+ "    \"id\": 2\r\n"
				 			 		+ "}")
				 			 .post("/create");
		 		
		String responsebody = response.getBody().asString();
		
		System.out.println(responsebody);
		
	}
	
}
