package stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class steps extends  BaseClass {

    @Before // before hook concept from cucumber, it will execute once at class loaded before other methods execute and set up all confirmation will be loaded
    public void setUp() throws IOException {

        logger= Logger.getLogger("nopcommerce");
        PropertyConfigurator.configure("Log4j.properties");

        FileInputStream fis=new FileInputStream("./config.properties");
        prop=new Properties();
        prop.load(fis);

        String browserName=prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome"))
        {
            // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxpath"));
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver",prop.getProperty("iepath"));
            driver=new EdgeDriver();
        }
        else{
            System.out.println(browserName+" not found");
            System.exit(0);
        }


        logger.info("*********launching browser**********");

    }

    @Given("USer launch google chrome")
    public void user_launch_google_chrome() {


        lp = new LoginPage(driver);

    }

    @When("USer opens url {string}")
    public void user_opens_url(String url) {
logger.info("*********opening url**********");
        driver.get(url);

    }

    @When("enter email as {string} and password as {string}")
    public void enter_email_as_and_password_as(String email, String pass) {
logger.info("*********providing login details**********");
        lp.setEmail(email);
        lp.setPassword(pass);
    }

    @When("click on login button")
    public void click_on_login_button() {
logger.info("*********login starting**********");
        lp.clickLogin();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String string) {
        String title = driver.getTitle();
        Assert.assertEquals(string, title);
logger.info("*********login passed**********");
    }

    @When("user click on logout link")
    public void user_click_on_logout_link() {

        lp.logout();
    }

    @Then("page title should be {string}")
    public void page_title_should_be2(String string) {
        String title = driver.getTitle();
        Assert.assertEquals(string, title);
    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }

    //customer.feature step definitions
    @Then("user can view Dashboard")
    public void user_can_view_Dashboard() throws InterruptedException {

        Thread.sleep(2000);
        cp = new AddCustomerPage(driver);
        String title = driver.getTitle();
        Assert.assertEquals("Dashboard / nopCommerce administration", title);
        System.out.println("completed user can view dashboard");

    }

    @When("user click on customer menu")
    public void user_click_on_customer_menu() {

        cp.clickOnCustomerMenu();
    }

    @When("click on customer menue item")
    public void click_on_customer_menue_item() {

        cp.clickOnCustomerMenuItem();
    }

    @When("click on add new button")
    public void click_on_add_new_button() {

        cp.clickOnAddNew();

    }

    @Then("user can view customer add page")
    public void user_can_view_customer_add_page() {
    }

    @When("customer add customer info")
    public void customer_add_customer_info() {
        cp.setEMail(generateRandomString()+"@gmail.com");
        cp.setTxtPwd("b@gmail.com");
    }

    @When("click on save button")
    public void click_on_save_button() {
        cp.clickOnSave();
    }

    @Then("user can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {
        Assert.assertTrue(cp.confirmationMsg(msg));
    }

    @Then("close the browser")
    public void close_the_browser() {
        driver.quit();
    }

    //customer search
    @When("enter customer email")
    public void enter_customer_email() {
sc=new SearchCustomer(driver);
sc.setEmail("bb@gmail.com");
    }

    @When("click on search button")
    public void click_on_search_button() {
sc.searchClick();
    }

    @Then("User should found email in search table")
    public void user_should_found_email_in_search_table() {

    }
}
