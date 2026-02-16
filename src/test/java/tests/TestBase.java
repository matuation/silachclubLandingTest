package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    public static String browser = System.getProperty("browser", "chrome");
    public static String remoteBaseUsername = System.getProperty("remoteBaseUsername");
    public static String remoteBasePass = System.getProperty("remoteBasePass");
    public static String remoteBaseUrl = System.getProperty("remoteBaseUrl");

    @BeforeAll
    static void beforeAll() {
        if (remoteBaseUrl != null) {
            Configuration.remote = "https://" + remoteBaseUsername + ":" + remoteBasePass + "@" + remoteBaseUrl;
        }
        baseUrl = System.getProperty("baseUrl", "https://silachclub.ru/");
        Configuration.browser = browser;
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.pageLoadStrategy = System.getProperty("pageLoadStrat", "eager");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true));
        Configuration.browserCapabilities = capabilities;


    }

    @BeforeEach
    void openMain() {
        open(baseUrl);
    }

    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Скрин");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
        closeWebDriver();
    }
}

