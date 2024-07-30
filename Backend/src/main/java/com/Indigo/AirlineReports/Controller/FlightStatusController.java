package com.Indigo.AirlineReports.Controller;

import com.Indigo.AirlineReports.Entity.FlightStatus;
import com.Indigo.AirlineReports.Service.FlightStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight-status")
@CrossOrigin(origins = "http://localhost:3000")
public class FlightStatusController {
    @Autowired
    private FlightStatusService flightStatusService;

    @GetMapping
    public ResponseEntity<List<FlightStatus>> getFlightStatus() {
        List<FlightStatus> statusList = flightStatusService.getFlightStatus();
        return new ResponseEntity<>(statusList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightStatus> getFlightStatusById(@PathVariable Long id) {
        FlightStatus flightStatus = flightStatusService.getFlightById(id);
        if (flightStatus != null) {
            return new ResponseEntity<>(flightStatus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightStatus> updateFlightStatus(@PathVariable Long id, @RequestBody FlightStatus flightStatusDetails) {
        flightStatusService.updateFlightStatus(id, flightStatusDetails.getStatus());
        FlightStatus updatedFlightStatus = flightStatusService.getFlightById(id);
        return new ResponseEntity<>(updatedFlightStatus, HttpStatus.OK);
    }
}
