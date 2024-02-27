package pl.testeroprogramowania.pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//span[text()='My account']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//span[text()='Shop']")
    private WebElement shopLink;

    // Poniżej dodane po kursie, dodatkowo
    @FindBy(name = "nimble_name")
    private WebElement contactUsNameInput;

    @FindBy(name = "nimble_email")
    private WebElement contactUsEmailInput;

    @FindBy(name = "nimble_message")
    private WebElement contactUsMessageInput;

    @FindBy(name = "nimble_submit")
    private WebElement contactUsSubmitButton;

    @FindBy(xpath = "//div[@id='sek-form-respond']/span")
    private WebElement goodInformation;

    @FindBy(xpath = "//a[@class='search-toggle_btn icn-search czr-overlay-toggle_btn']")
    private WebElement searchButton;

    @FindBy(id = "s-65d177f051c89")
    private WebElement searchLabel;




    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MyAccountPage openMyAccountPage() {
        myAccountLink.click();
        return new MyAccountPage(driver);
    }

    public ProductListPage openShopPage() {
        shopLink.click();
        return new ProductListPage(driver);
    }

    // Dodane po kursie dodatkowo
    private void fillMessageInputs(String name, String email, String message) {
        contactUsNameInput.sendKeys(name);
        contactUsEmailInput.sendKeys(email);
        contactUsMessageInput.sendKeys(message);
        contactUsSubmitButton.click();
    }

    public HomePage sendMessage(String name, String email, String message) {
        fillMessageInputs(name, email, message);
        return this;
    }
    public WebElement getGoodMessage() {
        return goodInformation;
    }

    public HomePage search() {
        searchButton.click();
        return this;
    }

    public SearchPage searchProduct(String text) {
        searchLabel.click();
        searchLabel.sendKeys(text);
        searchLabel.sendKeys(Keys.ENTER);
        return new SearchPage(driver);
    }


}
