package com.sauce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage  {

    public static WebDriver driver;

    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    /** Purpose for methods : Reduces code duplication and increases readability **/
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected void setText(By locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator){
        find(locator).click();
    }





}
