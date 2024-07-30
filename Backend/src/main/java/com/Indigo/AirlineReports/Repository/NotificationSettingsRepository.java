package com.Indigo.AirlineReports.Repository;

import com.Indigo.AirlineReports.Entity.NotificationSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationSettingsRepository extends JpaRepository<NotificationSettings, Long> {
}
