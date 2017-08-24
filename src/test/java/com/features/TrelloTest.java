package com.features;

import com.Constants;
import com.pages.ApiActions;
import com.steps.SeleniumSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.LOGINCSV_PATH)
public class TrelloTest {


    @Before
    public void maxiPage() {
        driver.manage().window().maximize();
    }

    @Managed(uniqueSession = true)
    public WebDriver driver;

    private String username = "razvansdira";
    private String password = "Galexis1!";

    @Steps
    public SeleniumSteps steps;

    @Steps
    public ApiActions trello;

    @Test
    public void testIfAPIActionsWork() throws IOException {
        steps.navigateToLoginPage();
        steps.login(username, password);
        String boardId = trello.createBoard("TestBoard").getId();
        String listId = trello.createList("TestList", boardId).getId();
        String cardId = trello.createCard("TestCard", listId).getId();
        steps.moveTheCard("TestCard");
        steps.attachFile();
        steps.downloadFile("E:\\TestDownloads\\Bug.pdf");
        steps.more();
    }
}