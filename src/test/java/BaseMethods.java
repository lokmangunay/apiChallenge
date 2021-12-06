import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

import java.util.logging.Logger;

import org.json.*;

import static com.trendyol.apitest.config.Constants.*;
import static io.restassured.RestAssured.baseURI;

public class BaseMethods {
    final static Logger logger = Logger.getLogger(String.valueOf(BaseMethods.class)); //logger object

    @BeforeTest
    public void setUp() {
        baseURI = BASEURI;
    }


    protected String getMoviesAsString(String nameOfMovie, String apiKey) {

        Response response = RestAssured.get("?s=" + nameOfMovie + "&apikey=" + apiKey);
        return response.asString();

    }

    protected Response getMoviesAsResponse(String nameOfMovie, String apiKey) {
        Response response = RestAssured.get("?s=" + nameOfMovie + "&apikey=" + apiKey);
        return response;
    }

    protected Response getMovieDetailsAsResponseAccordingToIMDBId(String imdbID, String apiKey) {
        Response response = RestAssured.get("?i=" + imdbID + "&apikey=" + apiKey);
        return response;
    }

    protected String getKeyValueFromJSONObj(JSONObject jsonObject, String keyValue) {
        return jsonObject.getString(keyValue);

    }

    protected int getIndexOfMovieFromArray(String response, String nameOfMovie) {   // in this method,
        JSONObject obj = new JSONObject(response);
        JSONArray arr = obj.getJSONArray("Search");
        JSONObject movieObj;
        int counter = 0;
        for (int i = 0; i < arr.length(); i++) {
            movieObj = arr.getJSONObject(i);
            String movieTitle = getKeyValueFromJSONObj(movieObj, "Title");
            if (movieTitle.equals(nameOfMovie)) {
                logger.info("\n---------MOVIE DETAILS--------\n" +
                        movieObj.toString(4) + "\n \n");  // the value of 4 makes the json object prettier
                break;
            } else {
                counter++;
            }
        }
        return counter;  //counter value gives the index of the desired movie in the array that is in response
    }

    protected String getMovieImdbID(String response, int movieIndex) {
        JSONObject obj = new JSONObject(response);
        JSONArray arr = obj.getJSONArray("Search");
        JSONObject movieObj;
        movieObj = arr.getJSONObject(movieIndex);
        String movieImdbId = getKeyValueFromJSONObj(movieObj, "imdbID");
        logger.info("imdbID for " + getKeyValueFromJSONObj(movieObj, "Title") + " is taken");


        return movieImdbId;

    }


}
