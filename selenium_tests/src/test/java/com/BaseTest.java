package com;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.website.BasePage;
import java.io.File;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    private String url = "https://minesweeperonline.com/#expert-200-night";
    //https://minesweeperonline.com/#beginner-200-night
    //https://minesweeperonline.com/#intermediate-200-night
    //https://minesweeperonline.com/#expert-200-night
    
    //https://globbertrot.github.io/alertpage/

    @BeforeClass
    public void setUp() {
        // Set the path to your .crx extension file
        String extensionPath = "E:\\Projects\\JavaScript\\MineSolverTest\\selenium_tests\\extensions\\iobegaggjcgmiggimmgocbbenihefagl.crx";

        // Configure ChromeOptions to add the extension
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(extensionPath));

        // Initialize ChromeDriver with options
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1500, 950));
        driver.manage().window().setPosition(new Point(700, 150));
        //driver.manage().window().maximize();
        driver.get(url);

        basePage = new BasePage();
        basePage.setDriver(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
