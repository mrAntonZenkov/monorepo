package com.example.notificationservice.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;



public class EmailRequestDTO {
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Operation is required (create/delete)")
    private String operation;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public String getOperation(){
        return operation;
    }
}
