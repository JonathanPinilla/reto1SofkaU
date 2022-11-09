package com.sofka.reto1.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("users")
public class Users {

    @Id
    private String id;

    private String name;
    private String surName;
    private String documentType;
    private String document;
    private String email;
    private String address;
    private String city;
    private String level;
    private Number state;
}
