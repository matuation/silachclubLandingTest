package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("EPC-3 Взаимодействие с блоком тренеров")
@Story("STR-18 Блок тренеров")
@Feature("Выбор тренера")
@Owner("ASchastlivtsev")
public class CoachTests extends TestBase {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Пользователь может перейти к блоку 'Тренеры'")
    void successfulCoachListOpenTest() {
        landingFormPage.openMain()
                .coachLinkClick()
                .checkCoachTitleValue("Тренерский состав");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Пользователь может нажать 'Записаться' у тренера")
    void successfulSignUpButtonTest() {
        landingFormPage.openMain().
                signUpButtonClick()
                .checkInfoWindowVisible();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Пользователь может закрыть окно записи")
    void successfulSignUpWindowCloseTest() {
        landingFormPage.openMain()
                .signUpButtonClick()
                .coachCloseClick()
                .checkCoachInfoWindowNotVisible();
    }

}


