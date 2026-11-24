package ru.bulgakov.webshop.test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgakov.webshop.pages.WsOwnCheapComputerPage;
import ru.bulgakov.webshop.pages.WsWelcomePage;
import ru.bulgakov.webshop.steps.AuthSteps;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgakov.webshop.config.Config.*;
import static ru.bulgakov.webshop.pages.WsWelcomePage.WEB_TOPMENU_COMPUTERS;

public class CartTest {
    private final AuthSteps authSteps = new AuthSteps();

    @BeforeEach
    void beforeEach() {
        authSteps.registerNewUser();
    }

    @Test
    void addItemToCardTest() {
        WsOwnCheapComputerPage productPage =
                open(WEB_SHOP_URL, WsWelcomePage.class)
                .hoverOnTopMenuElements(WEB_TOPMENU_COMPUTERS)
                .clickOnDesktopInPopup()
                .clickOnBuildOwnCheapComputer()
                .selectProcessorAndGetPrice(0)
                .setQuantityComputersToBuy(2)
                .selectRamAndGetPrice(1)
                .selectHDDAndGetPrice(0);

        String expectedName = productPage.getNameOfProduct();
        String expectedPrice = productPage.getPriceOfProduct();
        String expectedQuantity = productPage.getQuantityOfProduct();
        double totalPriceOfAllPCComponents = productPage.getTotalPrice();

                productPage
                .clickOnAddToCart()
                .barNotificationIsVisible()
                .checkItemQuantityInHeader()
                .clickOnShoppingCartInHeader()
                .checkAccordanceNameOfProduct(expectedName)
                .checkAccordanceQuantityOfProduct(expectedQuantity)
                .checkProductSubTotalPrice(expectedPrice, expectedQuantity, totalPriceOfAllPCComponents);
    }

    // т.к. тут большое потенциальное покрытие из-за вариций выбора всех комплектующих, то можно наспамить еще кучу тестов

    @AfterEach
    void clearBrowser() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
