import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObject.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithPageObjectAndFakerTest {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.numerify("##########");
    String currentAddress = faker.address().fullAddress();

    String day = "30", month = "July", year = "2008";
    String gender = "Male", hobbies = "Sports",subjects ="Maths";



    RegistrationPage registrationPage = new RegistrationPage();


    @BeforeSuite
    static void BeforeSuite() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void PracticeFormTest() {

        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .typeGender(gender)
                .typeUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjectsInput(subjects)
                .typeHobbies(hobbies)
                .selectPicture("pic.png")
                .setCurrentAddress(currentAddress)
                .selectState()
                .selectCity()
                .pressSubmit()




        .checkResultsValue("Student Name",firstName + " " + lastName)
                .checkResultsValue("Student Email", userEmail)
                .checkResultsValue("Gender", gender)
                .checkResultsValue("Mobile", userNumber)
                .checkResultsValue("Date of Birth", day + " "+month+ ","+year)
                .checkResultsValue("Subjects", subjects)
                .checkResultsValue("Hobbies", hobbies)
                .checkResultsValue("Picture", "pic.png")
                .checkResultsValue("Address", currentAddress)
                .checkResultsValue("State and City", "NCR Gurgaon");


    }
}