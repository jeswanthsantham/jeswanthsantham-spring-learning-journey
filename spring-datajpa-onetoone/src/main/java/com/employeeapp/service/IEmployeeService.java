package com.employeeapp.service;

import java.util.List;

import com.employeeapp.exception.EmployeeNotFoundException;
import com.employeeapp.model.EmployeeDto;


public interface IEmployeeService {
	//crud operation
	void addEmployee(EmployeeDto employeeDto);
	void updateEmployee(EmployeeDto employeeDto);
	void deleteEmployee(int employeeId); 
	List<EmployeeDto> getAll(String propertyChoice);
	EmployeeDto getById(int employeeId)throws EmployeeNotFoundException;
	
	List<EmployeeDto> getByDepartment(String dept);
	List<EmployeeDto> getByCity(String city);
	List<EmployeeDto> getByDeptCity(String dept,String city);
	List<EmployeeDto> getBySalaryCity(double salary, String city);

}