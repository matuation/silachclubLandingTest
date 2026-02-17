package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LandingFormPage {
    private final SelenideElement consultation = $("[class='tn-atom'][href='#popup:myform']"),
            consultationCloseButton = $(".t-popup__close-wrapper.t-popup__block-close-button"),
            consultationSendButton = $(".t-submit.t-btnflex.t-btnflex_type_submit.t-btnflex_md"),
            signUpButton = $("[class='tn-atom'][href='#open']");

    CheckResultComponent checkResultComponent = new CheckResultComponent();

    @Step("Открыть Главую страницу")
    public LandingFormPage openMain() {
        open(baseUrl);

        return this;
    }

    @Step("Кликнуть по кнопке 'Получить консультацию'")
    public LandingFormPage consultationClick() {
        consultation.click(ClickOptions.usingJavaScript());

        return this;
    }

    @Step("Кликнуть по кнопке 'Отправить'")
    public LandingFormPage consultationSendButton() {
        consultationSendButton.click(ClickOptions.usingJavaScript());

        return this;
    }

    @Step("Закрыть модальное окно 'Получить консультацию'")
    public LandingFormPage consultationCloseClick() {
        consultationCloseButton.click(ClickOptions.usingJavaScript());

        return this;
    }

    @Step("ЗКликнуть по кнопке 'Записаться'")
    public LandingFormPage signUpButtonClick() {
        signUpButton.scrollTo().click(ClickOptions.usingJavaScript());

        return this;
    }

    @Step("Проверить, что название кнопки 'Получить консультацию' содержит ожидаемое {value}")
    public LandingFormPage checkConsultationButtonValue(String value) {
        checkResultComponent.ConsultationButtonValue(value);

        return this;
    }

    @Step("Проверить, что заголовок формы 'Получить консультацию' содержит ожидаемое {value}")
    public LandingFormPage checkModalConsultationWindowHeaderValue(String value) {
        checkResultComponent.ModalConsultationWindowHeaderValue(value);

        return this;
    }

    @Step("Проверить, что текст ошибки формы 'Получить консультацию' содержит ожидаемое {value}")
    public LandingFormPage checkModalConsultationWindowErrorValue(String value) {
        checkResultComponent.ModalConsultationWindowErrorValue(value);

        return this;
    }

    @Step("Проверить, что фраза на главной странице видима")
    public LandingFormPage checkMainPhraseIsVisible() {
        checkResultComponent.checkPhraseIsVisible();

        return this;
    }

    @Step("Проверить, что отобразилось окно с информацией о Тренере")
    public LandingFormPage checkInfoWindowVisible() {
        checkResultComponent.coachInfoWindowVisible();

        return this;
    }


}



