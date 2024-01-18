package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {

        int randomNumber = (int) (Math.random() * 10000);
        String email = "tester" + randomNumber + "@tester.pl";

        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData(email, "test@test.pl")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void registerUserWithSameEmailTest() {

        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData("test1@test.pl", "test@test.pl")
                .getError();

        Assert.assertTrue(error.getText().contains("An account is already registered with your email address. Please log in."));
    }

}
