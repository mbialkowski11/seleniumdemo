package pl.testeroprogramowania.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        int randomNumber = (int) (Math.random() * 10000);
        String email = "tester" + randomNumber + "@tester.pl";

        ExtentTest test = extentReports.createTest("Login Test");

        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData(email, "test@test.pl")
                .logout()
                .logInValidData(email, "test@test.pl")
                .getDashboardLink();

        test.log(Status.PASS, "Login succesfull");

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
        test.log(Status.PASS, "Assertions passed");
    }

//    @Test
//    public void logInWithInvalidDataTest() {
//
//        WebElement error = new HomePage(driver)
//                .openMyAccountPage()
//                .logInInvalidData("testowy@test.pl", "te@test.pl")
//                .getError();
//
//
//        Assert.assertTrue(error.getText().contains("Incorrect username or password."), "Expected text doesn't match");
//    }

}
