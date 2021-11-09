package com;


import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.Address;
import com.Employee;

public class CollectionInfo {

	private List<String> names;
	private List<Employee> employeeList;
	private Set<Employee> employeeSet;
	private Map<Employee,Address> employeeAddressMap;
	private Properties stateCaptital;
	private Employee employeesArray[] = new Employee[2];
	
	public void setNames(List<String> names) {
		this.names = names;
	}
	public List<String> getNames() {
		return names;
	}
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}
	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}
	public Map<Employee, Address> getEmployeeAddressMap() {
		return employeeAddressMap;
	}
	public void setEmployeeAddressMap(Map<Employee, Address> employeeAddressMap) {
		this.employeeAddressMap = employeeAddressMap;
	}
	public Properties getStateCaptital() {
		return stateCaptital;
	}
	public void setStateCaptital(Properties stateCaptital) {
		this.stateCaptital = stateCaptital;
	}
	public Employee[] getEmployeesArray() {
		return employeesArray;
	}
	public void setEmployeesArray(Employee[] employeesArray) {
		this.employeesArray = employeesArray;
	}
}