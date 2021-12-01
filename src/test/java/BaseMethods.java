import com.trendyol.apitest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.nashorn.internal.parser.JSONParser;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class BaseMethods {

    String apiKeyLokman = "a5ce9e6b";
    String movieName = "harry potter";

    @BeforeTest
    public void setUp() {
        baseURI = "http://www.omdbapi.com/";

    }


    public String getMoviesAsString(String nameOfMovie, String apiKey) {

        Response response = RestAssured.get("?s=" + nameOfMovie + "&apikey=" + apiKey);
        String moviesAsString = response.asString();

        return moviesAsString;

    }

    public Response getMoviesAsResponse(String nameOfMovie, String apiKey) {
        Response response = RestAssured.get("?s=" + nameOfMovie + "&apikey=" + apiKey);
        return response;
    }

    public Response getMovieDetailsAsResponseAccordingToIMDBId(String imdbID, String apiKey) {
        Response response = RestAssured.get("?i=" + imdbID + "&apikey=" + apiKey);
        return response;
    }

    public String getKeyValueFromJSON(JSONObject jsonObject, String keyValue) {
        return jsonObject.getString(keyValue);

    }

    public int getIndexOfMovieFromArray(String response, String nameOfMovie) {
        JSONObject obj = new JSONObject(response);
        JSONArray arr = obj.getJSONArray("Search");
        JSONObject movieObj;
        int counter = 0;
        for (int i = 0; i < arr.length(); i++) {
            movieObj = arr.getJSONObject(i);
            String movieTitle = getKeyValueFromJSON(movieObj, "Title");
            if (movieTitle.equals(nameOfMovie)) {
                System.out.println(movieObj);
                break;
            } else {
                counter++;
            }
        }
        return counter;
    }

    public String getMovieImdbID(String response, int movieIndex) {
        JSONObject obj = new JSONObject(response);
        JSONArray arr = obj.getJSONArray("Search");
        JSONObject movieObj;
        movieObj = arr.getJSONObject(movieIndex);
        String movieImdbId = getKeyValueFromJSON(movieObj, "imdbID");

        return movieImdbId;

    }


}
