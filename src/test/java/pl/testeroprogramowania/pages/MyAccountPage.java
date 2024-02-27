package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    @FindBy(id = "reg_email")
    private WebElement regEmailInput;

    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;

    @FindBy(name = "register")
    private WebElement registerButton;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement errorWithRegister;

    // Po kursie, dodatkowe

    @FindBy(xpath = "//a[text()='Lost your password?']")
    private WebElement lostPasswordLink;

    @FindBy(id = "user_login")
    private WebElement lostPasswordUsernameInput;

    @FindBy(xpath = "//button[@class='woocommerce-Button button']")
    private WebElement lostPasswordButton;

    @FindBy(xpath = "//div[@class='woocommerce-message']")
    private WebElement sendResetPasswordEmail;

    private WebDriver driver;


    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage registerUserValidData(String email, String password) {
        registerUser(email, password);
        return new LoggedUserPage(driver);
    }


    public MyAccountPage registerUserInvalidData(String email, String password) {
        registerUser(email, password);
        return this;
    }

    private void registerUser(String email, String password) {
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        registerButton.click();
    }

    public LoggedUserPage logInValidData(String email, String password) {
        logIn(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage logInInvalidData(String username, String password) {
        logIn(username, password);
        return this;
    }

    private void logIn(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public WebElement getErrorWithRegister() {
        return errorWithRegister;
    }

    // Dodane po kursie

    public MyAccountPage resetPassword() {
        lostPasswordLink.click();
        return this;
    }

    public MyAccountPage lostPasswordInputUsername(String message) {
        lostPasswordUsernameInput.sendKeys(message);
        return this;
    }

    public MyAccountPage resetPasswordButton() {
        lostPasswordButton.click();
        return this;
    }

    public WebElement getGoodMessageSendLostPassword() {
        return sendResetPasswordEmail;
    }

}
