package com.nhnacademy.exam.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor

public class Employee {
    @Id
    @Column(length = 20)
    private String employeeNo;

    @Column(nullable = false, length=50)
    private String name;

    public Employee(String employeeNo, String name){
        this.employeeNo=employeeNo;
        this.name=name;
    }


}
