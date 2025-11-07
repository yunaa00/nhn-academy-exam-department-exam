package com.nhnacademy.exam.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDepartment {
    @EmbeddedId
    private EmployeeDepartmentId id;

    @ManyToOne(optional = false) @MapsId("employeeNo")
    @JoinColumn(name = "employee_no")
    private Employee employee;

    @ManyToOne(optional = false) @MapsId("departmentCode")
    @JoinColumn(name = "department_code")
    private Department department;

    public EmployeeDepartment(Employee employee, Department department){
        this.employee=employee;
        this.department=department;
        this.id=new EmployeeDepartmentId(employee.getEmployeeNo(), department.getDepartmentCode());
    }


}
