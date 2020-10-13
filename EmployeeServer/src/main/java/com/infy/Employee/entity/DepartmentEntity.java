package com.infy.Employee.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EM_DEPARTMENT")
public class DepartmentEntity {
	
	@Id
	@Column(name="DEPT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptID;
	
	@Column(name="MANAGER_NAME")
	private String managerName;
	
	@Column(name="DEPT_NAME")
	private String deptName;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="DEPT_ID")
	private List<EmployeeEntity> employees;

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<EmployeeEntity> getEmployees() {		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}
	
}