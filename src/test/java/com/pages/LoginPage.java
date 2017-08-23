package com.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;

@DefaultUrl("https://trello.com/login")
public class LoginPage extends PageObject{

    @FindBy(css = ".login-password-container-email #user")
    private WebElement inputEmail;

    @FindBy(css = ".login-password-container-email #password")
    private WebElement inputPassword;

    @FindBy(css = ".login-password-container-email #login")
    private WebElement loginButton;

    @FindBy(css = ".boards-page-board-section-list-item:nth-last-child(2)")
    private WebElement openBoard;

    public void login(String username, String password) {
        inputEmail.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
        openBoard.click();
    }
}