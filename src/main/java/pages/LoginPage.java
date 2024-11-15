package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//app-login")
    WebElement appLogin;

    @FindBy(css = "input[formcontrolname='username']")
    WebElement inputUsername;

    @FindBy(css = "input[formcontrolname='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//form/mat-form-field[1]//mat-error")
    WebElement usernameFieldError;

    @FindBy(xpath = "//form/mat-form-field[2]//mat-error")
    WebElement passwordFieldError;

    @FindBy(xpath = "//button[span[text()='Login']]")
    WebElement buttonLogin;

    @FindBy(id = "mat-mdc-error-0")
    WebElement error;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getLoginElement() {
        return appLogin;
    }

    public void setUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void setPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickLogin() {
        buttonLogin.click();
    }

    public String getUsernameFieldErrorMessage() {
        return usernameFieldError.getText();
    }

    public String getPasswordFieldErrorMessage() {
        return passwordFieldError.getText();
    }

    public String getErrorMessage() {
        return error.getText();
    }
}
