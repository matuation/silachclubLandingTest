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

import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    private static final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {

        System.out.println("ENVIRONMENT: " + System.getProperty("env"));
        System.out.println("IS REMOTE: " + config.isRemote());

        if (config.isRemote()) {
            Configuration.remote = config.remoteUrl();
        }
        baseUrl = System.getProperty("baseUrl", "https://silachclub.ru/");
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.pageLoadStrategy = System.getProperty("pageLoadStrat", "eager");
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
        if (config.isRemote()) {
            System.out.println("DEBUG: Java Session ID: " + sessionId);
        }
        Attachments.screenshotAs("Скрин");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();

        closeWebDriver();
        try {
            Thread.sleep(7000); // 7 секунд — хватит даже для длинного видео
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            Attachments.addVideo(sessionId);

    }
}

