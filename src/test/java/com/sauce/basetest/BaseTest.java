package com.sauce.basetest;

import com.sauce.pages.BasePage;
import com.sauce.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

    // log.info command for displaying text in results and loggin info
    protected static final Logger log = LogManager.getLogger(BaseTest.class);

    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    private String url = "https://www.saucedemo.com/";


    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();
    }


    @AfterClass
    public void tearDown(){
     driver.quit();
    }

    // One-liner sleep method with exception handling
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
            log.info("Sleep for " + milliseconds + " milliseconds.");
        } catch (InterruptedException e) {
            log.error("Sleep interrupted!", e);
            Thread.currentThread().interrupt();
        }
    }

}
