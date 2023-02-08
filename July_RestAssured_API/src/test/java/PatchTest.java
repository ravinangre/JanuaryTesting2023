import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchTest {
	@Test
	  public void patch_data() {
		  JSONObject request = new JSONObject();
		  request.put("email","pradnya.Madale@gmail.com");
	//	  request.put("first_name","Pradnya");
		  request.put("last_name","Madale");
		  
		  System.out.println(request.toJSONString());
		  
		  given().
		  contentType(ContentType.JSON).
		  accept(ContentType.JSON).
		  header("Content-Type","application/json").
		  body(request.toJSONString()).
		  when().
		  patch("http://localhost:3000/profile/5").
		  then().
		  statusCode(200).
		  log().all();
	  }
}
