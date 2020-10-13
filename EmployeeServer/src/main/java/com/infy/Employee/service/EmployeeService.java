package com.infy.Employee.service;

import java.util.List;

import com.infy.Employee.model.Department;
import com.infy.Employee.model.Employee;

public interface EmployeeService {
	
	public Employee getEmpById(Integer employeeID) throws Exception;
	
	public Integer addEmpDept(Employee employee) throws Exception;
	
	public Integer addEmp(Employee employee,Integer deptID) throws Exception;
	
	public Integer updateEmployee(Employee employee,Integer employeeID) throws Exception;
	
	public String deleteEmployee(Integer id) throws Exception;
	
	public List<Employee> getManagerEmp(String managerName) throws Exception;
	
	public List<Employee> getDeptEmp(Integer deptID) throws Exception;

	public List<Employee> getEmployees();

}