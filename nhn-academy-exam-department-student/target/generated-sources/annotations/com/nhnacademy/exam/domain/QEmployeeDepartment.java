package com.nhnacademy.exam.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmployeeDepartment is a Querydsl query type for EmployeeDepartment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmployeeDepartment extends EntityPathBase<EmployeeDepartment> {

    private static final long serialVersionUID = -1168508124L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmployeeDepartment employeeDepartment = new QEmployeeDepartment("employeeDepartment");

    public final QDepartment department;

    public final QEmployee employee;

    public final QEmployeeDepartmentId id;

    public QEmployeeDepartment(String variable) {
        this(EmployeeDepartment.class, forVariable(variable), INITS);
    }

    public QEmployeeDepartment(Path<? extends EmployeeDepartment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEmployeeDepartment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEmployeeDepartment(PathMetadata metadata, PathInits inits) {
        this(EmployeeDepartment.class, metadata, inits);
    }

    public QEmployeeDepartment(Class<? extends EmployeeDepartment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new QDepartment(forProperty("department")) : null;
        this.employee = inits.isInitialized("employee") ? new QEmployee(forProperty("employee")) : null;
        this.id = inits.isInitialized("id") ? new QEmployeeDepartmentId(forProperty("id")) : null;
    }

}

