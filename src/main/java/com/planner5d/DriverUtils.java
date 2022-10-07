package com.planner5d;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Collections;

public class DriverUtils {

    public static void runChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--verbose");
        options.addArguments("-no-sandbox");
        options.addArguments("--whitelisted-ips");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920x1080");
        options.addArguments("--ignore-certificate-errors");
        options.setExperimentalOption(
                "excludeSwitches", Collections.singletonList("enable-automation"));
        WebDriverRunner.setWebDriver(new ChromeDriver(options));
    }

    public static void tearDownBrowser() {
        WebDriverRunner.closeWebDriver();
    }

    public static void browserConfiguration() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}