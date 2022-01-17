package com.example.createpdfusingthymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {

    private int id;
    private String name;
    private String emailId;
}
