package com.zebrunner.carina.demo.sendtestemail.desktop;

import com.zebrunner.carina.demo.sendtestemail.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

   @FindBy(id = "ea2t")
    private ExtendedWebElement emailInput;

    @FindBy(id = "send_test_btn")
    private ExtendedWebElement sendBtn;

    @FindBy(xpath = " //div[@class='success']//a")
    private ExtendedWebElement successSendText;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void fillEmailInputField(String email) {
       emailInput.click();
        emailInput.type(email);
    }

    @Override
    public void clickOnSendButton() {
        sendBtn.click();
    }

    @Override
    public String getEmailIdText() {
        return successSendText.getText();
    }

    @Override
    public boolean isSuccessSendTextPresent() {
        return successSendText.isElementPresent();
    }
}
