package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.id;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class ShouldBeJUnit5OnWikiPage {

    @Test
    void verifyJUnit5OnWikiPage(){
        open("https://github.com/selenide/selenide/wiki");
        $$(".internal").find(text("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5"));
    }
}
