package com.nhnacademy.exam.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor

public class Department {
    @Id
    @Column(name="department_code")
    private String departmentCode;

    @Column(name="department_name")
    private String departmentName;

    public Department(String departmentCode,String departmentName){
        this.departmentCode=departmentCode;
        this.departmentName=departmentName;
    }


}
