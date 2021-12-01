import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Test_POST {
    @Test
    public void testPost(){

        Map<String,Object> map= new HashMap<String ,Object >();

        map.put("name","Raghav");
        map.put("job","Teacher");



        JSONObject request=new JSONObject(map);

        request.put("name","Raghav");
        request.put("job","Teacher");

        System.out.println(map);
        System.out.println("---------");
      //  System.out.println(request.toJSONString);

                given()
    //                 .body(request())
                .when()
                     .post("https://reqres.in/api/users")
                .then()
                     .statusCode(201);
    }



    @Test
    public void testPUT(){




 
    }
}
