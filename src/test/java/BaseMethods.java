import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

import java.util.logging.Logger;

import org.json.*;

import static io.restassured.RestAssured.baseURI;

public class BaseMethods {
    final static Logger logger = Logger.getLogger(String.valueOf(BaseMethods.class)); //logger object

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

    public String getKeyValueFromJSONObj(JSONObject jsonObject, String keyValue) {
        return jsonObject.getString(keyValue);

    }

    public int getIndexOfMovieFromArray(String response, String nameOfMovie) {
        JSONObject obj = new JSONObject(response);
        JSONArray arr = obj.getJSONArray("Search");
        JSONObject movieObj;
        int counter = 0;
        for (int i = 0; i < arr.length(); i++) {
            movieObj = arr.getJSONObject(i);
            String movieTitle = getKeyValueFromJSONObj(movieObj, "Title");
            if (movieTitle.equals(nameOfMovie)) {
                logger.info("\n---------MOVIE DETAILS--------\n"+
                        movieObj.toString(4) +"\n \n");  // the value of 4 makes the json object prettier
                break;
            } else {
                counter++;
            }
        }
        return counter;  //counter value gives the index of the desired movie in the array that is in response
    }

    public String getMovieImdbID(String response, int movieIndex) {
        JSONObject obj = new JSONObject(response);
        JSONArray arr = obj.getJSONArray("Search");
        JSONObject movieObj;
        movieObj = arr.getJSONObject(movieIndex);
        String movieImdbId = getKeyValueFromJSONObj(movieObj, "imdbID");

        return movieImdbId;

    }


}
