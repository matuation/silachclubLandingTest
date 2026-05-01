package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LandingFormPage;

public class CoachTests extends TestBase {

    LandingFormPage landingFormPage = new LandingFormPage();


    @Test
    @DisplayName("Пользователь может перейти к блоку 'Тренеры'")
    void successfulCoachListOpenTest() {
        landingFormPage.openMain()
                .coachLinkClick()
                .checkCoachTitleValue("Тренерский состав");
    }

    @Test
    @DisplayName("Пользователь может нажать 'Записаться'")
    void successfulSignUpButtonTest() {
        landingFormPage.openMain().
                signUpButtonClick()
                .checkInfoWindowVisible();
    }

    @Test
    @DisplayName("Пользователь может закрыть окно записи")
    void successfulSignUpWindowCloseTest() {
        landingFormPage.openMain()
                .signUpButtonClick()
                .coachCloseClick()
                .checkCoachInfoWindowNotVisible();
    }

}


