package restAPIBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequestBDD {
	@Test
	public void test1() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body("{\r\n"
							+ "    \"name\": \"Rougue\",\r\n"
							+ "    \"salary\": \"27000\"\r\n"
							+ "}")
					.when()
					.put("/update/7")
					.then()
					.statusCode(200)
					.body("name", Matchers.equalTo("Rougue"))
					.body("salary", Matchers.equalTo("27000"))
					.log()
					.all();
					
	}

}
