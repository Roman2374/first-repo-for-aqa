package ru.bulgakov.pages.wikiPage;

import com.codeborne.selenide.SelenideElement;
import ru.bulgakov.pages.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WikipediaArticlePage extends BasePage {
    private final SelenideElement firstHeading = $("#firstHeading");

    public WikipediaArticlePage checkTitle(String expectedTitle) {
        firstHeading.shouldHave(text(expectedTitle));

        return this;
    }
}
