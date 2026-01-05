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

---Indexing in databases:
-- Indexing is a database optimization technique used to improve the speed of data retrieval operations on a database table. 
-- An index is a data structure that provides a quick lookup mechanism for locating specific rows in a table based on the values of one or more columns. 
-- Indexes are similar to the index in a book, which allows you to quickly find the page number of a specific topic without having to read through the entire book.

-- There are several types of indexes, including:

-- 1. B-Tree Indexes: These are the most common type of indexes used in relational databases. 
        ---           They organize data in a balanced tree structure, allowing for efficient range queries and exact match lookups. eg:

        ---           CREATE INDEX idx_lastname ON Employees(LastName);

-- 2. Hash Indexes: These indexes use a hash function to map values to specific locations in the index. 
        ---           They are efficient for exact match lookups but do not support range queries.
        ---           CREATE INDEX idx_employeeid ON Employees(EmployeeID) USING HASH;

-- 3. Bitmap Indexes: These indexes use bitmaps to represent the presence or absence of values in a column. 
        ---           They are particularly useful for columns with a low cardinality (few distinct values).
        ---           CREATE BITMAP INDEX idx_gender ON Employees(Gender);

-- 4. Full-Text Indexes: These indexes are used for searching text-based data, allowing for efficient searching of keywords and phrases within large text fields.
        ---           CREATE FULLTEXT INDEX idx_description ON Products(ProductDescription);

-- Indexes can significantly improve query performance, especially for large tables. 

-- However, they also come with some trade-offs, such as increased storage requirements and slower write operations (INSERT, UPDATE, DELETE) due to the need to maintain the index structure.
--explain the trade off using a code example.
-- Consider a table named Employees with a large number of records.
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Salary DECIMAL(10, 2)
);
-- Creating an index on the LastName column to improve query performance for searches based on last names.
CREATE INDEX idx_lastname ON Employees(LastName);
-- Now, when you run a query to find employees with a specific last name, the database can use the index to quickly locate the relevant records.
SELECT * FROM Employees WHERE LastName = 'Smith';
-- However, when you insert a new employee record, the database needs to update the index as well, which can slow down the insert operation.
INSERT INTO Employees (EmployeeID, FirstName, LastName, Salary)
VALUES (1, 'John', 'Smith', 60000.00);
-- In this example, while the index improves the performance of the SELECT query, it introduces additional overhead for the INSERT operation due to the need to maintain the index structure.

--is this all about indexing trade-offs?
-- Yes, the example provided illustrates the primary trade-offs associated with indexing in databases.
-- Indexes improve read/query performance but can slow down write operations due to the overhead of maintaining the index structure.
-- Additionally, indexes consume extra storage space, which can be a consideration in large databases. 

