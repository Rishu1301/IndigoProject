import React, { useState, useEffect } from 'react';
import axios from 'axios';

const NotificationSettings = () => {
    const [settings, setSettings] = useState({
        email: '',
        phone: '',
        preferences: ''
    });

    const [id, setId] = useState(null);

    useEffect(() => {
        // Fetch notification settings if ID is available
        if (id) {
            axios.get(`/api/${id}`)
                .then(response => {
                    setSettings(response.data);
                })
                .catch(error => {
                    console.error('There was an error fetching the notification settings!', error);
                });
        }
    }, [id]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setSettings({
            ...settings,
            [name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        const apiEndpoint = id ? `/api/${id}` : '/api';

        axios.post(apiEndpoint, settings, {
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            alert('Notification settings saved successfully');
            if (!id) setId(response.data.id);
        })
        .catch(error => {
            console.error('There was an error saving the notification settings!', error);
        });
    };

    return (
        <div>
            <h2>Notification Settings</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Email:</label>
                    <input
                        type="email"
                        name="email"
                        value={settings.email}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Phone:</label>
                    <input
                        type="text"
                        name="phone"
                        value={settings.phone}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <label>Preferences:</label>
                    <textarea
                        name="preferences"
                        value={settings.preferences}
                        onChange={handleChange}
                    />
                </div>
                <button type="submit">Save Settings</button>
            </form>
        </div>
    );
};

export default NotificationSettings;
