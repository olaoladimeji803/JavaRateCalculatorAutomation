package stepdefinitions.ui;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.WebDriverHelpers;


import java.util.concurrent.TimeUnit;

public class Hook extends WebDriverHelpers {

    WebDriverHelpers webDriverHelpers;

    public Hook(WebDriverHelpers _webDriverHelpers)
    {
        this.webDriverHelpers = _webDriverHelpers;
    }

    @Before("@web")
    public void initialisation(){
        webDriverHelpers. driver = WebDriverManager.chromedriver().create();
        webDriverHelpers.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriverHelpers.driver.manage().window().maximize();

    }

    @After("@web")
    public void shutDown(){

        webDriverHelpers.driver.quit();
    }
}
