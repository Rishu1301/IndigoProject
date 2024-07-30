package com.Indigo.AirlineReports.Service;


import com.Indigo.AirlineReports.Entity.NotificationSettings;
import com.Indigo.AirlineReports.Repository.NotificationSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationSettingsService {
    @Autowired
    private NotificationSettingsRepository notificationSettingsRepository;

    @Autowired
    private EmailService emailService;

    public void saveSettings(NotificationSettings settings) {
        notificationSettingsRepository.save(settings);
    }

    public NotificationSettings getSettings(Long id) {
        return notificationSettingsRepository.findById(id).orElse(null);
    }

    public void notifyUser(NotificationSettings settings, String flightStatus) {
        String subject = "Flight Status Update";
        String text = "Dear user,\n\nThe status of your flight has changed: " + flightStatus + "\n\nThank you.";

        if (settings.getPreferences().contains("Email")) {
            emailService.sendSimpleMessage(settings.getEmail(), subject, text);
        }

        // Add other notification methods (SMS, App) here if needed.
    }
}
