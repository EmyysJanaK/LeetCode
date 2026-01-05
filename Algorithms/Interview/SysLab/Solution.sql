--Write one simple sql query  
--to find the second highest salary from the Employee table.
SELECT Max(Salary) as SecondHighestSalary
From Employee
Where Salary < (Select Max(Salary) From Employee);

-- Write a complex sql query to find all employees who earn more than the average salary of their respective departments.
SELECT e.EmployeeID, e.FirstName, e.LastName, e.Salary, e.DepartmentID
FROM Employees e
JOIN Departments d ON e.DepartmentID = d.DepartmentID
WHERE e.Salary > (
    SELECT AVG(Salary)
    FROM Employees
    WHERE DepartmentID = e.DepartmentID
);


-- databse types : 
-- 1. Relational Databases (RDBMS): These databases store data in tables with rows and columns. They use Structured Query Language (SQL) for data manipulation and querying. Examples include MySQL, PostgreSQL, Oracle Database, and Microsoft SQL Server.
-- 2. NoSQL Databases: These databases are designed to handle unstructured or semi -structured data. They do not use SQL as their primary query language. Examples include MongoDB (document-based), Cassandra (wide-column store), Redis (key-value store), and Neo4j (graph database).
-- 3. In-Memory Databases: These databases store data in the main memory (RAM) for faster access. They are often used for caching and real-time applications. Examples include Redis and Memcached.
-- 4. NewSQL Databases: These databases combine the scalability of NoSQL with the ACID (Atomicity, Consistency, Isolation, Durability) properties of traditional relational databases. Examples include Google Spanner and CockroachDB.
-- 5. Time-Series Databases: These databases are optimized for handling time-stamped data, such as sensor data or financial data. Examples include InfluxDB and TimescaleDB.
-- 6. Object-Oriented Databases: These databases store data in the form of objects, similar to object-oriented programming. Examples include db4o and ObjectDB.
