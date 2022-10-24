import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    @BeforeSuite
    static void BeforeSuite(){
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void PracticeFormTest() throws InterruptedException {
        Configuration.holdBrowserOpen = true;
        open("https://demoqa.com/automation-practice-form");
        $("[id=\"firstName\"]").setValue("Тестовый");
        $("[id=\"lastName\"]").setValue("Тест");
        $("[id=\"userEmail\"]").setValue("test@test.ru");
        $("[class=\"custom-control custom-radio custom-control-inline\"]:nth-child(2)").click();
        $("[id=\"userNumber\"]").setValue("7958456456");
        $("[id=\"dateOfBirthInput\"]").click();
        $("[class=\"react-datepicker__month-select\"]").selectOption("October");
        $("[class=\"react-datepicker__year-select\"]").selectOption("1999");
        $("[aria-label=\"Choose Friday, October 1st, 1999\"]").click();
        $("[id=\"subjectsInput\"]").setValue("Math").pressEnter();
        $("[class=\"custom-control custom-checkbox custom-control-inline\"]:nth-child(1)").click();
        $("[class=\"custom-control custom-checkbox custom-control-inline\"]:nth-child(2)").click();
        $("[class=\"custom-control custom-checkbox custom-control-inline\"]:nth-child(3)").click();
        $("[id=\"uploadPicture\"]").uploadFromClasspath("pic.png");
        $("[id=\"currentAddress\"]").setValue("Тестовый адрес");
        $("[id=\"state\"]").click();
        $("[id=\"react-select-3-option-0\"]").click();
        $("[id=\"city\"]").click();
        $("[id=\"react-select-4-option-1\"]").click();
        $("[id=\"submit\"]").click();


        $("[id=\"example-modal-sizes-title-lg\"]").shouldHave(text("Thanks for submitting the form"));








    }
}