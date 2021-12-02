import com.trendyol.apitest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.nashorn.internal.parser.JSONParser;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.*;
import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class trendyolAPI extends BaseMethods {

    String apiKeyLokman = "a5ce9e6b";
    String movieName = "lord of the rings";
    String specificMovieName="The Lord of the Rings: The Two Towers";

    @Test
    public void bySearch() {

        String responseString = getMoviesAsString(movieName, apiKeyLokman);

        int indexOfMovie = getIndexOfMovieFromArray(responseString, specificMovieName);
        String movieImdbId = getMovieImdbID(responseString, indexOfMovie);

        Response movieDetailsAsResponseAccordingToIMDBId = getMovieDetailsAsResponseAccordingToIMDBId(movieImdbId, apiKeyLokman);

        JSONObject movieDetailsObj = new JSONObject(movieDetailsAsResponseAccordingToIMDBId.asString());
        String title = getKeyValueFromJSON(movieDetailsObj, "Title");
        String year = getKeyValueFromJSON(movieDetailsObj, "Year");
        String released = getKeyValueFromJSON(movieDetailsObj, "Released");



        System.out.println("ImbdID: " +movieImdbId+
                             "\nTitle:" + title +
                              "\nYear: " + year +
                             "\nReleased" + released);


        System.out.println("-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*" +

                "\nStatus code: " + movieDetailsAsResponseAccordingToIMDBId.getStatusCode() +
                "\nStatus line: " + movieDetailsAsResponseAccordingToIMDBId.getStatusLine() +
                "\nTime: " + movieDetailsAsResponseAccordingToIMDBId.getTime());


        Assertion assertion=new Assertion();

        assertion.assertEquals(movieDetailsAsResponseAccordingToIMDBId.getStatusCode(),200);
        assertion.assertEquals(year,"2002");
        assertion.assertEquals(title,specificMovieName);
    }



}