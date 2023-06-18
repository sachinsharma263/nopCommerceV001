package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Waithelper;

public class AddCustomerPage {
    WebDriver driver;
    Waithelper waitHelper;
    By lnkCustomersMenu=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
    By lnkCustomerMenuItem=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a");
    By btnAddNew=By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
    By txtEmail=By.id("Email");
    By txtPwd=By.id("Password");

    By firstName=By.id("FirstName");

    By saveButton=By.name("save");


    public AddCustomerPage(WebDriver driver)
    {
        this.driver=driver;
        waitHelper=new Waithelper(driver);
    }
    public void clickOnCustomerMenu()
    {
        driver.findElement(lnkCustomersMenu).click();
    }
    public void clickOnCustomerMenuItem()
    {
        waitHelper.waitForPresenceOfElementedLocated(lnkCustomerMenuItem);
        driver.findElement(lnkCustomerMenuItem).click();
    }
    public void clickOnAddNew()
    {

        driver.findElement(btnAddNew).click();
    }
    public void setEMail(String email)
    {

        driver.findElement(txtEmail).sendKeys(email);
    }
    public void setTxtPwd(String pass)
    {
        driver.findElement(txtPwd).sendKeys(pass);
    }
    public void clickOnSave()
    {
        driver.findElement(saveButton).click();
    }
    public  boolean confirmationMsg(String msg)
    {
        return driver.getPageSource().contains(msg);
    }

}
