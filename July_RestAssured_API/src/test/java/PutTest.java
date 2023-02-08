import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutTest {
	@Test
	  public void put_data() {
		  JSONObject request = new JSONObject();
		  request.put("email","pradnya.Mandale@gmail.com");
		  request.put("first_name","Pradnya");
		  request.put("last_name","Mandale");
		  
		  System.out.println(request.toJSONString());
		  
		  given().
		  contentType(ContentType.JSON).
		  accept(ContentType.JSON).
		  header("Content-Type","application/json").
		  body(request.toJSONString()).
		  when().
		  put("http://localhost:3000/profile/5").
		  then().
		  statusCode(200).
		  log().all();
	  }
}
