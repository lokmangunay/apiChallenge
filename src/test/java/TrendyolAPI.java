import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.*;

import static com.trendyol.apitest.config.Constants.*;

public class TrendyolAPI extends BaseMethods {



    @Test
    public void bySearch() {

        String responseString = getMoviesAsString(MOVIE_NAME, API_KEY_LOKMAN);

        int indexOfMovie = getIndexOfMovieFromArray(responseString, FULL_MOVIE_NAME);
        String movieImdbId = getMovieImdbID(responseString, indexOfMovie);

        Response movieDetailsAsResponseAccordingToIMDBId = getMovieDetailsAsResponseAccordingToIMDBId(movieImdbId, API_KEY_LOKMAN);

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


        Assert.assertEquals(movieDetailsAsResponseAccordingToIMDBId.getStatusCode(), 200);
        Assert.assertEquals(year, "2002");
        Assert.assertEquals(title, FULL_MOVIE_NAME);

    }


}