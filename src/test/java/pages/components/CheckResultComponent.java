package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CheckResultComponent {
    private final SelenideElement modalConsultationWindowHeader = $("#popuptitle_895353283"),
            consultationButtonName = $(".t396__elem.tn-elem.tn-elem__8952950831741948197344"),
            consultationWindowError = $(".t-form__errorbox-link"),
            phraseOfMainPage = $(".t396__elem.tn-elem.tn-elem__8995950251741763610174"),
            coachInfoWindow = $(".t396__elem.tn-elem.tn-elem__8951247671741932460803"),
            coachAreaTitle = $x("//div[contains(@class, 'tn-atom') and text()='Тренерский состав']");


    public void modalConsultationWindowHeaderValue(String value) {
        modalConsultationWindowHeader.shouldHave(text(value));
    }

    public void modalConsultationWindowErrorValue(String value) {
        consultationWindowError.shouldHave(text(value));
    }

    public void consultationButtonValue(String value) {
        consultationButtonName.shouldHave(text(value));
    }

    public void checkPhraseIsVisible() {
        phraseOfMainPage.shouldBe(visible);
    }

    public void coachInfoWindowVisible() {
        coachInfoWindow.shouldBe(visible);
    }

    public void coachInfoWindowNotVisible() {
        coachInfoWindow.shouldNotBe(visible);
    }

    public void coachAreaTitleVisible(String value) {
        coachAreaTitle.shouldBe(visible).shouldHave(text(value));
    }
}