package com.infy.Employee.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.Employee.model.Employee;
import com.infy.Employee.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("EmployeeAPI")
public class EmployeeAPI {

	@Autowired
	private EmployeeService employeeService;
	
	// search for employee by id and display manager
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable int id) throws Exception{
		return employeeService.getEmpById(id);
	}
	//displaying employeeList
	@GetMapping("/employees")
	public List<Employee> getEmployees() throws Exception{
		return employeeService.getEmployees();
	}
	//add new employee and department
	@PostMapping("/addempdept")
	public Integer addEmpDept(@RequestBody Employee employee) throws Exception{
		Integer i=employeeService.addEmpDept(employee);
		return i;
	}
	
	//add employee to an existing department
	@PostMapping("/addemp/{id}")
	public Integer addEmp(@PathVariable Integer id,@RequestBody Employee employee) throws Exception{
		Integer i=employeeService.addEmp(employee,id);
		return i;}
	
	//searching employees in a department
	@GetMapping("/findDeptEmp/{deptID}")
	public List<Employee> getdeptemp(@PathVariable Integer deptID) throws Exception {
		List<Employee> delist=employeeService.getDeptEmp(deptID);
		return delist;
	}
	
	//searching employees under a manager
	@GetMapping("/findManagerEmp/{managerName}")
	public List<Employee> getManagerEmp(@PathVariable String managerName) throws Exception {
		List<Employee> elist=employeeService.getManagerEmp(managerName);
		return elist;
		}
	
	//updating employee by id
	@PostMapping("/updateEmp/{id}")
	public Integer updateEmployee(@RequestBody Employee e, @PathVariable Integer id) throws Exception{
		return employeeService.updateEmployee(e, id);
	}
	

	
	@DeleteMapping("deleteEmp/{id}")
	public String deleteEmployee(@PathVariable Integer id) throws Exception{
		return employeeService.deleteEmployee(id);}
	}

