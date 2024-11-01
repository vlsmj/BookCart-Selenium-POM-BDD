package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {
    @FindBy(id = "mat-input-0")
    WebElement inputFirstName;

    @FindBy()
    WebElement inputLastName;

    @FindBy()
    WebElement inputUsername;

    @FindBy()
    WebElement inputPassword;

    @FindBy()
    WebElement inputConfirmPassword;

    @FindBy()
    WebElement inputGender;

    @FindBy(xpath = "//button[span[text()='Register']]")
    WebElement buttonRegister;

    @FindBy(id = "mat-mdc-error-0")
    WebElement firstNameError;

    @FindBy
    WebElement lastNameError;

    @FindBy
    WebElement usernameError;

    @FindBy
    WebElement passwordError;

    @FindBy
    WebElement confirmPasswordError;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getFirstNameErrorMessage() {
        return firstNameError.getText();
    }

    public String getLastNameErrorMessage() {
        return lastNameError.getText();
    }

    public String getUsernameErrorMessage() {
        return usernameError.getText();
    }

    public String getPasswordErrorMessage() {
        return passwordError.getText();
    }

    public String getConfirmPasswordErrorMessage() {
        return confirmPasswordError.getText();
    }

    public void setFirstName(String firstName) {

    }

    public void setLastName(String lastName) {

    }

    public void setUsername(String username) {

    }

    public void setPassword(String password) {

    }

    public void setConfirmPassword(String confirmPassword) {

    }

    public void setGender() {

    }

    public void clickRegister() {
        buttonRegister.click();
    }
}
