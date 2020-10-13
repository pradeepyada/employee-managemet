DROP DATABASE if exists EMPLOYEE;
CREATE DATABASE EMPLOYEE;
USE  EMPLOYEE;



CREATE TABLE EM_EMPLOYEE(
	EMPLOYEE_ID  INT auto_increment,
	EMPLOYEE_NAME VARCHAR(50) NOT NULL,
	DEPT_ID INT NOT NULL,
	constraint EM_EMPLOYEE_EMPLOYEE_ID_PK primary key ( EMPLOYEE_ID ),index(DEPT_ID)
);

CREATE TABLE EM_DEPARTMENT(
	DEPT_ID  INT auto_increment,
	MANAGER_NAME VARCHAR(50) NOT NULL,
	DEPT_NAME VARCHAR(50) NOT NULL,
	constraint EM_DEPARTMENT_DEPT_ID_PK primary key ( DEPT_ID )	
);

ALTER TABLE EM_EMPLOYEE ADD CONSTRAINT EM_EMPLOYEE_DEPT_ID_FK FOREIGN KEY ( DEPT_ID ) REFERENCES EK_DEPARTMENT( DEPT_ID );


INSERT INTO EM_EMPLOYEE (EMPLOYEE_ID, EMPLOYEE_NAME, DEPT_ID) VALUES (1001, 'arjun', 5002);
INSERT INTO EM_EMPLOYEE (EMPLOYEE_ID, EMPLOYEE_NAME, DEPT_ID) VALUES (1002, 'Ram', 5001);
INSERT INTO EM_EMPLOYEE (EMPLOYEE_ID, EMPLOYEE_NAME, DEPT_ID) VALUES (1003, 'mahesh', 5003);
INSERT INTO EM_EMPLOYEE (EMPLOYEE_ID, EMPLOYEE_NAME, DEPT_ID) VALUES (1004, 'Pavan', 5002);
INSERT INTO EM_EMPLOYEE (EMPLOYEE_ID, EMPLOYEE_NAME, DEPT_ID) VALUES (1005, 'kalyan', 5001);
INSERT INTO EM_EMPLOYEE (EMPLOYEE_ID, EMPLOYEE_NAME, DEPT_ID) VALUES (1006, 'charan', 5003);
INSERT INTO EM_EMPLOYEE (EMPLOYEE_ID, EMPLOYEE_NAME, DEPT_ID) VALUES (1008, 'sunil', 5004);
INSERT INTO EM_EMPLOYEE (EMPLOYEE_ID, EMPLOYEE_NAME, DEPT_ID) VALUES (1009, 'anil', 5002);
INSERT INTO EM_EMPLOYEE (EMPLOYEE_ID, EMPLOYEE_NAME, DEPT_ID) VALUES (1010, 'chetan', 5004);



INSERT INTO EM_DEPARTMENT (DEPT_ID, MANAGER_NAME, DEPT_NAME) VALUES (5001,'dev','HR');
INSERT INTO EM_DEPARTMENT (DEPT_ID, MANAGER_NAME, DEPT_NAME) VALUES (5002,'begi','Technology');
INSERT INTO EM_DEPARTMENT (DEPT_ID, MANAGER_NAME, DEPT_NAME) VALUES (5003,'bhumi','ETA');
INSERT INTO EM_DEPARTMENT (DEPT_ID, MANAGER_NAME, DEPT_NAME) VALUES (5004,'dev','TP');
