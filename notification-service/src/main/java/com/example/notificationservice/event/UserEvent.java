package com.example.notificationservice.event;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class UserEvent {
    private String operation;
    private String email;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOperation() {
        return operation;
    }

    public String getEmail() {
        return email;
    }
}
