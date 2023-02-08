import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class postTest {
	 @Test
	  public void post_data() {
		  JSONObject request = new JSONObject();
		  request.put("id", 13);
		  request.put("email","aniket.deshmukh@gmail.com");
		  request.put("first_name","Aniket");
		  request.put("last_name","Deshmukh");
		  
		  System.out.println(request.toJSONString());
		  
		  given().
		  contentType(ContentType.JSON).
		  accept(ContentType.JSON).
		  header("Content-Type","application/json").
		  body(request.toJSONString()).
		  when().
		  post("http://localhost:3000/profile").
		  then().
		  statusCode(201).
		  log().all();
	  }
}
