package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://trello.com/b/FpLzZaZf/testboard")
public class CloseBoardPage extends PageObject{

    @FindBy(css="[class=\"board-menu-navigation-item-link js-open-more\"]")
    private WebElementFacade moreOptions;

    @FindBy(css="[class=\"board-menu-navigation-item-link js-close-board\"]")
    private WebElementFacade closeBoard;

    @FindBy(css = "[class=\"js-confirm full negate\"]")
    private WebElement confirmClose;

    @FindBy(css = "[class=\"quiet js-delete\"]")
    private WebElement deleteBoard;

    public void moreO(){
        moreOptions.click();
        closeBoard.click();
        confirmClose.click();
        deleteBoard.click();
    }
}