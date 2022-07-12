package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WorkspacePage {

    private final WebDriver driver;
    private final By newSpaceButton = By.cssSelector("button.menuItem.newSpace");
    private final By newSpaceNameField = By.id("name");
    private final  By submitButton = By.cssSelector("button[type='submit']");
    private final By newSpaceModalHeaderText = By.cssSelector("div.purpose > span");
    private final By headerTitle = By.id("headerTitle");
    private final By navMenuSpaceName = By.cssSelector("div.spaceNameWithOwner");
    private final By moreActionsButton = By.cssSelector("button.moreActions");
    private final By deleteButton = By.cssSelector("button.delete");
    private final By deleteSpaceModalField = By.cssSelector("input[aria-label='Name of space to delete']");
    private final By newProjectDropdownButton = By.cssSelector("button.menuDropDown");
    private final By newRStudioProjectButton = By.cssSelector("button.newRStudioProject");
    private final By projectTitleButton = By.cssSelector("button.projectTitle");
    private final By ideContainer = By.id("rstudio_container");
    private final By fileButton = By.cssSelector("#gwt-uid-286");

    public WorkspacePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNewSpaceButton() {
        driver.findElement(newSpaceButton).click();
    }

    public void setSpaceName(String name) {
        driver.findElement(newSpaceNameField).sendKeys(name);
    }

    public void clickCreateButton() {
        driver.findElement(submitButton).click();
    }

    public void clickNewProjectDropdownButton() {
        driver.findElement(newProjectDropdownButton).click();
    }

    public void clickNewRStudioButton() {
        driver.findElement(newRStudioProjectButton).click();
    }

    public void createNewSpace(String spaceName) {
        driver.findElement(submitButton).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBe(headerTitle, spaceName));
    }

    public String getModalHeaderText() {
        return driver.findElement(newSpaceModalHeaderText).getText();
    }

    public String getHeaderTitleText() {
        return driver.findElement(headerTitle).getText();
    }

    public String getNavMenuSpaceNameText() {
        return driver.findElement(navMenuSpaceName).getText();
    }

    public void deleteSpace(String deleteText) {
        driver.findElement(moreActionsButton).click();
        driver.findElement(deleteButton).click();
        driver.findElement(deleteSpaceModalField).sendKeys(deleteText);
        driver.findElement(submitButton).click();
    }

    public String getProjectTitleText() {
        return driver.findElement(projectTitleButton).getText();
    }

    public void clickContainer() {
        driver.findElement(fileButton).click();

    }

    public void switchFrame() {
        driver.switchTo().frame("contentIFrame");

    }

    public WebElement container() {
        return driver.findElement(ideContainer);
    }
}