package restAPIBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteRequestBDD {

	@Test
public void test1() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.when()
					.delete("/delete/7")
					.then()
					.statusCode(200)
					.log()
					.all();
					
	}

}
