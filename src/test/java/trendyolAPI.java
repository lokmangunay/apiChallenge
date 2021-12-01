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

public class trendyolAPI {
    String apiKey="a5ce9e6b";
    String movieName="harry potter";
    @Test
    public void bySearch() {
        baseURI = "http://www.omdbapi.com/";
        Response response = RestAssured.get("?s="+movieName+"&apikey="+apiKey);

        String responseString = response.asString();
        ///  response.prettyPrint();

        JSONObject obj = new JSONObject(responseString);
        JSONArray arr = obj.getJSONArray("Search");
        JSONObject movieObj;
        int counter = 0;
        for (int i = 0; i < arr.length(); i++) {
            movieObj = arr.getJSONObject(i);
            String movieTitle = movieObj.getString("Title");

            if (movieTitle.equals("Harry Potter and the Sorcerer's Stone")) {
                System.out.println("-----------------------\n" + movieObj);

                break;

            } else {
                counter++;
            }

            //  Harry Potter and the Chamber of Secrets  Harry Potter and the Sorcerer's Stone
        }
             movieObj=arr.getJSONObject(counter);
            String movieImdbId=movieObj.getString("imdbID");
             System.out.println("*************************\n"
                                        +"imdbID of "+movieObj.getString("Title")+"  --->>  "+ movieImdbId);

             Response response1= RestAssured.get("?i="+movieImdbId+"&apikey="+apiKey);
             response1.prettyPrint();

             JSONObject movieDetailsObj=new JSONObject(response1.asString());
             String title=movieDetailsObj.getString("Title");
             String year=movieDetailsObj.getString("Year");
             String released=movieDetailsObj.getString("Released");

        System.out.println("Title:"+ title+
                            "\nYear: "+year+
                                "\nReleased"+ released);


        System.out.println("-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"+

                            "\nresponse body: "+response1.getBody()+
                            "\nStatus code: "+response1.getStatusCode()+
                                "\nStatus line"+response1.getStatusLine()+
                                    "\nTime"+response1.getTime());
    }


    // JSONObject obj = new JSONObject(responseString);


    // System.out.println(response.asString());



    public void getIdOf(String movieName) {

        String name = "Harry Potter and the Sorcerer's Stone";
        while (name != movieName)
            break;

    }

}