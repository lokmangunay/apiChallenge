import io.restassured.response.Response;

import org.testng.annotations.Test;

import org.json.*;
import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.given;

public class trendyolAPI extends BaseMethods {

    String apiKeyLokman = "a5ce9e6b";
    String movieName = "lord of the rings";
    String specificMovieName = "The Lord of the Rings: The Two Towers";

    @Test
    public void bySearch() {

        String responseString = getMoviesAsString(movieName, apiKeyLokman);

        int indexOfMovie = getIndexOfMovieFromArray(responseString, specificMovieName);
        String movieImdbId = getMovieImdbID(responseString, indexOfMovie);

        Response movieDetailsAsResponseAccordingToIMDBId = getMovieDetailsAsResponseAccordingToIMDBId(movieImdbId, apiKeyLokman);

        JSONObject movieDetailsObj = new JSONObject(movieDetailsAsResponseAccordingToIMDBId.asString());
        String title = getKeyValueFromJSONObj(movieDetailsObj, "Title");
        String year = getKeyValueFromJSONObj(movieDetailsObj, "Year");
        String released = getKeyValueFromJSONObj(movieDetailsObj, "Released");


        logger.info("\n---------------KEY VALUES THAT EXTRACTED FROM RESPONSE--------------" +
                "\nImbdID: " + movieImdbId +
                "\nTitle:" + title +
                "\nYear: " + year +
                "\nReleased: " + released +
                "\n-------------------------------------\n \n" +
                "\n-*--*-*-*-*-*-RESPONSE RESULTS-*-*-*-*-*-*-*" +
                "\nStatus code: " + movieDetailsAsResponseAccordingToIMDBId.getStatusCode() +
                "\nStatus line: " + movieDetailsAsResponseAccordingToIMDBId.getStatusLine() +
                "\nTime: " + movieDetailsAsResponseAccordingToIMDBId.getTime());


        Assertion assertion = new Assertion();

        assertion.assertEquals(movieDetailsAsResponseAccordingToIMDBId.getStatusCode(), 200);
        assertion.assertEquals(year, "2002");
        assertion.assertEquals(title, specificMovieName);

    }


}