package com.payroll.repository;
import org.springframework.data.repository.CrudRepository;

import com.payroll.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

}