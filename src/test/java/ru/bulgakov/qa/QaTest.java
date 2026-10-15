package ru.bulgakov.qa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bulgakov.pages.WelcomeMentorPage;
import ru.bulgakov.pages.WikipediaPage;
import static com.codeborne.selenide.Selenide.*;

public class QaTest {

    @Test
    @DisplayName("Проверить, что цена обучения - 47 000 рублей")
    @Tag("POSITIVE")
    void mentoringPriceShouldBe47000Test() {
        // Три разных предложения яндекса сделать поисковик по умолчанию одолело меня, я старался, но просто сократил код

        open("https://ivanbulgakovqa.ru/", WelcomeMentorPage.class)
                .clickOnPriceInHeader()
                .clickOnBuyMentorButton()
                .clickOnBuyMentorButtonInLightbox()
                .priceOfMentoring("₽ 47 000 ");
    }

    @Test
    @DisplayName("Проверить, что страница Римской империи открывается")
    @Tag("POSITIVE")
    void myFirstTest() {
        open("https://www.wikipedia.org/", WikipediaPage.class)
                .setValueInSearch("Рим")
                .clickOnElementInDropDown("Римская империя")
                .checkLoadingPage("Римская империя");
    }
}
