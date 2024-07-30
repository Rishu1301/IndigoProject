import React, { useState, useEffect } from 'react';
import axios from 'axios';

const UpdateFlightStatus = ({ selectedStatusId }) => {
    const [newStatus, setNewStatus] = useState('');
    const [flightNumber, setFlightNumber] = useState('');

    useEffect(() => {
        if (selectedStatusId) {
            axios.get(`http://localhost:8080/api/flight-status/${selectedStatusId}`)
                .then(response => {
                    setFlightNumber(response.data.flightNumber);
                })
                .catch(error => {
                    console.log('There was an error fetching the flight details!', error);
                });
        }
    }, [selectedStatusId]);

    const handleUpdate = () => {
        axios.put(`http://localhost:8080/api/flight-status/${selectedStatusId}`, { status: newStatus }, {
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            alert('Flight status updated successfully');
            setNewStatus('');
            window.location.reload();
        })
        .catch(error => {
            console.log('There was an error updating the flight status!', error);
        });
    };

    return (
        <div>
            <h2>Update Flight Status</h2>
            {selectedStatusId && (
                <div>
                    <p>Flight Number: {flightNumber}</p>
                    <input
                        type="text"
                        placeholder="New Status"
                        value={newStatus}
                        onChange={(e) => setNewStatus(e.target.value)}
                    />
                    <button onClick={handleUpdate}>Update</button>
                </div>
            )}
        </div>
    );
};

export default UpdateFlightStatus;


