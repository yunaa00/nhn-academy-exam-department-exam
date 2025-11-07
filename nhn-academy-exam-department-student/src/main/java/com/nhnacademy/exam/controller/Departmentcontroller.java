package com.nhnacademy.exam.controller;

import com.nhnacademy.exam.domain.Department;
import com.nhnacademy.exam.dto.DepartmentDto;
import com.nhnacademy.exam.repository.DepartmentRepository;
import com.nhnacademy.exam.repository.EmployeeDepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class Departmentcontroller {
    private final DepartmentRepository departmentRepository;


    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getDepartments() {
        List<DepartmentDto> departments = departmentRepository.findAll()
                .stream()
                .map(dept -> new DepartmentDto(dept.getDepartmentCode(), dept.getDepartmentName()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartment(@PathVariable String id) {
        Optional<Department> optional = departmentRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(404).body("부서를 찾을 수 없습니다: " + id);
        }
        Department d = optional.get();
        return ResponseEntity.ok(new DepartmentDto(d.getDepartmentCode(), d.getDepartmentName()));
    }

    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentDto dto) {
        if (dto.getDepartmentCode() == null || dto.getDepartmentName() == null) {
            return ResponseEntity.badRequest().body("departmentCode와 departmentName은 필수입니다.");
        }
        if (departmentRepository.existsById(dto.getDepartmentCode())) {
            return ResponseEntity.badRequest().body("이미 존재하는 부서 코드입니다: " + dto.getDepartmentCode());
        }

        Department department = new Department(dto.getDepartmentCode(), dto.getDepartmentName());
        departmentRepository.save(department);
        return ResponseEntity.created(URI.create("/departments/" + dto.getDepartmentCode())).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable String id, @RequestBody DepartmentDto dto) {
        Optional<Department> optional = departmentRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(404).body("부서를 찾을 수 없습니다: " + id);
        }

        Department department = optional.get();
        department.setDepartmentName(dto.getDepartmentName());
        departmentRepository.save(department);
        return ResponseEntity.ok(new DepartmentDto(department.getDepartmentCode(), department.getDepartmentName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable String id) {
        if (!departmentRepository.existsById(id)) {
            return ResponseEntity.status(404).body("부서를 찾을 수 없습니다: " + id);
        }
        departmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}





