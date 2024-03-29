package workspace;

import base.BaseTests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.WorkspacePage;
import utility.ReadConfig;

public class WorkspaceTests extends BaseTests {

    private final String username = ReadConfig.getProperty("username");
    private final String password = ReadConfig.getProperty("password");
    private final String spaceName = "Test Space";
    private final String deleteText = "Delete " + spaceName;

    @Test
    public void dialogOpenedWhenNewSpaceClicked() {
        LoginPage loginPage = homePage.clickLoginLink();
        WorkspacePage workspacePage = loginPage.logIn(username, password);
        workspacePage.clickNewSpaceButton();
        String newSpaceModalHeader = workspacePage.getModalHeaderText();
        Assert.assertEquals("New Space", newSpaceModalHeader);
    }

    @Test
    public void headerTitleIsSpaceNameWhenCreated() {
        LoginPage loginPage = homePage.clickLoginLink();
        WorkspacePage workspacePage = loginPage.logIn(username, password);
        workspacePage.clickNewSpaceButton();
        workspacePage.setSpaceName(spaceName);
        workspacePage.createNewSpace(spaceName);
        String headerTitleText = workspacePage.getHeaderTitleText();
        Assert.assertEquals(spaceName, headerTitleText);
        workspacePage.deleteSpace(deleteText);
    }

    @Test
    public void spaceAddedToNavMenuWhenCreated() {
        LoginPage loginPage = homePage.clickLoginLink();
        WorkspacePage workspacePage = loginPage.logIn(username, password);
        workspacePage.clickNewSpaceButton();
        workspacePage.setSpaceName(spaceName);
        workspacePage.clickCreateButton();
        String navMenuSpaceName = workspacePage.getNavMenuSpaceNameText();
        Assert.assertEquals(spaceName, navMenuSpaceName);
        workspacePage.deleteSpace(deleteText);
    }

    @Test
    public void newUntitledRStudioProjectCreated() {
        LoginPage loginPage = homePage.clickLoginLink();
        WorkspacePage workspacePage = loginPage.logIn(username, password);
        workspacePage.clickNewProjectDropdownButton();
        workspacePage.clickNewRStudioButton();
        String projectTitle = workspacePage.getProjectTitleText();
        Assert.assertEquals("Untitled Project", projectTitle);
    }

    @Test
    public void ideContainerLoadsWhenProjectCreated() {
        LoginPage loginPage = homePage.clickLoginLink();
        WorkspacePage workspacePage = loginPage.logIn(username, password);
        workspacePage.clickNewProjectDropdownButton();
        workspacePage.clickNewRStudioButton();
        workspacePage.switchFrame();
        WebElement container = workspacePage.container();
        Assert.assertTrue(container.isDisplayed());
    //    System.out.println("Assertion passed!");
    }
}
