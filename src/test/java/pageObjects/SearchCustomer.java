package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchCustomer {
    WebDriver driver;
    By SearchEmail=By.id("SearchEmail");
    By searchcustomers=By.id("search-customers");

    public SearchCustomer(WebDriver driver)
    {
        this.driver=driver;
    }
    public void setEmail(String email)
    {
        driver.findElement(SearchEmail).sendKeys(email);
    }
    public void searchClick()
    {
        driver.findElement(searchcustomers).click();
    }
    
}
