package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waithelper {

    WebDriver driver;
    WebDriverWait wait;

    public Waithelper(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(driver,10);
    }

    public void waitForPresenceOfElementedLocated(By locator)
    {

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }
}
