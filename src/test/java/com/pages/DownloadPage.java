package com.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadPage extends PageObject {

    @FindBy(css = "[class=\"attachment-thumbnail-details-options-item dark-hover js-download\"]")
    private WebElement download;

    @FindBy(css = "[class=\"icon-lg icon-close dialog-close-button js-close-window dialog-close-button-light\"]")
    private WebElement closeTestCard;

    public void downloadFile() {
        download.click();
        waitABit(1000);
        closeTestCard.click();
    }
}