package com.zebrunner.carina.demo.sendtestemail;


import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import com.zebrunner.carina.demo.sendtestemail.common.HomePageBase;
import com.zebrunner.carina.demo.utils.EmailVerificationUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zebrunner.carina.demo.utils.TestDataConstants.USERNAME;

public class VerificationSendMailTest implements IAbstractTest {
    EmailVerificationUtils emailVerificationUtils = new EmailVerificationUtils();

    @Test()
    @MethodOwner(owner = "oshcherbina")
    public void verificationMailTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        homePage.fillEmailInputField(USERNAME);
        homePage.clickOnSendButton();
        Assert.assertTrue(homePage.isSuccessSendTextPresent(), "Success send text isn't presented");
        String emailId = homePage.getEmailIdText();
        String getIdInbox = emailVerificationUtils.readInboundEmails();
        Assert.assertEquals(emailId,getIdInbox, " Id email are not equals");
    }
}
