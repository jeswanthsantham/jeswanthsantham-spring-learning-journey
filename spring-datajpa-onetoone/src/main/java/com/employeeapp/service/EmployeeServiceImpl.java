package com.employeeapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.employeeapp.exception.EmployeeNotFoundException;
import com.employeeapp.model.Employee;
import com.employeeapp.model.EmployeeDto;
import com.employeeapp.repository.IEmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService{
	private final IEmployeeRepository employeeRepository;
	private final ModelMapper mapper;

	@Override
	public void addEmployee(EmployeeDto employeeDto) {
		Employee employee = mapper.map(employeeDto, Employee.class);
		employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(EmployeeDto employeeDto) {
		Employee employee = mapper.map(employeeDto, Employee.class);
		employeeRepository.save(employee);
		
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);		
	}

	@Override
	public List<EmployeeDto> getAll(String propertyChoice) {
		List<EmployeeDto> employees = 
				employeeRepository.findAll(Sort.by(propertyChoice))
				.stream()
			    .map(employee->mapper.map(employee, EmployeeDto.class))
			    .toList();
		return employees;
	}

	@Override
	public EmployeeDto getById(int employeeId) throws EmployeeNotFoundException {
		Employee employee = 
				employeeRepository.findById(employeeId)
				.orElseThrow(()-> new EmployeeNotFoundException("invalid id"));
		return mapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getByDepartment(String dept) {
		List<EmployeeDto> employees = 
				employeeRepository.findByDepartment(dept).stream()
			    .map(employee->mapper.map(employee, EmployeeDto.class))
			    .toList();
		return employees;
	}

	@Override
	public List<EmployeeDto> getByDeptCity(String dept, String city) {
		List<EmployeeDto> employees = 
				employeeRepository.findByDeptCity(dept, city).stream()
			    .map(employee->mapper.map(employee, EmployeeDto.class))
			    .toList();
		return employees;
	}
	@Override
	public List<EmployeeDto> getByCity( String city) {
		List<EmployeeDto> employees = 
				employeeRepository.findByCity(city).stream()
			    .map(employee->mapper.map(employee, EmployeeDto.class))
			    .toList();
		return employees;
	}
//
	@Override
	public List<EmployeeDto> getBySalaryCity(double salary, String city) {
		List<EmployeeDto> employees = 
				employeeRepository.findBySalaryCity(salary,city,Sort.by("salary"))
				.stream()
			    .map(employee->mapper.map(employee, EmployeeDto.class))
			    .toList();
		return employees;
	}

}