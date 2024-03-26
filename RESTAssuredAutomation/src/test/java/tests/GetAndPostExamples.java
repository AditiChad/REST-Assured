package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class GetAndPostExamples {

	
	@Test
	public void testGet() {

		baseURI = "https://reqres.in/api";

		given().
			get("/users?page=2").
		then().
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("George","Rachel"));
	}
	
	@Test
	public void testPost() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject request = new JSONObject();
		request.put("name", "Aditi");
		request.put("job", "Consultant");
		
		baseURI = "https://reqres.in/api";

		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		
	}
	
	
}
