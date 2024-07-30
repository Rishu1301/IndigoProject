package com.Indigo.AirlineReports.Controller;

import com.Indigo.AirlineReports.Entity.NotificationSettings;
import com.Indigo.AirlineReports.Service.NotificationSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class NotificationSettingsController {

    @Autowired
    private NotificationSettingsService notificationSettingsService;


    // Endpoint to get notification settings by ID
    @GetMapping("/{id}")
    public ResponseEntity<NotificationSettings> getNotificationSettingsById(@PathVariable Long id) {
        NotificationSettings settings = notificationSettingsService.getSettings(id);
        if (settings != null) {
            return new ResponseEntity<>(settings, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to save new notification settings
    @PostMapping
    public ResponseEntity<NotificationSettings> saveNotificationSettings(@RequestBody NotificationSettings settings) {
        notificationSettingsService.saveSettings(settings);
        return new ResponseEntity<>(settings, HttpStatus.CREATED);
    }
}
