package com.payroll.service.employee;

import java.util.List;

import com.payroll.dto.employee.EmployeeRequestDTO;
import com.payroll.dto.employee.EmployeeResponseDTO;
import com.payroll.dto.employee.EmployeeSalaryUpdateDTO;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee( EmployeeRequestDTO request);

    void deleteEmployee(Long id);

    EmployeeResponseDTO updateSalary( Long id,EmployeeSalaryUpdateDTO request);

    List<EmployeeResponseDTO> getEmployeesByDepartment(Long departmentId);
}