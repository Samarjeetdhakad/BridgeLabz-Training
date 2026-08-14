package com.payroll.service.department;

import java.util.List;

import com.payroll.dto.department.DepartmentRequestDTO;
import com.payroll.dto.department.DepartmentResponseDTO;


public interface DepartmentService {

    DepartmentResponseDTO createDepartment(DepartmentRequestDTO request);

    List<DepartmentResponseDTO> getAllDepartments();

    DepartmentResponseDTO getDepartmentById(Long id);

    DepartmentResponseDTO updateDepartment( Long id, DepartmentRequestDTO request);

    void deleteDepartment(Long id);
}