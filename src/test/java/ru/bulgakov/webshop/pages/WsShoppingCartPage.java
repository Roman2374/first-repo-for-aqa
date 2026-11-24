package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WsShoppingCartPage {

    private final SelenideElement nameProduct = $("a.product-name");
    private final SelenideElement inputWithQuantityOfProduct = $("input.qty-input");
    private final SelenideElement finalPrice = $("span.product-subtotal");

    public WsShoppingCartPage checkAccordanceNameOfProduct(String expectedName) {
        nameProduct.shouldHave(text(expectedName));

        return this;
    }

    public WsShoppingCartPage checkAccordanceQuantityOfProduct(String expectedQuantity) {
        String itemQuantityInCart = inputWithQuantityOfProduct.getAttribute("value");
        assertEquals(expectedQuantity, itemQuantityInCart);

        return this;
    }

    public WsShoppingCartPage checkProductSubTotalPrice(String expectedPrice, String expectedQuantity, double totalPriceOfAllPCComponents) {
        finalPrice.shouldHave(text(String.valueOf((Float.parseFloat(expectedPrice) + totalPriceOfAllPCComponents) * Float.parseFloat(expectedQuantity))));

        return this;
    }
}
