package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;
    private final By loginLink = By.partialLinkText("Log In");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginLink() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }
}
