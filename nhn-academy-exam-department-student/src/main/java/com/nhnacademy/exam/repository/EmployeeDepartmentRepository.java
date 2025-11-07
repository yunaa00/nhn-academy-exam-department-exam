package com.nhnacademy.exam.repository;

import com.nhnacademy.exam.domain.Employee;
import com.nhnacademy.exam.domain.EmployeeDepartment;
import com.nhnacademy.exam.domain.EmployeeDepartmentId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDepartmentRepository extends JpaRepository<EmployeeDepartment, EmployeeDepartmentId> {
    List<EmployeeDepartment> findByEmployee(Employee employee);

    List<EmployeeDepartment> findByDepartmentDepartmentCode(String departmentCode);

}
