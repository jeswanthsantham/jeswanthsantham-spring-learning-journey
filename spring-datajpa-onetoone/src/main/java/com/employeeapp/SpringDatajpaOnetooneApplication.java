package com.employeeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employeeapp.model.AddressDto;
import com.employeeapp.model.EmployeeDto;
import com.employeeapp.service.IEmployeeService;

@SpringBootApplication
public class SpringDatajpaOnetooneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaOnetooneApplication.class, args);
	}
	
	@Autowired
	private IEmployeeService employeeService;

	@Override
	public void run(String... args) throws Exception {
//		AddressDto addressDto = new AddressDto(null, "Bangalore", "Kar");
//		EmployeeDto employeeDto = new EmployeeDto("Helen", null, "Admin", 5000, addressDto);
//		// call the method
//		employeeService.addEmployee(employeeDto);
//		addressDto = new AddressDto(null, "Chennai", "TN");
//		employeeDto = new EmployeeDto("Asha", null, "Mktg", 30000, addressDto);
//		employeeService.addEmployee(employeeDto);
//		addressDto = new AddressDto(null, "Chennai", "TN");
//		employeeDto = new EmployeeDto("Mona", null, "Mktg", 18000, addressDto);
//		employeeService.addEmployee(employeeDto);
//		
//		System.out.println();
		System.out.println();
		employeeService.getAll("empName").forEach(emp->System.out.println(emp));
		
		System.out.println();
		employeeService.getByDepartment("Admin").forEach(emp->System.out.println(emp));
		System.out.println();
		employeeService.getByCity("Chennai").forEach(emp->System.out.println(emp));
		System.out.println();
		employeeService.getByDeptCity("Admin","Bangalore").forEach(emp->System.out.println(emp));
		System.out.println();
		employeeService.getBySalaryCity(25000,"Bangalore").forEach(emp->{
			System.out.println(emp.getEmpName()+ " "+emp.getDepartment()+" "+emp.getSalary());
		});
		System.out.println();
		
		
	}

}
