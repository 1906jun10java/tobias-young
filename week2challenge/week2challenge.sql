--Create a database with two tables:
--EMPLOYEE
--Columns: EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL
--DEPARTMENT:
--Columns: DEPARTMENT_ID, DEPARTMENT_NAME

--Create a sequence and trigger to auto-generate primary key values for both tables. 

--Insert at least six employees and three departments. 

--Create a program in Java using JDBC and the DAO pattern to connect to your database.
--Store your database credentials in a properties file. 

--Write a prepared statement which prints each department's name and average salary to the console in Eclipse/STS. 

--Write another prepared or statement to insert a new Employee.

--Submit your code to your repository as a Java project called “Week2CodeChallenge”, and include the .sql file with all of your entity creation statements in the same location. 


CREATE TABLE EMPLOYEE (
EMPLOYEE_ID INTEGER PRIMARY KEY,
EMP_FIRSTNAME VARCHAR2(25),
EMP_LASTNAME VARCHAR2(25),
DEPARTMENT_ID INTEGER,
SALARY NUMBER (10,2),
EMP_EMAIL VARCHAR2(55))
/
CREATE TABLE DEPARTMENT(
DEPARTMENT_ID INTEGER PRIMARY KEY,
DEPARTMENT_NAME VARCHAR2(50))
/
CREATE SEQUENCE SQ_EMP;
/
CREATE OR REPLACE TRIGGER TR_EMP_IN
BEFORE INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
SELECT SQ_EMP.NEXTVAL INTO : NEW.EMPLOYEE_ID FROM DUAL;
END;
/
CREATE SEQUENCE SQ_DEPT;
/
CREATE OR REPLACE TRIGGER TR_DEPT_IN
BEFORE INSERT ON DEPARTMENT
FOR EACH ROW
BEGIN
SELECT SQ_DEPT.NEXTVAL INTO : NEW.DEPARTMENT_ID FROM DUAL;
END;
/
INSERT INTO DEPARTMENT (DEPARTMENT_NAME)
VALUES ('BEAR RESEARCH');
/
INSERT INTO DEPARTMENT (DEPARTMENT_NAME)
VALUES ('COBBLING');
/
INSERT INTO DEPARTMENT (DEPARTMENT_NAME)
VALUES ('SERVENT TO THE BEAR MONARCHY');
/
INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES('Jeeves', 'Britishman', 2, 100000.00, 'jeeves@ursinemonarch.com');
/
INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES('Rhys', 'Roberts', 1, 75000.00, 'rhys@ursinemonarch.com');
/
INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES('Teddy', 'Davidson', 3, 110000.00, 'teddy@ursinemonarch.com');
/
INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES('Wadsworth', 'Butler', 2, 100000.00, 'wadsworth@ursinemonarch.com');
/
INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES('Kai', 'Bailey', 2, 750000.00, 'kai@ursinemonarch.com');
/
INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES('Marley', 'Nicholson', 2, 110000.00, 'marley@ursinemonarch.com');
/