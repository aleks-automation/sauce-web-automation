package com.sauce.tests;

import com.sauce.basetest.BaseTest;
import com.sauce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPageTests extends BaseTest {

    @Test // Login Fail Test
    public void testLoginErrorMessage(){

        loginPage.setUsernameField("standard_user");
        log.info("Correct username is entered");
        loginPage.setPasswordField("wrongPassword");
        log.info("incorrect password is entered");
        loginPage.clickOnLoginButton();
        log.info("Login Button Clicked");
        sleep(2000);
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = loginPage.errorMessage;
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        log.info("Error message is displayed and correct");

    }


    @Test // Login Successful
    public void testLoginSuccess(){
        var productPage = loginPage.logIntoApplication("standard_user","secret_sauce");

        log.info("Username is entered");
        log.info("Password is entered");
        log.info("Login button is clicked");

        //Ensuring Login was successful
        Assert.assertNotNull(productPage,"Login failed: Product page not loaded!");

        // Verifying product page is displayed correctly
        Assert.assertTrue(productPage.isProductHeaderDisplayed(), "Test failed: Expected 'Products' header, but it was not displayed after login!");
        log.info("Test passed: Products header is displayed!");
    }
}
