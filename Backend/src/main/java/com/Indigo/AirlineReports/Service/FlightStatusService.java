package com.Indigo.AirlineReports.Service;

import com.Indigo.AirlineReports.Entity.FlightStatus;
import com.Indigo.AirlineReports.Entity.NotificationSettings;
import com.Indigo.AirlineReports.Repository.FlightStatusRepository;
import com.Indigo.AirlineReports.Repository.NotificationSettingsRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightStatusService {


    @Autowired
    private FlightStatusRepository flightStatusRepository;

    @Autowired
    private NotificationSettingsService notificationSettingsService;

    @Autowired
    private NotificationSettingsRepository notificationSettingsRepository;

    public List<FlightStatus> getFlightStatus() {
        return flightStatusRepository.findAll();
    }
    public FlightStatus getFlightById(Long id){
        return flightStatusRepository.findById(id).orElse(null);
    }

    public void updateFlightStatus(Long id, String newStatus) {
        FlightStatus flightStatus = flightStatusRepository.findById(id).orElse(null);
        if (flightStatus != null) {
            flightStatus.setStatus(newStatus);
            flightStatusRepository.save(flightStatus);

            // Notify users about the status change
            List<NotificationSettings> settingsList = notificationSettingsRepository.findAll();
            for (NotificationSettings settings : settingsList) {
                notificationSettingsService.notifyUser(settings, newStatus);
            }
        }
    }
}
