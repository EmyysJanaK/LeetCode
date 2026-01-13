-- a Car -> 0 or 1 Owner relationship

CREATE TABLE owners (
    owner_id INT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    address VARCHAR(300)
);

CREATE TABLE cars (
    car_id INT PRIMARY KEY,
    model VARCHAR(100) NOT NULL,
    year INT NOT NULL,
    owner_id INT, -- Nullable foreign key
    FOREIGN KEY (owner_id) REFERENCES owners(owner_id)
);