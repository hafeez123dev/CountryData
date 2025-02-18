package com.psoft.SpringProject1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class EmailStatus {
    @Id
    private String email;
    private String status;

    public EmailStatus() {}
    public EmailStatus(String email, String status) {
        this.email = email;
        this.status = status;
    }
}
