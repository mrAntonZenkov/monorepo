package com.example.notificationservice.controller;

import com.example.notificationservice.dto.EmailRequestDTO;
import com.example.notificationservice.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final EmailService emailService;

    public NotificationController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendEmail(@Valid @RequestBody EmailRequestDTO request) {
        emailService.sendEmail(request.getEmail(), request.getOperation());
    }
}
