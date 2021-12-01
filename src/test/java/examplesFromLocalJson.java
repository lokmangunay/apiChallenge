import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class examplesFromLocalJson {

    @Test
    public void test_get(){
        baseURI="http://localhost:3000/";
        given().
                get("/users").
        then().
            statusCode(200).
            log().all();
        //http://localhost:3000/users

    }

    @Test
    public void test_get2(){
        baseURI="http://localhost:3000/";
        given().
                param("name","Automation").
                get("/subjects").
        then().
                statusCode(200).
                log().all();
        // http://localhost:3000/subjects?name=Automation
    }

    @Test
    public void test_get3(){
        baseURI="http://localhost:3000/";
        given().
                param("id","2").
                get("/subjects").
                then().
                statusCode(200).
                log().all();
       // http://localhost:3000/subjects?id=2      bunun metod hali
    }


    @Test
    public void testPost(){

        JSONObject request=new JSONObject();
        request.put("firstName","Tom");
        request.put("lastName","Cooper");
        request.put("subjectId",1);
        request.put("id",1);

        baseURI="http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .
        when().
                post("/users").
        then()
                .statusCode(201)
                .log().all();
            }

}
