package com.features;

import com.Constants;
import com.Functions;
import com.pages.ApiActions;
import com.steps.SeleniumSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

import static org.junit.Assert.assertTrue;

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
    private String watcedLog;

    @Steps
    public SeleniumSteps steps;

    @Steps
    public ApiActions trello;

    @Rule
    public MethodRule watchman = new TestWatchman() {
        @Override
        public void failed(Throwable e, FrameworkMethod method) {

            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            String className = getClass().toString().replace("$1", "").replace("class ", "");
            String testName = writer.toString().split(className + ".")[1].split("\\(")[0];

            SimpleDateFormat dateFormat = new SimpleDateFormat(" MM_dd_yyyy HH_mm_ss");
            Date now = new Date();
            String currentDate = dateFormat.format(now);

            Functions.takeScreenShot("E:\\TestDownloads\\" + className + "." + testName + currentDate + ".jpg", driver);
            watcedLog += method.getName() + " " + e.getClass().getSimpleName() + "\n";
        }
    };

    @Test
    public void testIfAPIActionsWork() throws IOException {
        steps.navigateToLoginPage();
//        steps.login(username, password);
//        String boardId = trello.createBoard("TestBoard").getId();
//        String listId = trello.createList("TestList", boardId).getId();
//        String cardId = trello.createCard("TestCard", listId).getId();
//        steps.moveTheCard("TestCard");
//        steps.attachFile();
//        steps.downloadFile("E:\\TestDownloads\\Bug.pdf");
//        steps.more();
        assertTrue(false);
    }
}