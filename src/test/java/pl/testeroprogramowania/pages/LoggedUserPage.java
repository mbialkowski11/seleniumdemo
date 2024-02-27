package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoggedUserPage {

    @FindBy(linkText = "Dashboard")
    private WebElement dashboardLink;


    //Dodane po kursie

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutButton;


    private WebDriver driver;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getDashboardLink() {
        return dashboardLink;
    }

    public MyAccountPage logout() {
        logoutButton.click();
        return new MyAccountPage(driver);
    }


}
