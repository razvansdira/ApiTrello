package com.pages;

import com.Functions;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

import com.testautomationguru.utility.PDFUtil;

public class DownloadPage extends PageObject {

    @FindBy(css = "[class=\"icon-lg icon-close dialog-close-button js-close-window\"]")
    private WebElement closeTestCard;

    public void downloadFile(String filePath) {
//        download.click();
//        waitABit(1000);

        try {
            Functions.saveFileWithJava(filePath, getDriver().findElement(By.cssSelector(".js-download")).getAttribute("href"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeTestCard.click();

    }

    public void compareFile() throws IOException {

        PDFUtil pdfUtil = new PDFUtil();
        pdfUtil.getText("E:\\TestDownloads\\Bug.pdf", 1);
    }
}