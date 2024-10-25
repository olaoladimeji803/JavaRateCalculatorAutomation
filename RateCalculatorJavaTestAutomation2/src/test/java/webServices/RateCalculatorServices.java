package webServices;

import DataModel.RateDataModel;
import io.restassured.response.Response;

import static utilities.ApiHelpers.givenConfig;
import static utilities.ApiHelpers.gson;

public class RateCalculatorServices {

    public static String rateApiPost = "/api/Rate/set-rate";
    public static String rateApiGet= "/api/Rate/get-rate";

    Response response;

    public Response createNewRate(RateDataModel rateDataModel){

        response = givenConfig().when().body(gson().toJson(rateDataModel))
                .post(rateApiPost);
        return response;
    }

    public Response getRate(){

        response = givenConfig().when()
                .get(rateApiGet);
        return response;
    }

    public Response updateRate(RateDataModel rateDataModel){
        response = givenConfig().when().body(gson().toJson(rateDataModel))
                .put(rateApiPost);
        return response;
    }

    public Response deleteRate(){

        response = givenConfig().when()
                .delete(rateApiPost);
        return response;
    }
}










