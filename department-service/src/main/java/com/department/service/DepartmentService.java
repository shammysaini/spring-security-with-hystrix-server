package com.department.service;

import com.department.entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);
	Department findDepartmentById(Long departmentId);

}
