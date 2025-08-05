-- Bus Table
CREATE TABLE bus (
    bus_id INT PRIMARY KEY,
    bus_name VARCHAR(100),
    total_seats INT
);

-- Booking Table
CREATE TABLE booking (
    booking_id INT PRIMARY KEY AUTO_INCREMENT,
    bus_id INT,
    passenger_name VARCHAR(100),
    seat_number INT,
    FOREIGN KEY (bus_id) REFERENCES bus(bus_id)
);
