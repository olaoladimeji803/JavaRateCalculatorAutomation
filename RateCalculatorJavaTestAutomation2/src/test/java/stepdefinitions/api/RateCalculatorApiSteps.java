package stepdefinitions.api;

import DataModel.RateDataModel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.devtools.v127.fetch.model.AuthChallengeResponse;
import webServices.RateCalculatorServices;

import java.util.List;
import java.util.Map;

public class RateCalculatorApiSteps {

    private RateDataModel rateDataModel;
    RateDataModel.RateDataModelBuilder rateDataModelBuilder = RateDataModel.builder();

    private RateCalculatorServices rateCalculatorServices;
    Response response;

    public RateCalculatorApiSteps(RateCalculatorServices _rateCalculatorServices){
        this.rateCalculatorServices = _rateCalculatorServices;
    }
    @Given("that a user make a Get request to get rate")
    public void thatAUserMakeAGetRequestToGetRate() {
       response = rateCalculatorServices.getRate();
    }
    @And("i should get a {int} status code")
    public void iShouldGetAStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, response.statusCode());
    }
    @Then("i should be able to get a correct rate")
    public void iShouldBeAbleToGetACorrectRate(List<Map<String, String>> rateData) {
        String expectedFromCurrency = rateData.get(0).get("fromCurrency");
        String actualFromCurrency =  response.jsonPath().get("fromCurrency");
        Assert.assertEquals(expectedFromCurrency, actualFromCurrency);

        //String expectedToCurrency = rateData.get(0).get("toCurrency");
       // String actualToCurrency =  response.jsonPath().get("toCurrency");
       // Assert.assertEquals(expectedToCurrency, actualToCurrency);

        String expectedRate = rateData.get(0).get("rate");
        String actualRate =  response.jsonPath().get("rate").toString();
        Assert.assertEquals(expectedRate, actualRate);
    }

    @Given("that a user make a Post request to set rate")
    public void thatAUserMakeAPostRequestToSetRate(List<Map<String, String>> rateData) {
            rateDataModel = rateDataModelBuilder
                    .rate(Integer.parseInt(rateData.get(0).get("rate")))
                    .fromCurrency(rateData.get(0).get("fromCurrency"))
                    .toCurrency(rateData.get(0).get("toCurrency")).build();
        response = rateCalculatorServices.createNewRate(rateDataModel);
    }
    @Then("the response message should be {string}")
    public void theResponseMessageShouldBe(String successMsg) {
        Assert.assertEquals(response.jsonPath().get("message"), successMsg);
    }
}
