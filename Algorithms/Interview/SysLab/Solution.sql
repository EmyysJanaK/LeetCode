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