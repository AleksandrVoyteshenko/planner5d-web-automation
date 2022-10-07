package com.planner5d;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest {

    @BeforeClass
    public void initBrowser() {
        DriverUtils.runChromeBrowser();
        DriverUtils.browserConfiguration();
    }

    @AfterClass
    public void killBrowser() {
        DriverUtils.tearDownBrowser();
    }

    @Test
    public void navigateTest() {
        Selenide.open("https://planner5d.com/");

        assertThat(
                "Planner5d home page is not opened",
                Selenide.$x("//a[@href = 'https://planner5d.com/e']").is(Condition.visible)
        );
    }
}
