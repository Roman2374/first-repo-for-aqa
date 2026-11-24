package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class WsDesktopPage {

    private static final String OWN_CHEAP_COMPUTER = "Build your own cheap computer";

    private final ElementsCollection collectionOfPC = $$("div.product-grid div");

    public WsOwnCheapComputerPage clickOnBuildOwnCheapComputer() {
        collectionOfPC.findBy(text(OWN_CHEAP_COMPUTER)).click();

        return new WsOwnCheapComputerPage();
    }

}
