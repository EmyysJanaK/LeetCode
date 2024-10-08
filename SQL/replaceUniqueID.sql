# Write your MySQL query statement below

SELECT Emp.name, EmpU.unique_id
FROM Employees Emp
LEFT JOIN EmployeeUNI EmpU ON Emp.id = EmpU.id
ORDER BY Emp.name;
