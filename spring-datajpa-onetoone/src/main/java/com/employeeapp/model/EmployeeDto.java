package com.employeeapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDto {

	private String empName;
	private Integer empId;
	private String department;
	private double salary;
	private AddressDto address;


}
