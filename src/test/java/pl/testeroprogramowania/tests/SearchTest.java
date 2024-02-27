package pl.testeroprogramowania.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class SearchTest extends BaseTest {


    @Test
    public void SearchProductTest() {


        ExtentTest test = extentReports.createTest("Review without name Test");
        WebElement product = new HomePage(driver)
                .search()
                .searchProduct("git")
                .getProduct();

        test.log(Status.PASS, "Searching product done");

        Assert.assertEquals(product.getText(), "GIT basics");
        test.log(Status.PASS, "Assertions passed");




    }

}
