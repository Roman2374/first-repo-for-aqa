package ru.bulgakov.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WikipediaPage {

    public WikipediaPage setValueInSearch(String searchValue) {
        $("#searchInput").setValue(searchValue);

        return this;
    }

    public WikipediaPage clickOnElementInDropDown(String elementInDropDown) {
        $$(".suggestions-dropdown").findBy(text(elementInDropDown)).click();

        return this;
    }

    public WikipediaPage checkLoadingPage(String firtsHeading) {
        $("#firstHeading").shouldHave(text(firtsHeading));

        return this;
    }
}


