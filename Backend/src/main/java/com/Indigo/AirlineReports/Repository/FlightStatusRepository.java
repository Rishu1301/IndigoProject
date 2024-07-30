package com.Indigo.AirlineReports.Repository;

import com.Indigo.AirlineReports.Entity.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightStatusRepository extends JpaRepository<FlightStatus,Long> {
    FlightStatus findById(long id);
}
