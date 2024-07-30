import React, { useState } from 'react';
import FlightStatusList from './FlightStatusList';
import UpdateFlightStatus from './UpdateFlightStatus';
import NotificationSettings from './NotificationSettings';
import './App.css';


function App() {
  const [selectedStatusId, setSelectedStatusId] = useState(null);

  const handleStatusSelect = (id) => {
      setSelectedStatusId(id);
  };

  return (
    <div className="App">
            <header className="App-header">
                <h1>Flight Status and Notifications</h1>
            </header>
            <main>
                <FlightStatusList onStatusSelect={handleStatusSelect} />
                <UpdateFlightStatus selectedStatusId={selectedStatusId} />
                <NotificationSettings />
            </main>
        </div>
  );
}

export default App;
