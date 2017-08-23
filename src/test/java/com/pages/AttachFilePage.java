package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;


public class AttachFilePage extends PageObject{

    @FindBy(css="[class=\"list-card-title js-card-name\"]")
    private WebElementFacade selectCard;

    @FindBy(css="[class=\"button-link js-attach\"]")
    private WebElementFacade attachButton;

    public void uploaadFile(){
        selectCard.click();
        attachButton.click();
        getDriver().findElement(By.className("js-attach-file")).sendKeys("E:\\images\\show.png");
    }
}