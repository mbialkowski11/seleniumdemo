package pl.testeroprogramowania.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class ReviewTest extends BaseTest {

    @Test
    public void goodDataReviewTest() {

        ExtentTest test = extentReports.createTest("Good data review Test");

        int randomNumber = (int) (Math.random() * 10000);
        String message = "Good" + randomNumber;

        WebElement goodMessageReviewRespond = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .goToTabReview()
                .getScore3()
                .reviewMessage(message)
                .reviewAuthor("Michal")
                .reviewEmailAuthor("aa@aa.pl")
                .sendGoodDataReview()
                .addReview();

        test.log(Status.PASS, "Review sended succesfull");


       Assert.assertEquals(goodMessageReviewRespond.getText(), "1 review for Java Selenium WebDriver");
       test.log(Status.PASS, "Assertions passed");
    }

    @Test
    public void reviewWithoutMessageTest() {

        ExtentTest test = extentReports.createTest("Review without message Test");

        WebElement badMessageReviewRespond = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .goToTabReview()
                .getScore3()
                .reviewMessage("")
                .reviewAuthor("Michal")
                .reviewEmailAuthor("aa@aa.pl")
                .sendBadDataReview()
                .getError();

        test.log(Status.PASS, "Review without message - good message");

        Assert.assertEquals(badMessageReviewRespond.getText(), "ERROR: please type a comment.");
        test.log(Status.PASS, "Assertions passed");
    }

    @Test
    public void reviewWithoutEmailTest() {

        ExtentTest test = extentReports.createTest("Review without email Test");

        WebElement badMessageReviewRespond = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .goToTabReview()
                .getScore3()
                .reviewMessage("Aaa")
                .reviewAuthor("Michal")
                .reviewEmailAuthor("")
                .sendBadDataReview()
                .getError();

        test.log(Status.PASS, "Review without email - good message");


        Assert.assertEquals(badMessageReviewRespond.getText(), "ERROR: please fill the required fields (name, email).");
        test.log(Status.PASS, "Assertions passed");
    }

    @Test
    public void reviewWithoutNameTest() {

        ExtentTest test = extentReports.createTest("Review without name Test");

        WebElement badMessageReviewRespond = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .goToTabReview()
                .getScore3()
                .reviewMessage("Aaa")
                .reviewAuthor("")
                .reviewEmailAuthor("aa@aa.pl")
                .sendBadDataReview()
                .getError();

        test.log(Status.PASS, "Review without author - good message");


        Assert.assertEquals(badMessageReviewRespond.getText(), "ERROR: please fill the required fields (name, email).");
        test.log(Status.PASS, "Assertions passed");
    }

}
