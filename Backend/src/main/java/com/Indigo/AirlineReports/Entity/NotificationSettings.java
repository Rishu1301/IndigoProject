package com.Indigo.AirlineReports.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class NotificationSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String phone;
    private String preferences;

    // Constructors
    public NotificationSettings() {}

    public NotificationSettings(String email, String phone, String preferences) {
        this.email = email;
        this.phone = phone;
        this.preferences = preferences;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }


}
