package ru.bulgakov.pages.yandexPage;

import com.codeborne.selenide.SelenideElement;
import ru.bulgakov.pages.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexSearchResultsPage extends BasePage {
    private static final Duration BANNER_TIMEOUT = Duration.ofSeconds(3);
    private final SelenideElement defaultBrowserBanner = $("[aria-label='Нет, спасибо']"),
            distributionBannerClose = $(".DistributionButtonClose");
    public YandexSearchResultsPage closeDefaultBrowserBannerIfAppeared() {
        if (defaultBrowserBanner.is(visible, BANNER_TIMEOUT)) {
            defaultBrowserBanner.click();
        }
        return this;
    }
    public YandexSearchResultsPage closeDistributionBannerIfAppeared() {
        if (distributionBannerClose.is(visible, BANNER_TIMEOUT)) {
            distributionBannerClose.click(usingJavaScript());
        }
        return this;
    }
    public YandexSearchResultsPage openLink(String webSiteName) {
        $$("a[href*='" + webSiteName + "']").filterBy(visible)
                .first()
                .click();
        return this;
    }
}