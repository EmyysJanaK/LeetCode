--You have employees and products tables and 
--an employee can work on multiple products and products can have multiple employees.
--Design a database schema for this.

CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50) ,
    LastName VARCHAR(50),
    HireDate DATE,
    CompanyID INT,
    FOREIGN KEY (CompanyID) REFERENCES Company(CompanyID)
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
CREATE INDEX idx_employee_id on EmployeeProducts(EmployeeID);
CREATE INDEX idx_product_id on EmployeeProducts(ProductID);
-- The Employees table stores employee details.
-- The Products table stores product details.
-- The EmployeeProducts table is a junction table that establishes a many-to-many relationship between employees and products.


--You have a company table. 
--How do you find the product names and the no. of employees who are working on those products 
--in a company named “APPLE”, Write SQL Query for that

CREATE TABLE Company (
    CompanyID INT PRIMARY KEY,
    CompanyName VARCHAR(100)
);

SELECT p.ProductName, count(ep.EmployeeID) AS NumberOfEmployees
FROM Products p
JOIN EmployeeProducts ep ON p.ProductID = ep.ProductID
JOIN Employees e ON ep.EmployeeID = e.EmployeeID
JOIN Company c ON e.CompanyID = c.CompanyID
WHERE c.CompanyName = 'APPLE'
GROUP BY p.ProductName;


SELECT p.ProductName
FROM Products p
JOIN EmployeeProducts ep ON p.ProductID = ep.ProductID
JOIN Employee e ON ep.EmployeeID = e.EmployeeID
WHERE count(ep.EmployeeID) > 9
GROUP BY p.ProductName;
--Write SQL Query to find the product names which have more than 9 employees working on it.


--number of rows in a table (efficiently)
SELECT count(*) AS total_rows
FROM your_table_name;

SELECT reltuples::BIGINT AS approximate_row_count -- reltuples -estimate of numberof rows  :BIGINT  to cast the result to BIGINT
FROM pg_class -- pg_class - system catalog table that stores information about tables and indexes
WHERE relname = 'your_table_name';
