package com.payroll.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.payroll.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByDepartmentId(Long departmentId);
	//boolean findByEmail(String email);
}