package pl.testeroprogramowania.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.models.Customer;
import pl.testeroprogramowania.pages.*;


public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        ExtentTest test = extentReports.createTest("Checkout Test");
        Customer customer = new Customer();
        customer.setEmail("specific@gmail.com");

        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAdressDetails(customer,"Some random comment");

        test.log(Status.PASS, "Checkout done");

       Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(),"Thank you. Your order has been received.");
       Assert.assertEquals(orderDetailsPage.getProductName().getText(),"Java Selenium WebDriver × 1");

       test.log(Status.PASS, "Assertions passed");

    }

    @Test
    public void checkoutOldMethodTest() {

        ExtentTest test = extentReports.createTest("Checkout with many steps Test");
        Customer customer = new Customer();
        customer.setEmail("specific@gmail.com");
        test.log(Status.PASS, "Set email passed");

        HomePage homePage = new HomePage(driver);
        homePage.openShopPage();
        test.log(Status.PASS, "Open shop page done");

        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.openProduct("Java Selenium WebDriver");
        test.log(Status.PASS, "Open product page done");

        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart();
        test.log(Status.PASS, "Add product to cart done");
        productPage.viewCart();
        test.log(Status.PASS, "Open cart page done");


        CartPage cartPage = new CartPage(driver);
        cartPage.openAddressDetails();
        test.log(Status.PASS, "Open address details done");

        AddressDetailsPage addressDetailsPage = new AddressDetailsPage(driver);
        addressDetailsPage.fillAdressDetails(customer,"Some random comment");
        test.log(Status.PASS, "Fill customer details done");

        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);
        test.log(Status.PASS, "Checkout done");

        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(),"Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductName().getText(),"Java Selenium WebDriver × 1");

        test.log(Status.PASS, "Assertions passed");

    }


}
