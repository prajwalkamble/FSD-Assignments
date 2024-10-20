CREATE SCHEMA SQL_Assignment;

USE SQL_Assignment;

CREATE TABLE Employees (
    EMPNO INT PRIMARY KEY,
    ENAME VARCHAR(50),
    JOB VARCHAR(50),
    HIREDATE DATE,
    MGR INT,
    SAL DECIMAL(10, 2),
    COMM DECIMAL(10, 2),
    DEPTNO INT
);

INSERT INTO Employees (EMPNO, ENAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO)
VALUES 
(7369, 'SMITH', 'CLERK', '1980-12-17', 7902, 800, NULL, 20),
(7499, 'ALLEN', 'SALESMAN', '1981-02-20', 7698, 1600, 300, 30),
(7521, 'WARD', 'SALESMAN', '1981-02-22', 7698, 1250, 500, 30);

INSERT INTO Employees (EMPNO, ENAME, JOB, HIREDATE, MGR, SAL, COMM, DEPTNO) VALUES
(7566, 'JONES', 'MANAGER', '1981-04-02', 7839, 2975, NULL, 20),
(7654, 'MARTIN', 'SALESMAN', '1981-09-28', 7698, 1250, 1400, 30),
(7698, 'BLAKE', 'MANAGER', '1981-05-01', 7839, 2850, NULL, 30),
(7782, 'CLARK', 'MANAGER', '1981-06-09', 7839, 2450, NULL, 10),
(7788, 'SCOTT', 'ANALYST', '1987-04-19', 7566, 3000, NULL, 20),
(7839, 'KING', 'PRESIDENT', '1981-11-17', NULL, 5000, NULL, 10),
(7844, 'TURNER', 'SALESMAN', '1981-09-08', 7698, 1500, 0, 30),
(7876, 'ADAMS', 'CLERK', '1987-05-23', 7788, 1100, NULL, 20),
(7900, 'JAMES', 'CLERK', '1981-12-03', 7698, 950, NULL, 30),
(7902, 'FORD', 'ANALYST', '1981-12-03', 7566, 3000, NULL, 20),
(7934, 'MILLER', 'CLERK', '1982-01-23', 7782, 1300, NULL, 10);

SELECT * FROM Employees;

CREATE TABLE Department (
    Deptno INT PRIMARY KEY,
    Dname VARCHAR(50),
    Loc VARCHAR(50)
);

INSERT INTO Department (Deptno, Dname, Loc)
VALUES 
(10, 'Accounting', 'New York'),
(20, 'Research', 'Dallas'),
(30, 'Sales', 'Chicago'),
(40, 'Operations', 'Boston');

SELECT * FROM Department;

-- 7 Question
-- i.	Write a query to display ename and job for all the employee with their half term salary.
SELECT ename, job, (sal / 2) AS half_term_salary FROM Employees;

-- ii.	Write a query to display all the details of the employees along with  an annual bonus of 2000.
SELECT *, (sal + 2000) AS annual_bonus FROM Employees;

-- iii.	Write a query to display ename and salary with a hike of 10%.
SELECT ename, (sal * 1.10) AS 'salary_hike_10%' FROM Employees;

-- iv.	Write a query to display ename and salary with deduction of 25%.
SELECT ename, (sal * 0.75) AS 'salary_with_25%_deduction' FROM Employees;

-- 8 Question
-- i.	Write a query to display name and hire date of the employees if the employees were hired during 1982.
SELECT ename, hiredate FROM Employees WHERE YEAR(hiredate) = 1982;

-- ii.	Write a query to display name of the employee who gets salary as well as commission.
SELECT ename FROM Employees WHERE sal IS NOT NULL AND comm IS NOT NULL;

-- iii.	Write a query to display name of the employee of employee has character 'A' as the second character in the name.
SELECT ename FROM Employees WHERE ename LIKE '_A%';

-- 9 Question
-- i. Write a query to display avg salary needed to pay all the employees in each department excluding the employees of deptno 20.
SELECT deptno, avg(sal) AS average_salary FROM Employees WHERE deptno <> 20 GROUP BY deptno;

-- ii. Write a query to display number of employees having character 'a' in their names in each job.
SELECT job, COUNT(*) AS emp_count FROM Employees WHERE ename LIKE '%a%' GROUP BY job;

-- iii. Write a query to display maximum salaries given to an employee working in each dept.
SELECT deptno, max(sal) as max_salary FROM Employees GROUP BY deptno ORDER BY deptno;

-- iv. Write a query to display ename and job of all the employees working in the same designation as james.
SELECT ename, job FROM Employees WHERE job = (SELECT job FROM Employees WHERE ename = 'JAMES');

-- v. Write a query to display ename and hiredate of the employees who's name end’s with 's' and hired after james.
SELECT ename, hiredate FROM Employees WHERE ename LIKE '%s' AND hiredate > (SELECT hiredate FROM Employees WHERE ename = 'JAMES');