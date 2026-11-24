package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsOwnCheapComputerPage {

    String itemQuantityResult;
    double totalPrice = 0.0;

    private final ElementsCollection collectionProcessorForPC = $$("dt").findBy(text("Processor")).sibling(0).$$("li input");
    private final ElementsCollection collectionRamForPC = $$("dt").findBy(text("RAM")).sibling(0).$$("li input");
    private final ElementsCollection collectionHDDForPC = $$("dt").findBy(text("HDD")).sibling(0).$$("li input");
    private final ElementsCollection collectionSoftwareForPC = $$("dt").findBy(text("Software")).sibling(0).$$("li input");
    private final SelenideElement addToCartButton = $("input.add-to-cart-button");
    private final SelenideElement barNotification = $("div.bar-notification.success");
    private final SelenideElement buttonShoppingCartInHeader = $("span.cart-qty");
    private final SelenideElement inputForSelectQuantityPCtoBuy = $("input.qty-input");
    private final SelenideElement linkForClickOnShoppingCart = $("a.ico-cart");
    private final SelenideElement inputWithPrice = $("[itemprop=price]");
    private final SelenideElement nameOfPC = $("[itemprop=name]");

    public WsOwnCheapComputerPage selectProcessorAndGetPrice(int index) {
        collectionProcessorForPC.get(index).click();

        String priceProcessor = collectionProcessorForPC.get(index).sibling(0).getText();

        if (priceProcessor.contains("+")) {
            String[] parts = priceProcessor.split("\\+");

            totalPrice += Double.parseDouble(parts[1].replaceAll("[^0-9.]", ""));
        }

        return this;
    }

    public WsOwnCheapComputerPage selectRamAndGetPrice(int index) {
        collectionRamForPC.get(index).click();

        String priceRam = collectionRamForPC.get(index).sibling(0).getText();

        if (priceRam.contains("+")) {
            String[] parts = priceRam.split("\\+");

            totalPrice += Double.parseDouble(parts[1].replaceAll("[^0-9.]", ""));
        }

        return this;
    }

    public WsOwnCheapComputerPage selectHDDAndGetPrice(int index) {
        collectionHDDForPC.get(index).click();

        String priceHDD = collectionHDDForPC.get(index).sibling(0).getText();

        if (priceHDD.contains("+")) {
            String[] parts = priceHDD.split("\\+");

            totalPrice += Double.parseDouble(parts[1].replaceAll("[^0-9.]", ""));
        }

        return this;
    }

    public WsOwnCheapComputerPage selectSoftwareAndGetPrice(int index) {
        collectionSoftwareForPC.get(index).click();

        String priceSoftware = collectionSoftwareForPC.get(index).sibling(0).getText();

        if (priceSoftware.contains("+")) {
            String[] parts = priceSoftware.split("\\+");

            totalPrice += Double.parseDouble(parts[1].replaceAll("[^0-9.]", ""));
        }

        return this;
    }

    public WsOwnCheapComputerPage setQuantityComputersToBuy(int itemQuantity) {
        inputForSelectQuantityPCtoBuy.setValue(String.valueOf(itemQuantity));

        itemQuantityResult = String.valueOf(itemQuantity);

        return this;
    }

    public WsOwnCheapComputerPage clickOnAddToCart() {
        addToCartButton.click();

        return this;
    }

    public WsOwnCheapComputerPage barNotificationIsVisible() {
        barNotification.shouldBe(visible);

        return this;
    }

    public String getPriceOfProduct() {

        return inputWithPrice.getText();
    }

    public String getNameOfProduct() {

        return nameOfPC.getText();
    }

    public String getQuantityOfProduct() {

        return inputForSelectQuantityPCtoBuy.getAttribute("value");
    }

    // по хорошему наверное методы ниже вынести в WsWelcomePage, как общие методы хедера, но как это реализовать я пока не придумал
    public WsOwnCheapComputerPage checkItemQuantityInHeader() {
        buttonShoppingCartInHeader.shouldHave(text("(" + itemQuantityResult + ")"));

        return this;
    }

    public WsShoppingCartPage clickOnShoppingCartInHeader() {
        linkForClickOnShoppingCart.click();

        return new WsShoppingCartPage();
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
