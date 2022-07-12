package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final By usernameField = By.cssSelector("input[type=email]");
    private final By continueButton = By.xpath("//button[span='Continue']");
    private final By passwordField = By.cssSelector("input[type=password]");
    private final By logInButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WorkspacePage logIn(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(continueButton).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(logInButton).click();
        return new WorkspacePage(driver);
    }
}
