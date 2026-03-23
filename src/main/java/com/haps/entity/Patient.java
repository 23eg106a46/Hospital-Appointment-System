package com.haps.entity;

import jakarta.persistence.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String gender;
    private String disease;
    private int severityLevel;  // renamed from priority to match frontend

    public Patient() {}

    public Patient(String name, int age, String gender, String disease, int severityLevel) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
        this.severityLevel = severityLevel;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getDisease() { return disease; }
    public int getSeverityLevel() { return severityLevel; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void setDisease(String disease) { this.disease = disease; }
    public void setSeverityLevel(int severityLevel) { this.severityLevel = severityLevel; }
}