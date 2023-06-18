package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomer;

import java.util.Properties;

public class BaseClass {
    WebDriver driver;
    LoginPage lp;
    AddCustomerPage cp;
    SearchCustomer sc;

    Properties prop;
public static Logger logger;

    public String generateRandomString()
    {

        return RandomStringUtils.randomAlphabetic(5);
    }
}
