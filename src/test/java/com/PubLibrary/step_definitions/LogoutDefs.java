package com.PubLibrary.step_definitions;

import com.PubLibrary.pages.DashboardPage;
import com.PubLibrary.pages.LoginPage;
import com.PubLibrary.utilities.BrowserUtils;
import com.PubLibrary.utilities.ConfigurationReader;
import com.PubLibrary.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutDefs{
    @Given("that im logged in as a user")
    public void that_im_logged_in_as_a_user() throws InterruptedException {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new LoginPage().signInAsStudent();
        //BrowserUtils.waitForPageToLoad(5);
        Thread.sleep(5000);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Library",actualTitle);
    }

    @When("the user clicks the username on top right corner of main page")
    public void the_user_clicks_the_username_on_top_right_corner_of_main_page() {
        new DashboardPage().usernameButton.click();
    }

    @When("the user clicks on Logout button on dropdown list")
    public void the_user_clicks_on_Logout_button_on_dropdown_list() {
        new DashboardPage().logoutButton.click();
    }

    @Then("the user should land on the login page")
    public void the_user_should_land_on_the_login_page() {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Login - Library",actualTitle);
    }
}