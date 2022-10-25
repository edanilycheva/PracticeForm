import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    @BeforeSuite
    static void BeforeSuite() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void PracticeFormTest() {

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Тестовый");
        $("#lastName").setValue("Тест");
        $("#userEmail").setValue("test@test.ru");
        $$("#genterWrapper .custom-control-inline").findBy(text("Male")).click();
        $("#userNumber").setValue("7958456456");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1999");
        $("[aria-label=\"Choose Friday, October 1st, 1999\"]").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $$(".custom-control-label").findBy(text("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("pic.png");
        $("#currentAddress").setValue("Тестовый адрес");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));


    }
}