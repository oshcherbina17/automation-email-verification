package com.zebrunner.carina.demo.utils;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Store;

public class EmailVerification {

    String host = "imap.ukr.net";

    String username = "test@ukr.net";

    String password = "*****************";

    private static final Logger logger = LoggerFactory.getLogger(EmailVerification.class);

    public String readInboundEmails() {
        Session session = this.getImapSession();
        String buff = "";
        try {
            Store store = session.getStore("imap");
            store.connect(host, username, password);

            Folder inbox = store.getFolder("INBOX");
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
        props.setProperty("mail.imap.host", host);
        props.setProperty("mail.imap.port", "993");


        Session session = Session.getInstance(props);
        System.out.println("Session value is :" + session);
        return session;
    }
}