package com.infy.Employee.dao;

import java.util.List;

import com.infy.Employee.model.Department;
import com.infy.Employee.model.Employee;

public interface EmployeeDAO {
	
	public Employee getEmployeeById(Integer employeeID) throws Exception;
	public Integer addEmpDept(Employee employee);
	public Integer addEmp(Employee employee,Integer deptID);
	public Integer updateEmployee(Employee employee,Integer employeeID);
	public String deleteEmployee(Integer employeeID);
	public List<Employee> getDeptEmp(Integer deptID);
	public List<Employee> getManagerEmp(String managerName);
	public List<Employee> getEmployees();
}
