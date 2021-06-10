package page;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FillRegistrationForm {
    SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            currentAddress = $("#currentAddress");

    public void inputFirstName(String name) {
        firstName.setValue(name);
    }

    public void inputLastName(String name) {
        lastName.setValue(name);
    }

    public void inputEmail(String email) {
        userEmail.setValue(email);
    }


    public void chooseGender(String maleOrFemaleOrOther) {
        $("#genterWrapper").$(byText(maleOrFemaleOrOther)).click();
    }

    public void inputMobile(String mobile) {

        userNumber.setValue(mobile);
    }

    public void uploadFile(String filePathName) {

        $("#uploadPicture").uploadFile(new File("src/test/resources/" + filePathName));
    }

    public void currentAddress(String address) {

        currentAddress.setValue(address);
    }

    public void submit() {

        $("#submit").click();
    }

    public void chooseStateAndCity(String state, String city) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
    }

    public void chooseHobby(String sportsOrReadingOrMusic) {
        $("#hobbiesWrapper").$(byText(sportsOrReadingOrMusic)).click();
    }

    public void chooseSubject(String subject){
        $("#subjectsInput").val(subject);
        $(".subjects-auto-complete__menu-list").$(byText(subject)).click();
    }

}