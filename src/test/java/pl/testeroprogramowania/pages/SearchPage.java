package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    @FindBy(xpath = "//a[text()='GIT basics']")
    private WebElement product;



    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;

    }

    public WebElement getProduct() {

        return product;
    }




}
