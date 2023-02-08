import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DeleteTest {
	@Test
	  public void Delete_local_method() {
	  given().
	  delete("http://localhost:3000/profile/3").
	  then().
	  statusCode(200).
	  log().all();
	  
	  Response response= given().
			  get("http://localhost:3000/profile/3");
			  int statusCode = response.statusCode();
			  Assert.assertEquals(statusCode, 404);
	  }
}
