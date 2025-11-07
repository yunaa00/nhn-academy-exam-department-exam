package com.nhnacademy.exam.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmployeeDepartmentId is a Querydsl query type for EmployeeDepartmentId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QEmployeeDepartmentId extends BeanPath<EmployeeDepartmentId> {

    private static final long serialVersionUID = -1949840545L;

    public static final QEmployeeDepartmentId employeeDepartmentId = new QEmployeeDepartmentId("employeeDepartmentId");

    public final StringPath departmentCode = createString("departmentCode");

    public final StringPath employeeNo = createString("employeeNo");

    public QEmployeeDepartmentId(String variable) {
        super(EmployeeDepartmentId.class, forVariable(variable));
    }

    public QEmployeeDepartmentId(Path<? extends EmployeeDepartmentId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmployeeDepartmentId(PathMetadata metadata) {
        super(EmployeeDepartmentId.class, metadata);
    }

}

