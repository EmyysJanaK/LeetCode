--Focus: Primary Keys (PK), Foreign Keys (FK), and basic One-to-Many (1:N) relationships.

-- publishing house

-- You need to store data for a publishing house.
-- They have many Authors, and each author writes many books
-- For this design, assume a book is written by only one author.

CREATE TABLE Authors (
    author_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    title VARCHAR(200) NOT NULL, 
    author_id INT NOT NULL, -- Avoid duplicates
    FOREIGN KEY (author_id) REFERENCES Authors(author_id)
);



-- Departments and Employees
-- A company has multiple departments, and each department has multiple employees.
-- But each employee belongs to only one department.

CREATE TABLE Departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL
);

CREATE TABLE Employees (
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    department_id INT NOT NULL, 
    FOREIGN KEY (department_id) REFERENCES Departments(department_id)
);
-- WHY USE NOT NULL?
-- Using NOT NULL on foreign key columns ensures that every record in the child table (Books,
-- Employees) must be associated with a valid record in the parent table (Authors, Departments).
-- IF WE NOT USED? 
-- If NOT NULL were not used, it would be possible to have records in the child table that do not reference any record in the parent table,
