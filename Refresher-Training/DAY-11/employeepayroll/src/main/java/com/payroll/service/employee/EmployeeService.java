package com.payroll.service.employee;

import java.util.List;

import org.springframework.data.domain.Page;

import com.payroll.dto.employee.EmployeeRequestDTO;
import com.payroll.dto.employee.EmployeeResponseDTO;
import com.payroll.dto.employee.EmployeeSalaryUpdateDTO;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee( EmployeeRequestDTO request);

    void deleteEmployee(Long id);

    EmployeeResponseDTO updateSalary( Long id,EmployeeSalaryUpdateDTO request);

    List<EmployeeResponseDTO> getEmployeesByDepartment(Long departmentId);

	Page<EmployeeResponseDTO> getAllEmployees(int page, int size, String sortBy, String direction);
	
	EmployeeResponseDTO getEmployeeByEmail(String email);
}