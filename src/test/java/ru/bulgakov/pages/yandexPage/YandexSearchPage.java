package ru.bulgakov.pages.yandexPage;

import com.codeborne.selenide.SelenideElement;
import ru.bulgakov.pages.BasePage;
import ru.bulgakov.pages.wikiPage.WikipediaArticlePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class YandexSearchPage extends BasePage {
    private final SelenideElement url = $("#text");
    private final SelenideElement submitButton = $("[type=submit]");

    public YandexSearchResultsPage search(String searchValue) {
        url.setValue(searchValue);
        submitButton.click();

        return new YandexSearchResultsPage();
    }
}
