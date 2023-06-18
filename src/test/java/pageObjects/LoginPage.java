package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By emailId= By.id("Email");
    By password=By.id("Password");
    By loginBtn=By.xpath("//button[@type='submit']");
    
    By logout=By.linkText("Logout");

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void setEmail(String email) {

        driver.findElement(emailId).clear();
        driver.findElement(emailId).sendKeys(email);
    }

    public void setPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLogin()
    {
        driver.findElement(loginBtn).click();
    }

    public void logout() {
        driver.findElement(logout).click();
    }
}
