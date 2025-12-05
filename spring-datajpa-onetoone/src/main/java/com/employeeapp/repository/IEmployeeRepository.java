package com.employeeapp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employeeapp.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

    List<Employee> findByDepartment(String dept);

    @Query("from Employee e inner join e.address a where a.city = ?1")
    List<Employee> findByCity(String city);

    @Query("from Employee e inner join e.address a where e.department = ?1 and a.city = ?2")
    List<Employee> findByDeptCity(String dept, String city);

    @Query("from Employee e inner join e.address a where e.salary < ?1 and a.city = ?2")
    List<Employee> findBySalaryCity(double salary, String city, Sort sort);
}
