package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("EPC-4 Взаимодействие с блоком консультации")
@Story("STR-18 Консультация")
@Feature("Получение консультации")
public class ConsultationTests extends TestBase {

    @Test
    @Owner("ASchastlivtsev")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("На странице есть кнопка 'Получить консультацию'")
    void successfulGetConsultationButtonTest() {
        landingFormPage.openMain().
                checkConsultationButtonValue("Получить консультацию");
    }

    @Test
    @Owner("ASchastlivtsev")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Пользователь может открыть модально окно 'Получить консультацию'")
    void successfulGetConsultationButtonPressTest() {

        landingFormPage.openMain().
                consultationClick().
                checkModalConsultationWindowHeaderValue("Получите бесплатную консультацию");
    }

    @Test
    @Owner("ASchastlivtsev")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Пользователь может закрыть модально окно 'Получить консультацию'")
    void successfulGetConsultationWindowCloseTest() {

        landingFormPage.openMain().
                consultationClick()
                .consultationCloseClick()
                .checkMainPhraseIsVisible();
    }

    @Test
    @Owner("ASchastlivtsev")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Пользователь не может отправить пустой запрос на консультацию")
    void successfulNoEmptyConsultationFormTest() {
        landingFormPage.openMain().
                consultationClick()
                .consultationSendButton()
                .checkModalConsultationWindowErrorValue("Please fill out all required fields");
    }
}
