import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;


public class GoogleTest {
  @Test
  public void f() {
	  
	  Response resp = get("https://www.google.com");
	  
	  System.out.println(resp.getStatusCode());
	  System.out.println(resp.getStatusLine());
	  System.out.println(resp.getHeader("content-type"));
	  System.out.println(resp.getTimeIn(TimeUnit.SECONDS));
	//  System.out.println(resp.getBody().asString());
	  
  }
  @Test
  public void utTest() {
	  when().
	  get("https://www.utkarshaaacademy.com").
	  
	  then().
	  statusCode(200);
  }
  @Test
  public void utTest1() {
	  when().
	  get("https://utkarshaaacademy.com/contactus/").
	  
	  then().
	  statusCode(404);
  }
}
