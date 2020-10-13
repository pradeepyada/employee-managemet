package com.infy.Employee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Employee.dao.EmployeeDAO;
import com.infy.Employee.model.Department;
import com.infy.Employee.model.Employee;

@Service(value="employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO employeeDAO;
	
//	@Autowired
//	private DepartmentDAO departmentDAO;

	@Override
	public Employee getEmpById(Integer employeeID) throws Exception {
		// TODO Auto-generated method stub
		Employee e=employeeDAO.getEmployeeById(employeeID);
		return e;
	}

	@Override
	public Integer addEmpDept(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		Integer id=employeeDAO.addEmpDept(employee);
		return id;
	}

	@Override
	public Integer updateEmployee(Employee employee,Integer employeeID) throws Exception {
		return employeeDAO.updateEmployee(employee,employeeID);
		// TODO Auto-generated method stub
		
	}

	@Override
	public String deleteEmployee(Integer employeeID) throws Exception {
		// TODO Auto-generated method stub
		return employeeDAO.deleteEmployee(employeeID);
	}

	@Override
	public List<Employee> getManagerEmp(String managerName) throws Exception {
		// TODO Auto-generated method stub
		return employeeDAO.getManagerEmp(managerName);
	}

	@Override
	public List<Employee> getDeptEmp(Integer deptID) throws Exception {
		return employeeDAO.getDeptEmp(deptID);
	}

	@Override
	public Integer addEmp(Employee employee,Integer deptID) throws Exception {
		// TODO Auto-generated method stub
		Integer el=employeeDAO.addEmp(employee,deptID);
		return el;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployees();
	}

}
