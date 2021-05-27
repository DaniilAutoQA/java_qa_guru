package demoqa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {
    @BeforeAll
    static void setup(){
        Configuration.startMaximized = true;
    }

    /*void setDateByName(String name, String date){
        executeJavaScript(
                String.format("$('[name=\"%s\"]').val('%s')", name, date));
    }*/

    @Test
    void successfulSubmitRegistrationFormTest(){
        String firstName = "Jone";
        String lastName = "Pane";
        String email = "jone@mail.ru";
        String gendermale = "Male";
        String mobile = "1234567890";
        String dateOfbirth = "28 March 2000";
        String hobbies = "Sports";
        String state = "Haryana";
        String city = "Karnal";
        String subjects = "english";
        String currentaddress = "RnD";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $(byText(gendermale)).click();
        $(byText(hobbies)).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(2);
        $(".react-datepicker__year-select").selectOption("2000");
        $("[aria-label='Choose Tuesday, March 28th, 2000']").click();
        $("[id=userNumber]").setValue(mobile);
        $("#subjectsInput").setValue(subjects).pressEnter();
        //actions().moveToElement($("#subjectsInput")).sendKeys("e").moveToElement($("#react-select-2-option-0")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/load.txt"));
        $("[id=currentAddress]").setValue(currentaddress);
        $("[id=state]").click();
        $(byText(state)).click();
        $("[id=city]").click();
        $(byText(city)).click();
        $("[id=submit]").click();


        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(email),
                text(gendermale), text(mobile), text("28 March,2000"), text(subjects), text(hobbies),
                text("load.txt"), text(currentaddress), text(state), text(city));
    }


}
