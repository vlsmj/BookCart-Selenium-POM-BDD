package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {
    @FindBy(css = "input[formcontrolname='firstname']")
    WebElement inputFirstName;

    @FindBy(css = "input[formcontrolname='lastname']")
    WebElement inputLastName;

    @FindBy(css = "input[formcontrolname='username']")
    WebElement inputUsername;

    @FindBy(css = "input[formcontrolname='password']")
    WebElement inputPassword;

    @FindBy(css = "input[formcontrolname='confirmPassword']")
    WebElement inputConfirmPassword;

    @FindBy()
    WebElement inputGender;

    @FindBy(xpath = "//form/mat-form-field[1]//mat-error")
    WebElement firstNameFieldError;

    @FindBy(xpath = "//form//mat-form-field[2]//mat-error")
    WebElement lastNameFieldError;

    @FindBy(xpath = "//form//mat-form-field[3]//mat-error")
    WebElement usernameFieldError;

    @FindBy(xpath = "//form//mat-form-field[4]//mat-error")
    WebElement passwordFieldError;

    @FindBy(xpath = "//form//mat-form-field[5]//mat-error")
    WebElement confirmPasswordFieldError;

    @FindBy(xpath = "//button[span[text()='Register']]")
    WebElement buttonRegister;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        inputLastName.sendKeys(lastName);
    }

    public void setUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void setPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void setConfirmPassword(String password) {
        inputConfirmPassword.sendKeys(password);
    }

    public void setGender(String gender) {
        inputGender.sendKeys(gender);
    }

    public void clickRegister() {
        buttonRegister.click();
    }

    public String getInputFieldErrorMessage(String inputField) {
        return switch (inputField) {
            case "First Name" -> firstNameFieldError.getText();
            case "Last Name" -> lastNameFieldError.getText();
            case "Username" -> usernameFieldError.getText();
            case "Password" -> passwordFieldError.getText();
            case "Confirm Password" -> confirmPasswordFieldError.getText();
            default -> "";
        };
    }
}
