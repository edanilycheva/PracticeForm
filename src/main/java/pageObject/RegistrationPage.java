package pageObject;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pageObject.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            pictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            submitInput = $("#submit"),
            stateInput = $("#state"),
            newStateInput = $("#react-select-3-option-0"),
            cityInput = $("#city"),
            newCityInput = $("#react-select-4-option-1");


    ElementsCollection
            genderInput = $$("#genterWrapper .custom-control-inline"),
            hobbiesInput = $$(".custom-control-label"),
            resultsTable = $$(".table-responsive");




    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage typeGender(String value) {
        genderInput.findBy(text(value)).click();
        return this;
    }

    public RegistrationPage typeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage typeHobbies(String value) {
        hobbiesInput.findBy(text(value)).click();
        return this;
    }
    public RegistrationPage selectPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPage selectState() {
        stateInput.click();
        newStateInput.click();
        return this;
    }
    public RegistrationPage selectCity() {
        cityInput.click();
        newCityInput.click();
        return this;
    }
    public RegistrationPage pressSubmit() {
        submitInput.click();
        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value) {
        resultsTable.findBy(text(key))
                .parent().shouldHave(text(value));
        return this;
    }
}
