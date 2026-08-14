package com.payroll.service.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.payroll.dto.employee.EmployeeRequestDTO;
import com.payroll.dto.employee.EmployeeResponseDTO;
import com.payroll.dto.employee.EmployeeSalaryUpdateDTO;
import com.payroll.entity.Department;
import com.payroll.entity.Employee;
import com.payroll.exception.DepartmentNotFoundException;
import com.payroll.exception.EmployeeNotFoundException;
import com.payroll.repository.DepartmentRepository;
import com.payroll.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO request) {
    	
        Department department = departmentRepository.findById(request.getDepartmentId())
                        .orElseThrow(() -> new DepartmentNotFoundException( "Department not found with id: "
                                           + request.getDepartmentId()
                                ));

        Employee employee = new Employee();
        
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setSalary(request.getSalary());
        employee.setDepartment(department);

        Employee savedEmployee =employeeRepository.save(employee);
        return mapToResponseDTO(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException( "Employee not found with id: " + id ));

        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeResponseDTO updateSalary(  Long id, EmployeeSalaryUpdateDTO request) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found with id: " + id));

        employee.setSalary(request.getSalary());

        Employee updatedEmployee = employeeRepository.save(employee);

        return mapToResponseDTO(updatedEmployee);
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByDepartment( Long departmentId) {

        Department department = departmentRepository.findById(departmentId).orElseThrow(() ->
                                new DepartmentNotFoundException( "Department not found with id: "+ departmentId ));

        List<Employee> employees = employeeRepository.findByDepartmentId( department.getId());
        List<EmployeeResponseDTO> response = new ArrayList<>();
        for (Employee employee : employees) {
            response.add(mapToResponseDTO(employee));
        }
        return response;
    }

    private EmployeeResponseDTO mapToResponseDTO(Employee employee) {

        EmployeeResponseDTO response = new EmployeeResponseDTO();

        response.setId(employee.getId());
        response.setName(employee.getName());
        response.setEmail(employee.getEmail());
        response.setPhone(employee.getPhone());
        response.setSalary(employee.getSalary());

        if (employee.getDepartment() != null) {
            response.setDepartmentId(
                    employee.getDepartment().getId()
            );
        }

        return response;
    }
}