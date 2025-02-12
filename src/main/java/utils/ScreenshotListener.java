package utils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

public class ScreenshotListener implements ITestListener {

    WebDriver driver = new ChromeDriver();

    @Override
    public void onTestFailure(ITestResult result) {
        // Capture screenshot when test fails
        ScreenshotUtil.captureScreenshot(driver, "Failed_" + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Capture screenshot when test passes
        ScreenshotUtil.captureScreenshot(driver, "Passed_" + result.getName());
    }




}
