package com.example.Check.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Check.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
