import com.trendyol.apitest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.nashorn.internal.parser.JSONParser;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class trendyolAPI extends BaseMethods {

    @Test
    public void bySearch() {

        String responseString = getMoviesAsString(movieName, apiKeyLokman);

        int indexOfMovie = getIndexOfMovieFromArray(responseString, "Harry Potter and the Sorcerer's Stone");
        String movieImdbId = getMovieImdbID(responseString, indexOfMovie);

        Response movieDetailsAsResponseAccordingToIMDBId = getMovieDetailsAsResponseAccordingToIMDBId(movieImdbId, apiKeyLokman);

        JSONObject movieDetailsObj = new JSONObject(movieDetailsAsResponseAccordingToIMDBId.asString());
        String title = getKeyValueFromJSON(movieDetailsObj, "Title");
        String year = getKeyValueFromJSON(movieDetailsObj, "Year");
        String released = getKeyValueFromJSON(movieDetailsObj, "Released");


        System.out.println("Title:" + title +
                "\nYear: " + year +
                "\nReleased" + released);


        System.out.println("-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*" +

                "\nresponse body: " + movieDetailsAsResponseAccordingToIMDBId.getBody() +
                "\nStatus code: " + movieDetailsAsResponseAccordingToIMDBId.getStatusCode() +
                "\nStatus line: " + movieDetailsAsResponseAccordingToIMDBId.getStatusLine() +
                "\nTime: " + movieDetailsAsResponseAccordingToIMDBId.getTime());
    }


}