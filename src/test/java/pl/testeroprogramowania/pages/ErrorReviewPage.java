package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorReviewPage {

    @FindBy(xpath = "//p[contains(text(),'please')]")
    private WebElement errorMessage;


    private WebDriver driver;

    public ErrorReviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public WebElement getError() {
        return errorMessage;
    }


}
