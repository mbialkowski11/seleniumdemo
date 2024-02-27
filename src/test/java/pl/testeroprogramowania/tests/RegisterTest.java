package pl.testeroprogramowania.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class RegisterTest extends BaseTest {

    int randomNumber = (int) (Math.random() * 10000);
    String email = "tester" + randomNumber + "@tester.pl";

    @Test(priority = 1)
    public void registerUserTest() {

        ExtentTest test = extentReports.createTest("Register user Test");

        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData(email, "test@test.pl")
                .getDashboardLink();

        test.log(Status.PASS, "Register succesfull");

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
        test.log(Status.PASS, "Assertions passed");
    }

    @Test(priority = 2)
    public void registerUserWithSameEmailTest() {

        ExtentTest test = extentReports.createTest("Register user with same email Test");

        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData(email, "test@test.pl")
                .getErrorWithRegister();

        test.log(Status.PASS, "Duplicated email account - good message");

        Assert.assertTrue(error.getText().contains("An account is already registered with your email address. Please log in."));
        test.log(Status.PASS, "Assertions passed");
    }

    @Test(priority = 3)
    public void passwordReminderTest() {

        ExtentTest test = extentReports.createTest("Password reminder Test");

        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .resetPassword()
                .lostPasswordInputUsername(email)
                .resetPasswordButton()
                .getGoodMessageSendLostPassword();

        test.log(Status.PASS, "Password reminder succesfull");


        Assert.assertEquals(error.getText(), "Password reset email has been sent.");
        test.log(Status.PASS, "Assertions passed");
    }

}
