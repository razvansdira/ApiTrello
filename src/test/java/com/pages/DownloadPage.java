package com.pages;

import com.FileDownloadJava;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.testautomationguru.utility.PDFUtil;
import org.apache.commons.io.FileUtils;

public class DownloadPage extends PageObject {

    @FindBy(css = "[class=\"icon-lg icon-close dialog-close-button js-close-window\"]")
    private WebElement closeTestCard;

    public void downloadFile(String filePath) {
//        download.click();
//        waitABit(1000);

        try {
            FileDownloadJava.saveFileWithJava(filePath, getDriver().findElement(By.cssSelector(".js-download")).getAttribute("href"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeTestCard.click();
    }

    public void compareFile() throws IOException {

        String field = "Bug.pdf";
        String fileContent = null;

        boolean found = false;
        File file = new File("E:\\TestDownloads\\bug.pdf");
        List<String> lines = FileUtils.readLines(file);
        for (String line : lines) {
            if (line.equals(field)) {
                found = true;
                break;
            }
        }
        if (!found) {
            fileContent = FileUtils.readFileToString(file);
            fileContent += "\n" + field;
        }
        FileUtils.write(file, fileContent);

//alt program
        PDFUtil pdfUtil = new PDFUtil();

        pdfUtil.getText("E:\\TestDownloads\\Bug.pdf");

        pdfUtil.getText("E:\\TestDownloads\\Bug.pdf", 1);
    }
}