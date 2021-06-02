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


    @Test
    void successfulSubmitRegistrationFormTest(){
        StudentModel student = new StudentModel(
                "Jone","Pane","jone@mail.ru",
                "Male","1234567890", "Sports", "Haryana",
                "Karnal","english","RnD");


        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(student.firstName);
        $("#lastName").setValue(student.lastName);
        $("#userEmail").setValue(student.email);
        $(byText(student.gendermale)).click();
        $("#userNumber").setValue(student.mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(2);
        $(".react-datepicker__year-select").selectOption("2000");
        $("[aria-label='Choose Tuesday, March 28th, 2000']").click();
        $("#subjectsInput").setValue("e");
        $("#react-select-2-option-0").click();
        $(byText(student.hobbies)).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/load.txt"));
        $("#currentAddress").setValue(student.currentaddress);
        $("#state").click();
        $(byText(student.state)).click();
        $("#city").click();
        $(byText(student.city)).click();
        $("#submit").click();


        $(".table-responsive").shouldHave(text(student.firstName), text(student.lastName), text(student.email),
                text(student.gendermale), text(student.mobile), text("28 March,2000"), text(student.subjects), text(student.hobbies),
                text("load.txt"), text(student.currentaddress), text(student.state), text(student.city));
    }


}
