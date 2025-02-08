package com.sauce.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {


    /** Web Elements **/
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By loginErrorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");


    /** Methods **/

    public void setUsernameField (String username){
        setText(usernameField, username);
    }

    public void setPasswordField ( String password){
        setText(passwordField, password);
    }

    public ProductsPage clickOnLoginButton (){
        click(loginButton);
        return new ProductsPage();
    }

    public ProductsPage logIntoApplication(String username, String password){
        setUsernameField(username);
        setPasswordField(password);
        return clickOnLoginButton();
    }

    public String getErrorMessage (){
        return find(loginErrorMessage).getText();
    }























}
