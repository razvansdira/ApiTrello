package com.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.util.List;

public class BoardPage extends PageObject {

    @FindBy(css = "[class=\"list-card-details\"]")
    public List<WebElement> cardDetails;

    @FindBy(className = "list")
    public List<WebElement> boardLists;

    public void selectCard(String cardName) {
        for (WebElement element : cardDetails) {
            if (element.getText().toLowerCase().contains(cardName.toLowerCase())) {
                (new Actions(getDriver()).dragAndDrop(element, boardLists.get(1))).perform();
                break;
            }
        }
    }
}