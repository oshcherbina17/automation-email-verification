package com.zebrunner.carina.demo.sendtestemail;


import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import com.zebrunner.carina.demo.sendtestemail.common.HomePageBase;
import com.zebrunner.carina.demo.utils.EmailVerification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerificationSendMailTest implements IAbstractTest {
    final String EMAIL ="test@ukr.net";
    EmailVerification emailVerification = new EmailVerification();

    @Test()
    @MethodOwner(owner = "oshcherbina")
    public void VerificationMailTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        homePage.fillEmailInputField(EMAIL);
        homePage.clickOnSendButton();
        Assert.assertTrue(homePage.isSuccessSendTextPresent(), "Success send text isn't presented");
        String emailId = homePage.getEmailIdText();
        String getIdInbox = emailVerification.readInboundEmails();
        Assert.assertEquals(emailId,getIdInbox, " Id email are not equals");
    }
}
