package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsWelcomePage {

    public static final String WEB_TOPMENU_COMPUTERS = "COMPUTERS";
    public static final String TOPMENU_POPUP_DESKTOP = "Desktop";

    private final SelenideElement registerButton = $("a.ico-register");
    private final SelenideElement loginButton = $("a.ico-login");
    private final ElementsCollection elementsOfTopMenu = $$("ul.top-menu li a");
    private final ElementsCollection elementsInPopupInTopMenu = $$("ul.top-menu li ul li");

    public WsRegistrationPage openRegistration () {
        registerButton.click();

        return new WsRegistrationPage();
    }

    public WsLoginPage openLogin () {
        loginButton.click();

        return new WsLoginPage();
    }

    public WsWelcomePage hoverOnTopMenuElements(String nameElementInTopMenu) {
        elementsOfTopMenu.findBy(text(nameElementInTopMenu)).hover();

        return this;
    }

    public WsDesktopPage clickOnDesktopInPopup() {
        elementsInPopupInTopMenu.findBy(text(TOPMENU_POPUP_DESKTOP)).click();

        return new WsDesktopPage();
    }
}
