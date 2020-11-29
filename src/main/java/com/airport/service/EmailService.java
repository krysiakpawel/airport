package com.airport.service;

import com.airport.domain.mail.Mail;
import org.hibernate.query.criteria.internal.SelectionImplementor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(final Mail mail){
        LOGGER.info("Creating an e-mail...");
        try {
            SimpleMailMessage mailMessage = createMail(mail);
            javaMailSender.send(mailMessage);
            LOGGER.info("Mail has been send.");
        } catch (MailException e) {
            LOGGER.error("Failed to send an e-mail: " + e.getMessage(), e);
        }
    }

    private SimpleMailMessage createMail(final Mail mail){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        return mailMessage;
    }
}
