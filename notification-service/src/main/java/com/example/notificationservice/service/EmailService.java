package com.example.notificationservice.service;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class EmailService {

    Logger logger = Logger.getLogger(EmailService.class.getName());

    public void sendEmail(String email, String operation) {
        String subject = "";
        String body = "";

        if ("create".equalsIgnoreCase(operation)) {
            subject = "Ваш аккаунт создан";
            body = "Здравствуйте! Ваш аккаунт на сайте ваш сайт был успешно создан.";
        } else if ("delete".equalsIgnoreCase(operation)) {
            subject = "Удаление аккаунта";
            body = "Здравствуйте! Ваш аккаунт был удалён.";
        } else {
            logger.warning("Unknown operation type: " + operation);
            return;
        }

        // Здесь можно подключить JavaMailSender
        logger.info("Sending email to " + email + " : " + body + ", " + subject);
    }
}

