package org.mk.Employee.EmployeeMapper;

import org.mk.Employee.Entity.Employee;
import org.mk.Employee.dto.EmployeeDto;

public class EmployeeMapper {
	public static EmployeeDto MapToEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail());
	}
public static Employee MapToEmployee(EmployeeDto employeeDto) {
	return new Employee(employeeDto.getId(),
			employeeDto.getFirstName(),
			employeeDto.getLastName(),
			employeeDto.getEmail());
		
	}
}
