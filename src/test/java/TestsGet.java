import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class TestsGet {


    @Test
    public void test_1(){
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                        statusCode(200).
                body("data.id[1]",equalTo(8)).
                body("data.first_name",hasItems("Michael","Lindsay")).
                            log().all();
    }

    @Test
    public void test_2(){
        given().
                get("").
                then().
                statusCode(200).
                body("data.id[1]",equalTo(8)).
                body("data.first_name",hasItems("Micheal","Lindsay")).
                log().all();
    }
}
