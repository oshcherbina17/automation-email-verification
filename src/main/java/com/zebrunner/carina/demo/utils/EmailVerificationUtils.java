package com.zebrunner.carina.demo.utils;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Store;

import static com.zebrunner.carina.demo.sendtestemail.enums.EmailFolders.INBOX;
import static com.zebrunner.carina.demo.utils.TestDataConstants.HOST;
import static com.zebrunner.carina.demo.utils.TestDataConstants.PASSWORD;
import static com.zebrunner.carina.demo.utils.TestDataConstants.USERNAME;

public class EmailVerificationUtils {

    private static final Logger logger = LoggerFactory.getLogger(EmailVerificationUtils.class);

    public String readInboundEmails() {
        Session session = this.getImapSession();
        String buff = "";
        try {
            Store store = session.getStore("imap");
            store.connect(HOST, USERNAME, PASSWORD);

            Folder inbox = store.getFolder(INBOX.getNameFolders());
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            for (Message message : messages) {
                buff = message.getSubject();
                System.out.println("Subject: " + message.getSubject());
            }
            inbox.close(false);
            store.close();

        } catch (MessagingException e) {
            logger.error("Exception in reading EMails : " + e.getMessage());
        }
        return buff.replace("SendTestEmail.com - Testing Email ID: ", "");
    }

    private Session getImapSession() {
        Properties props = new Properties();
        props.setProperty("mail.imap.ssl.enable", "true");
        props.setProperty("mail.imap.host", HOST);
        props.setProperty("mail.imap.port", "993");


        Session session = Session.getInstance(props);
        System.out.println("Session value is :" + session);
        return session;
    }
}