package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.LandingFormPage;

import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    private static final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    LandingFormPage landingFormPage = new LandingFormPage();

    @BeforeAll
    static void beforeAll() {
        if (config.isRemote()) {
            Configuration.remote = config.remoteUrl();
        }
        baseUrl = System.getProperty("baseUrl", "https://silachclub.ru/");
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();
        Configuration.pageLoadStrategy = config.pageLoadStrategy();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true));
        capabilities.setCapability("goog:loggingPrefs", Map.of("browser", "ALL"));
        Configuration.browserCapabilities = capabilities;

    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        Attachments.screenshotAs("Скрин");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        closeWebDriver();
        Attachments.addVideo(sessionId);

    }
}

