import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.testng.annotations.Test;

public class GetTest {
  @Test
  public void f() {
	  given().
	  get("https://reqres.in/api/users?page=2").
	  then().
	  statusCode(200).
	  body("data.id[0]",equalTo(7)).
	  body("data.email[0]",equalToIgnoringCase("michael.lawson@reqres.in")).
	  body("data.first_name[0]",equalToIgnoringCase("Michael")).
	  log().all();
  }
  @Test
  public void s() {
	  given().
	  get("http://localhost:3000/profile").
	  then().
	  statusCode(200).
	  body("id[9]",equalTo(11)).
	  body("first_name[9]",equalToIgnoringCase("amardeep"));
  }
}
