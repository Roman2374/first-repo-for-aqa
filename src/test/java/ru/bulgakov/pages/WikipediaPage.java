package ru.bulgakov.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WikipediaPage {
    private final SelenideElement searchInput = $("#searchInput");
    private final ElementsCollection dropdown = $$(".suggestions-dropdown");
    private final SelenideElement firstHeading = $("#firstHeading");

    public WikipediaPage setValueInSearch(String searchValue) {
        searchInput.setValue(searchValue);

        return this;
    }

    public WikipediaPage clickOnElementInDropDown(String elementInDropDown) {
        dropdown.findBy(text(elementInDropDown)).click();

        return this;
    }

    public WikipediaPage checkLoadingPage(String firtsHeading) {
        firstHeading.shouldHave(text(firtsHeading));

        return this;
    }
}


