package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LandingFormPage;

public class LandingTests extends TestBase {

    LandingFormPage landingFormPage = new LandingFormPage();


    @Test
    @DisplayName("На странице есть кнопка 'Получить консультацию'")
    void successfulGetConsultationButtonTest() {
        landingFormPage.checkConsultationButtonValue("Получить консультацию");
    }

    @Test
    @DisplayName("Пользователь может открыть модально окно 'Получить консультацию'")
    void successfulGetConsultationButtonPressTest() {

        landingFormPage.consultationClick().
                checkModalConsultationWindowHeaderValue("Получите бесплатную консультацию");
    }

    @Test
    @DisplayName("Пользователь может закрыть модально окно 'Получить консультацию'")
    void successfulGetConsultationWindowCloseTest() {

        landingFormPage.consultationClick()
                .consultationCloseClick()
                .checkMainPhraseIsVisible();
    }

    @Test
    @DisplayName("Пользователь не может отправить пустой запрос на консультацию")
    void successfulNoEmptyConsultationFormTest() {
        landingFormPage.consultationClick()
                .consultationSendButton()
                .checkModalConsultationWindowErrorValue("Пожалуйста, заполните все обязательные поля");
    }

    @Test
    @DisplayName("Пользователь может нажать 'Записаться'")
    void successfulSignUpButtonTest() {
        landingFormPage.signUpButtonClick()
                .checkInfoWindowVisible();
    }

}


