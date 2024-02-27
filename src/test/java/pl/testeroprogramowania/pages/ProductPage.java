package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(name = "add-to-cart")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='woocommerce-message']//a[text()='View cart']")
    private WebElement viewCartButton;

    //Dodane po kursie

    @FindBy(xpath = "//a[@href='#tab-reviews']")
    private WebElement tabReview;

    @FindBy(xpath = "//a[@class='star-3']")
    private WebElement score3;

    @FindBy(id = "comment")
    private WebElement reviewComment;

    @FindBy(id = "author")
    private WebElement authorName;

    @FindBy(id = "email")
    private WebElement authorEmail;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='comments']//h2")
    private WebElement information;

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;

    }

    public ProductPage addProductToCart() {
        addToCartButton.click();
        return this;
    }

    public CartPage viewCart() {
        viewCartButton.click();
        return new CartPage(driver);
    }

    //Dodane po kursie

    public ProductPage goToTabReview() {
        tabReview.click();
        return this;
    }

    public ProductPage getScore3() {
        score3.click();
        return this;
    }

    public ProductPage reviewMessage(String message) {
        reviewComment.sendKeys(message);
        return this;
    }

    public ProductPage reviewAuthor(String message) {
        authorName.sendKeys(message);
        return this;
    }

    public ProductPage reviewEmailAuthor(String message) {
        authorEmail.sendKeys(message);
        return this;
    }

    public ProductPage sendGoodDataReview() {
        submitButton.click();
        return this;
    }

    public WebElement addReview() {
        return information;
    }

    public ErrorReviewPage sendBadDataReview() {
        submitButton.click();
        return new ErrorReviewPage(driver);
    }

}
