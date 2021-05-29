package com.PubLibrary.step_definitions;
import com.PubLibrary.pages.DashboardPage;
import com.PubLibrary.pages.LibrarianBooksPage;
import com.PubLibrary.pages.LoginPage;
import com.PubLibrary.pages.UsersPage;
import com.PubLibrary.utilities.BrowserUtils;
import com.PubLibrary.utilities.ConfigurationReader;
import com.PubLibrary.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AddUserStepDefs {

    DashboardPage dashboardPage = new DashboardPage();
    UsersPage usersPage = new UsersPage();



    @When("the user enters librarian credentials")
    public void the_user_enters_librarian_credentials() {
        // Write code here that turns the phrase above into concrete actions
        LoginPage loginPage = new LoginPage();
        loginPage.signInAsLibrarian();
    }
    @When("the user navigates to the Users module")
    public void the_user_navigates_to_the_Users_module() {
        // Write code here that turns the phrase above into concrete actions
        BrowserUtils.waitForClickablility(dashboardPage.usersButton, 5);
        dashboardPage.usersButton.click();

    }
    @When("the user clicks on Add User button")
    public void the_user_clicks_on_Add_User_button() {
        // Write code here that turns the phrase above into concrete actions
        BrowserUtils.waitForClickablility(usersPage.addUser, 5);
        usersPage.addUser.click();
    }
    @When("fills the information needed on {string} {string} {string}")
    public void fills_the_information_needed_on(String username, String password, String email) {
        // Write code here that turns the phrase above into concrete actions
        BrowserUtils.waitForVisibility(usersPage.addUser, 5);
        usersPage.userName.sendKeys(username);
        usersPage.password.sendKeys(password);
        usersPage.email.sendKeys(email);


    }
    @When("the user clicks on Save Changes")
    public void the_user_clicks_on_Save_Changes() {
        // Write code here that turns the phrase above into concrete actions
        usersPage.submit.click();
    }
    @Then("the new user should show on the top of the list")
    public void the_new_user_should_show_on_the_top_of_the_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user enters the student credentials")
    public void the_user_enters_the_student_credentials() {
        // Write code here that turns the phrase above into concrete actions
        LoginPage loginPage = new LoginPage();
        loginPage.signInAsStudent();
    }
    @Then("the Users module should not show on the Modules tab")
    public void the_Users_module_should_not_show_on_the_Modules_tab() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertFalse(usersPage.addUser.isDisplayed());
    }


    @Then("the following data should be displayed")
    public void the_following_data_should_be_displayed(List<String> expectedUserData) {
        BrowserUtils.waitForVisibility(usersPage.addUser, 5);

        List <String> actualUserData = new ArrayList<>();
        actualUserData.add(usersPage.userName.getText());
        actualUserData.add(usersPage.password.getText());
        actualUserData.add(usersPage.email.getText());
        actualUserData.add(usersPage.status.getText());
        actualUserData.add(usersPage.startDate.getText());
        actualUserData.add(usersPage.endDate.getText());
        actualUserData.add(usersPage.address.getText());

        Assert.assertEquals(expectedUserData, actualUserData);


    }



}
