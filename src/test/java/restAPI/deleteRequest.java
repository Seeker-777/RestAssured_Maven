package restAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class deleteRequest {

	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		 
		 RequestSpecification request = RestAssured.given();
		 
		 Response response = request.delete("/delete/8");
		
		 String responsebody = response.getBody().asString();

		 System.out.println(responsebody);
	}
}
