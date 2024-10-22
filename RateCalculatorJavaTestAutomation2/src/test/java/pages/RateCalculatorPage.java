package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import stepdefinitions.ui.RateCalculatorSteps;
import utilities.WebDriverHelpers;

import java.time.Duration;

public class RateCalculatorPage {
    private WebDriverHelpers webDriverHelpers;

    // create location
    private By currencyTextBox_GBP = By.xpath("//input[@class='from-currency p-1']");

    private By currencyTextBox_NGN = By.cssSelector(".to-currency.m-top-2.p-1");
    private By sendNowButton = By.xpath("//button[@class='send-now m-top-2']");

    private By selectBankOption = By.xpath("//select[@class='select-bank p-1']");
    private By accountNumberTextBox = By.xpath("//input[@class='account-number p-1 m-top-2']");
    private By sendRateButton = By.xpath("//button[@class='send m-top-2']");
    private By successText = By.xpath("//p[@class='success']");

    public RateCalculatorPage(WebDriverHelpers _webDriverHelpers)
    {
        this.webDriverHelpers = _webDriverHelpers;
    }


    // create functional method

    public void enterCurrencyGBPValue(String currencyValueGBP) throws InterruptedException {

        webDriverHelpers.driver.findElement(currencyTextBox_GBP).sendKeys(currencyValueGBP);
        webDriverHelpers.driver.findElement(currencyTextBox_GBP).clear();
        Thread.sleep(Duration.ofSeconds(5));
        webDriverHelpers.driver.findElement(currencyTextBox_GBP).sendKeys(currencyValueGBP);
    }
    public double enterCurrencyNGNValue() {
        String actualValue = webDriverHelpers.driver.findElement(currencyTextBox_NGN).getAttribute("value");
        return Double.parseDouble(actualValue);
    }

    public void ClickOnSendNowButton(){

        webDriverHelpers.driver.findElement(sendNowButton).click();
    }

    public void SelectBankOptions(String  bankName){
         //WebElement dropdownElement = webDriverHelpers.driver.findElement(selectBankOption);
         //Select dropdown = new Select(dropdownElement);
         //dropdown.selectByVisibleText(bankName);
         webDriverHelpers.SelectItemFromDropDown(selectBankOption, bankName);
    }

    public void EnterAccountNumber(String accountNumber){

        WebElement enterAcctNumber = webDriverHelpers.driver.findElement(accountNumberTextBox);
       // webDriverHelpers.driver.findElement(accountNumberTextBox).clear();
       // webDriverHelpers.driver.findElement(accountNumberTextBox).sendKeys(accountNumber);
        enterAcctNumber.clear();
        enterAcctNumber.sendKeys(accountNumber);
    }

    public void ClickOnSendButton(){

        webDriverHelpers.driver.findElement(sendRateButton).click();
    }

    public String getSuccessMessage(){

        return webDriverHelpers.driver.findElement(successText).getText();
    }

}
