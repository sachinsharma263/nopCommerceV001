Feature: Customers
  Background: Below are the common steps for each scenerio
    Given USer launch google chrome
    When USer opens url "https://admin-demo.nopcommerce.com/login"
    And enter email as "admin@yourstore.com" and password as "admin"
    And click on login button
    Then user can view Dashboard

    @smoke
  Scenario: Add a new Customer
    When user click on customer menu
    And click on customer menue item
    And click on add new button
    Then user can view customer add page
    When customer add customer info
    And click on save button
    Then user can view confirmation message "The new customer has been added successfully."
    And close the browser


      @regression
    Scenario: search customer by EMailID
      When user click on customer menu
      And click on customer menue item
      And enter customer email
      When click on search button
      Then User should found email in search table
      And close browser


















