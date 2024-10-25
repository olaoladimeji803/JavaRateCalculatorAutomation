package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiHelpers {
    private static Gson gson;

    static {

        RestAssured.baseURI = "https://rate-calculator-1-0.onrender.com";
    }


    public static RequestSpecification givenConfig(){

        RestAssured.useRelaxedHTTPSValidation();
        return given().header("Accept-Language", "en").header("Content-Type", "application/json");
    }

    public static Gson gson(GsonBuilder gsonBuilder){

        gson = gsonBuilder.create();

        return gson;
    }

    public static Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        return gson;
    }

}




