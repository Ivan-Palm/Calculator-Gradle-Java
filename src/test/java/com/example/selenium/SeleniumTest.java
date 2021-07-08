package com.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.example.selenium.SeleniumHelper.waitPageToLoad;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SeleniumTest {

    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get("http://www.google.it/");
        waitPageToLoad(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void sampleTest() {
        assertEquals("https://www.google.it/?gws_rd=ssl", driver.getCurrentUrl());
    }

}
