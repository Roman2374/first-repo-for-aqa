package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsLoginPage {
    private final SelenideElement pageTitle = $("div.page-title h1");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement rememberMeInput = $("input#RememberMe");
    private final SelenideElement submitLoginInput = $("input.login-button");
    private final ElementsCollection headerLinks = $$("div.header-links ul li a");

    public WsLoginPage verifyLoginOpened() {
        pageTitle.shouldHave(text("Welcome, Please Sign In!"));

        return this;
    }

    public WsLoginPage enterEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public WsLoginPage enterPassword(String password) {
        passwordInput.setValue(password);

        return this;
    }

    public WsLoginPage clickOnRememberMe() {
        rememberMeInput.click();

        return this;
    }

    public WsLoginPage submitLogin() {
        submitLoginInput.click();

        return this;
    }

    public WsLoginPage checkUserLoggedIn(String email) {
        headerLinks.get(0).shouldHave(text(email));

        return this;
    }
}
