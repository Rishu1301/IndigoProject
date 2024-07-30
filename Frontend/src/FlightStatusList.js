import React, { useEffect, useState } from 'react';
import axios from 'axios';

const FlightStatusList = ({ onStatusSelect }) => {
    const [flightStatuses, setFlightStatuses] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/flight-status')
            .then(response => {
                setFlightStatuses(response.data);
            })
            .catch(error => {
                console.log('There was an error fetching the flight statuses!', error);
            });
    }, []);

    return (
        <div>
            <h2>Flight Statuses</h2>
            <ul>
                {flightStatuses.map(status => (
                    <li key={status.id} onClick={() => onStatusSelect(status.id)}>
                        <div>Flight Number: {status.flightNumber}</div>
                        <div>Status: {status.status}</div>
                        <div>Gate: {status.gate}</div>
                        <div>Time: {status.time}</div>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default FlightStatusList;
