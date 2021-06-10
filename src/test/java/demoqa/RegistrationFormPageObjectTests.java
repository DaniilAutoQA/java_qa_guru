package demoqa;

import com.github.javafaker.Faker;
import components.CalendarElement;
import model.StudentModel;
import org.junit.jupiter.api.Test;
import page.FillRegistrationForm;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static components.CalendarElement.calendarComponent;

public class RegistrationFormPageObjectTests extends TestBase {

    Faker faker = new Faker();
    FillRegistrationForm registration = new FillRegistrationForm();
    CalendarElement calendar = new CalendarElement("1", "March", "2000");
    StudentModel student = new StudentModel(
            faker.name().firstName(),
            faker.name().lastName(),
            faker.internet().emailAddress(),
            "Male",
            faker.phoneNumber().subscriberNumber(10),
            "Sports",
            "Haryana","Karnal",
            "English",
            faker.address().fullAddress(),
            "load.txt");


    @Test
    void fillFormTest(){
        open("https://demoqa.com/automation-practice-form");
        registration.inputFirstName(student.getFirstName());
        registration.inputLastName(student.getLastName());
        registration.inputEmail(student.getEmail());
        registration.chooseGender(student.getGender());
        registration.inputMobile(student.getMobile());
        registration.uploadFile(student.getFileName());
        registration.currentAddress(student.getCurrentAddress());
        calendarComponent(calendar.getDay(),calendar.getMonth(),calendar.getYear());
        registration.chooseStateAndCity(student.getState(), student.getCity());
        registration.chooseHobby(student.getHobbies());
        registration.chooseSubject(student.getSubjects());

        registration.submit();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()= 'Student Name']").parent().shouldHave(text(student.getFirstName() + " " + student.getLastName()));
        $x("//td[text()='Student Email']").parent().shouldHave(text(student.getEmail()));
        $x("//td[text()='Gender']").parent().shouldHave(text(student.getGender()));
        $x("//td[text()='Mobile']").parent().shouldHave(text(student.getMobile()));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(calendar.getDay() + " " + calendar.getMonth() + "," + calendar.getYear()));
        $x("//td[text()='Subjects']").parent().shouldHave(text(student.getSubjects()));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(student.getHobbies()));
        $x("//td[text()='Picture']").parent().shouldHave(text(student.getFileName()));
        $x("//td[text()='Address']").parent().shouldHave(text(student.getCurrentAddress()));
        $x("//td[text()='State and City']").parent().shouldHave(text(student.getState() + " " + student.getCity()));

    }
}
