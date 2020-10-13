package com.infy.Employee.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.Employee.entity.DepartmentEntity;
import com.infy.Employee.entity.EmployeeEntity;
import com.infy.Employee.model.Department;
import com.infy.Employee.model.Employee;

@Repository(value="employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	private EntityManager entityManager;
	
	//search employee and get manager
	@Override
	public Employee getEmployeeById(Integer employeeID) throws Exception{
		// TODO Auto-generated method stub
		EmployeeEntity empEntity=entityManager.find(EmployeeEntity.class, employeeID);
		Employee emp = new Employee();
		emp.setEmployeeId(empEntity.getEmployeeID());
		emp.setEmployeeName(empEntity.getEmployeeName());
		DepartmentEntity depEntity=empEntity.getDepartmentEntity();
		if(depEntity!=null) {
			Department dep=new Department();
			dep.setDeptId(depEntity.getDeptID());
			dep.setDeptName(depEntity.getDeptName());
			dep.setManagerName(depEntity.getManagerName());
			emp.setDepartment(dep);
				
		}
		return emp;
	}
	//add employee to existing department
	@Override
	public Integer addEmp(Employee employee,Integer deptID) {
		// TODO Auto-generated method stub
		EmployeeEntity e=new EmployeeEntity();
		e.setEmployeeName(employee.getEmployeeName());
		Query query = entityManager.createQuery("select d from DepartmentEntity d where d.deptID = :deptID");
		query.setParameter("deptID", deptID);
		List<DepartmentEntity> de=query.getResultList();
		e.setDepartmentEntity(de.get(0));
		entityManager.persist(e);
		return e.getEmployeeID();	
	}
		
	
	
	//update Employee
	@Override
	public Integer updateEmployee(Employee employee,Integer employeeID) {
		// TODO Auto-generated method stub
		EmployeeEntity ee=entityManager.find(EmployeeEntity.class, employeeID);
		//ee.setEmployeeID(employee.getEmployeeId());
		ee.setEmployeeName(employee.getEmployeeName());
		return ee.getEmployeeID();
		
	}
	
	//delete Employee
	@Override
	public String deleteEmployee(Integer employeeID) {
		// TODO Auto-generated method stub
		EmployeeEntity empEntity=entityManager.find(EmployeeEntity.class, employeeID);
		empEntity.setDepartmentEntity(null);
		entityManager.remove(empEntity);
		return "deleted";
		
	}

	//add new Employee with new department
	@Override
	public Integer addEmpDept(Employee employee) {
		// TODO Auto-generated method stub
		EmployeeEntity em= new EmployeeEntity();
		//em.setEmployeeID(employee.getEmployeeId());
		em.setEmployeeName(employee.getEmployeeName());
		Department d=employee.getDepartment();
		DepartmentEntity de=new DepartmentEntity();
		//de.setDeptID(d.getDeptId());
		de.setDeptName(d.getDeptName());
		de.setManagerName(d.getManagerName());
		em.setDepartmentEntity(de);
		entityManager.persist(em);
		return em.getEmployeeID();
	}

	
	
	
	
	@Override
	public List<Employee> getDeptEmp(Integer deptID) {
		
		DepartmentEntity deptEntity = null;
		deptEntity = entityManager.find(DepartmentEntity.class, deptID);
		List<EmployeeEntity> em=deptEntity.getEmployees();
		List<Employee> el=new ArrayList<>();
		for(EmployeeEntity ee:em) {
			Employee e=new Employee();
			e.setEmployeeId(ee.getEmployeeID());
			e.setEmployeeName(ee.getEmployeeName());
			DepartmentEntity de=ee.getDepartmentEntity();
			Department d=new Department();
			d.setDeptName(de.getDeptName());
			d.setDeptId(de.getDeptID());
			d.setManagerName(de.getManagerName());
			e.setDepartment(d);
			el.add(e);
			
		}
		return el;
	}
	
	//employees under manager
	@Override
	public List<Employee> getManagerEmp(String managerName) {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("select e from EmployeeEntity e");
		List<EmployeeEntity> el=query.getResultList();
		List<Employee> e=new ArrayList<>();
		for(EmployeeEntity ee:el) {
			Employee em=new Employee();
			DepartmentEntity de=ee.getDepartmentEntity();
			if(de.getManagerName().equals(managerName)) {
				em.setEmployeeId(ee.getEmployeeID());
				em.setEmployeeName(ee.getEmployeeName());
				Department d= new Department();
				d.setDeptId(de.getDeptID());
				d.setDeptName(de.getDeptName());
				d.setManagerName(de.getManagerName());
				em.setDepartment(d);
				e.add(em);
				}
		}
		return e;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("select e from EmployeeEntity e");
		List<EmployeeEntity> el=query.getResultList();
		List<Employee> e=new ArrayList<>();
		for(EmployeeEntity ee:el) {
			Employee em=new Employee();
			em.setEmployeeId(ee.getEmployeeID());
			em.setEmployeeName(ee.getEmployeeName());
			DepartmentEntity de=ee.getDepartmentEntity();
			Department d= new Department();
			d.setDeptId(de.getDeptID());
			d.setDeptName(de.getDeptName());
			d.setManagerName(de.getManagerName());
			em.setDepartment(d);
			e.add(em);
		}
		return e;
	}
}
