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
CREATE TABLE Company (
    CompanyID INT PRIMARY KEY,
    CompanyName VARCHAR(100)
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
CREATE index idx_employee_id on EmployeeProducts(EmployeeID);
CREATE index idx_product_id on EmployeeProducts(ProductID);
-- The Employees table stores employee details.
-- The Products table stores product details.
-- The EmployeeProducts table is a junction table that establishes a many-to-many relationship between employees and products.


--You have a company table. 
--How do you find the product names and the no. of employees who are working on those products 
--in a company named “APPLE”, Write SQL Query for that

SELECT p.ProductName, count(ep.EmployeeID) AS NumberOfEmployees
FROM Products p
JOIN EmployeeProducts ep ON p.ProductID = ep.ProductID
JOIN Employees e ON ep.EmployeeID = e.EmployeeID
JOIN Company c ON e.CompanyID = c.CompanyID
WHERE c.CompanyName = 'APPLE'
GROUP BY p.ProductName;