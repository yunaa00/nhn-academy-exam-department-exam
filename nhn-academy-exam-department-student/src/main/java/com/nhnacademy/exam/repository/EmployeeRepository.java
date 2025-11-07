package com.nhnacademy.exam.repository;

import com.nhnacademy.exam.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
