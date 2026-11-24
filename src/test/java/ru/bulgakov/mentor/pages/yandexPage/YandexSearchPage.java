package ru.bulgakov.mentor.pages.yandexPage;

import com.codeborne.selenide.SelenideElement;
import ru.bulgakov.mentor.pages.BasePage;

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
