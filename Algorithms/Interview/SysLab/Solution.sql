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


--select query for outer left join and inner join difference
-- Inner Join: Returns only the rows that have matching values in both tables.
SELECT e.EmployeeID, e.FirstName, d.DepartmentName
FROM Employees e
INNER JOIN Departments d ON e.DepartmentID = d.DepartmentID;
-- Left Outer Join: Returns all rows from the left table (Employees), and the matched rows from the right table (Departments).
-- If there is no match, NULL values are returned for columns from the right table.
SELECT e.EmployeeID, e.FirstName, d.DepartmentName
FROM Employees e    
LEFT JOIN Departments d ON e.DepartmentID = d.DepartmentID;

-- Explain different types of databases and indexing in databases with trade offs and transactions in databases with isolation levels and database replication with examples.

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


-- Transactions in databases:-- A transaction in a database is a sequence of one or more SQL operations that are executed as a single unit of work. 
-- Transactions are used to ensure data integrity and consistency, especially in multi-user environments where multiple users may be accessing and modifying the database simultaneously.
-- A transaction has the following properties, often referred to as ACID properties:
-- 1. Atomicity: This property ensures that all operations within a transaction are treated as a single unit. 
        ---           If any operation fails, the entire transaction is rolled back, and the database remains unchanged.
-- 2. Consistency: This property ensures that a transaction brings the database from one valid state to another valid state, maintaining all defined rules and constraints.
-- 3. Isolation: This property ensures that the operations of one transaction are isolated from the operations of other transactions. 
        ---           Changes made by one transaction are not visible to other transactions until the transaction is committed. 
-- 4. Durability: This property ensures that once a transaction is committed, its changes are permanent and will survive any subsequent system failures.
-- Example of a transaction in SQL:
BEGIN TRANSACTION;
    UPDATE Accounts
    SET Balance = Balance - 100
    WHERE AccountID = 1;

    UPDATE Accounts
    SET Balance = Balance + 100
    WHERE AccountID = 2;
COMMIT;
-- In this example, the transaction transfers $100 from AccountID 1 to AccountID 2.
-- If both UPDATE operations are successful, the transaction is committed, and the changes are saved to the database.
-- If either operation fails, the transaction can be rolled back to ensure that no partial changes are made to the database.
ROLLBACK;

-- what if accountid 3 will transfer money to accountid 2 at the same time?
-- In a multi-user environment, if AccountID 3 is transferring money to AccountID 2 at the same time as the transaction involving AccountID 1 and AccountID 2,
-- the database management system (DBMS) uses isolation mechanisms to ensure that the transactions do not interfere with each other.
-- This is typically achieved through locking mechanisms, where the DBMS locks the rows being modified by one transaction to prevent other transactions from accessing them until the first transaction is completed (committed or rolled back).
-- For example, when the first transaction updates the balance of AccountID 2, it may acquire a lock on that row.
-- If the second transaction tries to update the same row (AccountID 2) while the
-- first transaction is still in progress, it will be blocked until the first transaction is completed.
-- This ensures that the balance of AccountID 2 remains consistent and accurate, regardless of the concurrent transactions.
--implementation of isolation levels in sql?
-- SQL databases typically support several isolation levels that define the degree to which transactions are isolated from each other.
-- The most common isolation levels are:
-- 1. Read Uncommitted: This is the lowest isolation level, where transactions can read uncommitted changes made by other transactions. 
        ---           This can lead to dirty reads, where a transaction reads data that may later be rolled back.
-- 2. Read Committed: In this isolation level, transactions can only read committed changes made by other transactions. 
        ---           This prevents dirty reads but can still allow non-repeatable reads, where a transaction reads the same data multiple times and gets different results if another transaction modifies that data in between.
-- 3. Repeatable Read: This isolation level ensures that if a transaction reads a row, it will get the same value if it reads that row again, even if other transactions modify that row in the meantime. 
        ---           This prevents non-repeatable reads but can still allow phantom reads, where new rows
-- are added by other transactions that match the search criteria of the first transaction.
-- 4. Serializable: This is the highest isolation level, where transactions are completely isolated from each other. 
        ---           It ensures that the results of concurrent transactions are the same as if the transactions were executed serially, one after the other. 
        ---           This prevents dirty reads, non-repeatable reads, and phantom reads but can lead to reduced concurrency and potential performance issues.
-- Example of setting isolation levels in SQL:

-- Set the isolation level to Read Committed
SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
BEGIN TRANSACTION;
    -- Transaction operations go here
    UPDATE Accounts
    SET Balance = Balance - 50
    WHERE AccountID = 1;
    UPDATE Accounts
    SET Balance = Balance + 50
    WHERE AccountID = 2;
COMMIT;
-- Set the isolation level to Serializable
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
BEGIN TRANSACTION;
    -- Transaction operations go here
    UPDATE Accounts
    SET Balance = Balance + 50
    WHERE AccountID = 2;

ROLLBACK;
-- The specific syntax for setting isolation levels may vary depending on the database management system (DBMS) being used.


-- database replication:-- Database replication is the process of copying and maintaining database objects, 
--                          such as tables and data, across multiple database servers or instances.
-- Replication is used to improve data availability, fault tolerance, and performance by distributing the workload across multiple servers. 
-- There are several types of database replication, including:
-- 1. Master-Slave Replication: In this type of replication, one database
--    server (the master) is designated as the primary source of data, while one or more other servers (the slaves)
--    replicate the data from the master. All write operations are performed on the master, and the slaves are read-only copies of the master.
-- gen example of setting up master-slave replication in MySQL:
-- On the master server:
-- Edit the MySQL configuration file (my.cnf) to enable binary logging and set a unique server ID.
[mysqld]
server-id=1
log-bin=mysql-bin
-- Restart the MySQL server to apply the changes.
-- Create a replication user with the necessary privileges.
CREATE USER 'replicator'@'%' IDENTIFIED BY 'password';
GRANT REPLICATION SLAVE ON *.* TO 'replicator'@'%';
-- Obtain the current binary log file name and position.
SHOW MASTER STATUS;
-- On the slave server:
-- Edit the MySQL configuration file (my.cnf) to set a unique server ID.
[mysqld]
server-id=2
-- Restart the MySQL server to apply the changes.
-- Configure the slave to connect to the master server.
CHANGE MASTER TO
    MASTER_HOST='master_server_ip',
    MASTER_USER='replicator',
    MASTER_PASSWORD='password',
    MASTER_LOG_FILE='mysql-bin.000001', -- Use the log file name obtained from the master
    MASTER_LOG_POS=  107;                -- Use the log position obtained from the master
-- Start the replication process on the slave server.
START SLAVE;
-- Check the status of the slave to ensure replication is working correctly.
SHOW SLAVE STATUS\G;

-- 2. Master-Master Replication: In this type of replication, multiple database servers can act as both masters and slaves.
--    Each server can perform write operations, and changes are replicated to all other servers.
-- gen example of setting up master-master replication in MySQL:
-- On both servers, edit the MySQL configuration file (my.cnf) to enable binary logging and set unique server IDs.
[mysqld]
server-id=1  -- On server 1
log-bin=mysql-bin
[mysqld]
server-id=2  -- On server 2
log-bin=mysql-bin
-- Restart the MySQL servers to apply the changes.