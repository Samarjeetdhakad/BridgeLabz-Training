package com.payroll.service.department;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.payroll.dto.department.DepartmentRequestDTO;
import com.payroll.dto.department.DepartmentResponseDTO;
import com.payroll.entity.Department;
import com.payroll.exception.DepartmentNotFoundException;
import com.payroll.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponseDTO createDepartment( DepartmentRequestDTO request) {

        Department department = new Department();

        department.setName(request.getName());
        department.setDescription(request.getDescription());
        Department savedDepartment = departmentRepository.save(department);

        return mapToResponseDTO(savedDepartment);
    }

    @Override
    public Page<DepartmentResponseDTO> getAllDepartments(int page, int size, String sortby, String direction) {

    	Sort sort;
    	
    	if(direction.equalsIgnoreCase("asc")) {
    		sort = Sort.by(sortby).ascending();
    	}
    	else {
    		sort = Sort.by(sortby).descending();
    	}
    	Pageable pageable = PageRequest.of(page, size, sort);
       Page<Department> department = departmentRepository.findAll(pageable);

        return department.map(this::mapToResponseDTO);
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException( "Department not found with id: " + id));
        return mapToResponseDTO(department);
    }

    @Override
    public DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO request) {

        Department department = departmentRepository.findById(id).orElseThrow(() ->
                        new DepartmentNotFoundException( "Department not found with id: " + id ));

        department.setName(request.getName());
        department.setDescription(request.getDescription());
        Department updatedDepartment = departmentRepository.save(department);
        return mapToResponseDTO(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id) .orElseThrow(() ->
                        new DepartmentNotFoundException("Department not found with id: " + id ));
        departmentRepository.delete(department);
    }

    private DepartmentResponseDTO mapToResponseDTO(Department department) {

        DepartmentResponseDTO response =  new DepartmentResponseDTO();
        
        response.setId(department.getId());
        response.setName(department.getName());
        response.setDescription(department.getDescription());

        return response;
    }
}