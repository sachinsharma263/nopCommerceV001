Feature: Login
  @smoke
  Scenario: Successful Login with valid credentials
    Given USer launch google chrome
    When USer opens url "https://admin-demo.nopcommerce.com/login"
    And enter email as "admin@yourstore.com" and password as "admin"
    And click on login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When user click on logout link
    Then page title should be "Your store. Login"
    And close browser