package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultComponent {
    private final SelenideElement modalConsultationWindowHeader = $("#popuptitle_895353283"),
            consultationButtonName = $(".t396__elem.tn-elem.tn-elem__8952950831741948197344"),
            consultationWindowError = $(".t-form__errorbox-link"),
            phraseOfMainPage = $(".t396__elem.tn-elem.tn-elem__8995950251741763610174"),
            coachInfoWindow = $(".t396__elem.tn-elem.tn-elem__8951247671741932460803");

    public void ModalConsultationWindowHeaderValue(String value) {
        modalConsultationWindowHeader.shouldHave(text(value));
    }

    public void ModalConsultationWindowErrorValue(String value) {
        consultationWindowError.shouldHave(text(value));
    }

    public void ConsultationButtonValue(String value) {
        consultationButtonName.shouldHave(text(value));
    }


    public void checkPhraseIsVisible() {
        phraseOfMainPage.shouldBe(visible);
    }

    public void coachInfoWindowVisible() {
        coachInfoWindow.shouldBe(visible);
    }
}