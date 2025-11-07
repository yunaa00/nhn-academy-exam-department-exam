package com.nhnacademy.exam.repository;

import com.nhnacademy.exam.domain.Department;
import com.nhnacademy.exam.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,String> {
}
