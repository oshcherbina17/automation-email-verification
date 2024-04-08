package com.zebrunner.carina.demo.sendtestemail.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void fillEmailInputField(String email);

    public abstract void clickOnSendButton();

    public abstract String getEmailIdText();

    public abstract boolean isSuccessSendTextPresent();
}
