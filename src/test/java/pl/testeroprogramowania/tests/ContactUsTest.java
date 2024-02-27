package pl.testeroprogramowania.tests;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class ContactUsTest extends BaseTest {

    @Test
    public void contactUsGoodDataTest() {

        ExtentTest test = extentReports.createTest("Contact us good data Test");

        WebElement contactUsRespond = new HomePage(driver)
                .sendMessage("Michal", "aa@aa.pl", "New message")
                .getGoodMessage();
        test.log(Status.PASS, "Send message done");

        Assert.assertEquals(contactUsRespond.getText(), "It is demo page! We are not sending emails!");
        test.log(Status.PASS, "Assertions passed");
    }

    @Test
    public void contactUsWithWrongEmailTest() {

        ExtentTest test = extentReports.createTest("Contact us with wrong email Test");

        WebElement contactUsRespond = new HomePage(driver)
                .sendMessage("Michal","aa", "New message")
                .getGoodMessage();

        test.log(Status.PASS, "Wrong email - good message");


        Assert.assertEquals(contactUsRespond.getText(), "Invalid form submission : some fields have not been entered properly. The following field is not well formed : Test Data.");
        test.log(Status.PASS, "Assertions passed");
    }


}
