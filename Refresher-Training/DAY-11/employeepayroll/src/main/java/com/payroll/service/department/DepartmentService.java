package com.payroll.service.department;



import org.springframework.data.domain.Page;

import com.payroll.dto.department.DepartmentRequestDTO;
import com.payroll.dto.department.DepartmentResponseDTO;


public interface DepartmentService {

    DepartmentResponseDTO createDepartment(DepartmentRequestDTO request);

    Page<DepartmentResponseDTO> getAllDepartments(int page, int size, String sortby, String direction);

    DepartmentResponseDTO getDepartmentById(Long id);

    DepartmentResponseDTO updateDepartment( Long id, DepartmentRequestDTO request);

    void deleteDepartment(Long id);
}