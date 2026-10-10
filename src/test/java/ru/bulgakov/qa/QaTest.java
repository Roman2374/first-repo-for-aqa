package ru.bulgakov.qa;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class QaTest {

    @Test
    void mentoringPriceShouldBe47000Test() {
        /*
        Тест-кейс - проверить, что предоплата по обучению - 47 000 рублей
         1. Открыть сайт (bulgakov qa)
         2. Нажать на кнопку "Стоимость"
         3. Нажать на кнопку "Хочу вкатиться в QA"
         3. Нажать на кнопку "Бегу оплачивать"
         4. Проверить, что к оплате 47 000 рублей
         */

        // Три разных предложения яндекса сделать поисковик по умолчанию одолело меня, я старался, но просто сократил код

        open("https://ivanbulgakovqa.ru/");
        $$(".t-menu__list li").get(4).click();
        $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a").click();
        $(byText("Бегу оплачивать")).click();

        switchTo().window(1);
        $("div.css-nzt0y9 h3").shouldHave(text("₽ 47 000 "));

    }

    @Test
    void myFirstTest() {

        // Шаг 1: Открываем Википедию
        open("https://www.wikipedia.org/");

        // Шаг 2: Вводим значение "Рим" в поиск

        $("#searchInput").setValue("Рим");

        // Шаг 3: В выпадающем списке нажимаем на "Римская империя"

        $$(".suggestions-dropdown").findBy(text("Римская империя")).click();

        // Шаг 4: Проверяем, что страница загрузилась по заголовку (хотел перехватить рест с ответом, который содержит инфу о Римской империя, но наверное пока это избыточно)

        $("#firstHeading").shouldHave(text("Римская империя"));
    }


}
