package com.springaipr4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fname;
    private String email;
    private String password;  

    private String dob;
    private String address;
    private String jdate;
    private Long sal;
    private String desig;
    private Long inc;
    private String bloodgrp;
    private Long mobile;
    private String gender;
}