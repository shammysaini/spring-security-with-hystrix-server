package com.department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.entity.Department;
import com.department.repository.DepartmentRepository;
import com.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository; 

	@Override
	public Department saveDepartment(Department department) {
		log.info("Enter in saveDepartment method present in DepartmentServiceImpl ");
		return departmentRepository.save(department);

	}

	@Override
	public Department findDepartmentById(Long departmentId) {
		log.info("Enter in findDepartmentById method present in DepartmentServiceImpl ");
		return departmentRepository.findByDepartmentId(departmentId);
		
	}

}
