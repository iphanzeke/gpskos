/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanbiz.service;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author IW20149X
 */
public class Email {

    public void sendMail(final String username, final String password, String from, String to, String subject, String messageBody, String[] attachments) throws MessagingException {
        // Setup mail server
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Get a mail session
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        // Define a new mail message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));

//        InternetAddress[] addressTo = new InternetAddress[toList.size()];
//        int counter = 0;
//        for (Object recipient : toList) {
//            addressTo[counter] = new InternetAddress(recipient.toString());
//            counter++;
//        }
//        message.setRecipients(Message.RecipientType.TO, addressTo);
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

        message.setSubject(subject);

        // Create a message part to represent the body text
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(messageBody);

        //use a MimeMultipart as we need to handle the file attachments
        Multipart multipart = new MimeMultipart();

        //add the message body to the mime message
        multipart.addBodyPart(messageBodyPart);

        // add any file attachments to the message
        addAtachments(attachments, multipart);

        // Put all message parts in the message
        message.setContent(multipart);

        // Send the message
        Transport.send(message);

    }

    public void addAtachments(String[] attachments, Multipart multipart) throws MessagingException, AddressException {
        for (int i = 0; i <= attachments.length - 1; i++) {
            String filename = attachments[i];
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();

            //use a JAF FileDataSource as it does MIME type detection
            DataSource source = new FileDataSource(filename);
            attachmentBodyPart.setDataHandler(new DataHandler(source));

            //assume that the filename you want to send is the same as the
            //actual file name - could alter this to remove the file path
            //attachmentBodyPart.setFileName(filename);
            String[] name = filename.split("\\\\");
            attachmentBodyPart.setFileName(name[name.length - 1]);

            //add the attachment
            multipart.addBodyPart(attachmentBodyPart);
        }
    }
}
