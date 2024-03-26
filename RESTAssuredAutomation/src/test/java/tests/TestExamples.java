package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class TestExamples {

	@Test
	public void test_1() {

		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.body().asString());
		int code = response.getStatusCode();

		// Assert.assertEquals(code, 200);
		Assert.assertEquals(code, 201);
	}

	@Test
	public void test_2() {

		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.body().asString());
		int code = response.getStatusCode();

		Assert.assertEquals(code, 200);
		// Assert.assertEquals(code, 201);
	}

	@Test
	public void test_3() {

		baseURI = "https://reqres.in/api";

		given().get("/users?page=2").then().body("data[1].id", equalTo(8));
	}
}
