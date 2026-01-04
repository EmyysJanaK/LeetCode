--You have employees and products tables and 
--an employee can work on multiple products and products can have multiple employees.
--Design a database schema for this.

CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    HireDate DATE,
);
CREATE TABLE Products (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(100),
    ProductDescription TEXT,
    Price DECIMAL(10, 2)
);
CREATE TABLE EmployeeProducts (
    EmployeeID INT,
    ProductID INT,
    PRIMARY KEY (EmployeeID, ProductID),
    FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);
-- The Employees table stores employee details.
-- The Products table stores product details.
-- The EmployeeProducts table is a junction table that establishes a many-to-many relationship between employees and products.
