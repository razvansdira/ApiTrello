package com.steps;

import com.pages.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class SeleniumSteps extends ScenarioSteps {

    private LoginPage loginPage;
    private CloseBoardPage closeBoardPage;
    private BoardPage boardPage;
    private AttachFilePage attachFilePage;
    private DownloadPage downloadPage;

    @Step
    public void navigateToLoginPage() {
        loginPage.open();
    }

    @Step
    public void login(String username, String password) {
        loginPage.login(username, password);
    }

    @Step
    public void moveTheCard(String cardName) {
        boardPage.selectCard(cardName);
    }

    @Step
    public void attachFile() {
        attachFilePage.uploaadFile();
    }

    @Step
    public void downloadFile() {
        downloadPage.downloadFile();
    }

    @Step
    public void more() {
        closeBoardPage.moreO();
    }
}