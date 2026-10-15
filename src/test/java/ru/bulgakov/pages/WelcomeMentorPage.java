package ru.bulgakov.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WelcomeMentorPage {
    private final ElementsCollection navButtonsInHeader = $$(".t-menu__list li");
    private final SelenideElement buyMentorButton = $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a");
    private final SelenideElement buyMentorButtonInLightbox = $(byText("Бегу оплачивать"));

    public WelcomeMentorPage clickOnPriceInHeader() {
        navButtonsInHeader.get(4).click();

        return this;
    }

    public WelcomeMentorPage clickOnBuyMentorButton() {
        buyMentorButton.click();

        return this;
    }

    public PaymentPage clickOnBuyMentorButtonInLightbox() {
        buyMentorButtonInLightbox.click();
        sleep(2000);
        switchTo().window(1);

        return new PaymentPage();
    }

}
