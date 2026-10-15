package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {
    private final SelenideElement priceOfMentor = $("div.css-nzt0y9 h3");

    public PaymentPage priceOfMentoring(String price) {
        priceOfMentor.shouldHave(text(price));

        return this;
    }

}
