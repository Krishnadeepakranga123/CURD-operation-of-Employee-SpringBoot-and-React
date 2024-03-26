package org.mk.Employee.EmployeeService;

import java.util.List;

import org.mk.Employee.dto.EmployeeDto; 

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);

	EmployeeDto getEmployeeById(int employeeId);

	List<EmployeeDto> getAllEmployee();

	EmployeeDto updateEmployee(int employeeId, EmployeeDto updateEmployee);

	void deleteEmployee(int employeeId);

}
