package org.mk.Employee.EmployeeServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.mk.Employee.EmployeeMapper.EmployeeMapper;
import org.mk.Employee.EmployeeService.EmployeeService;
import org.mk.Employee.Entity.Employee;
import org.mk.Employee.Exception.ResourceNotfoundException;
import org.mk.Employee.Repository.EmployeeRepository;
import org.mk.Employee.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee=EmployeeMapper.MapToEmployee(employeeDto);
		Employee saveEmployee=employeeRepository.save(employee);
		return EmployeeMapper.MapToEmployeeDto(saveEmployee);
		
	}

	@Override
	public EmployeeDto getEmployeeById(int employeeId) {
		Employee employee=employeeRepository.findById(employeeId).
				orElseThrow(()-> new ResourceNotfoundException("Employee is not exist with id: "+employeeId));
		return EmployeeMapper.MapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> employees=employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.MapToEmployeeDto(employee)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(int employeeId, EmployeeDto updateEmployee) {
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(
				()-> new ResourceNotfoundException("Employee is not found with employee id "+employeeId));
		employee.setFirstName(updateEmployee.getFirstName());
		employee.setLastName(updateEmployee.getLastName());
		employee.setEmail(updateEmployee.getEmail());
		
		Employee Update=employeeRepository.save(employee);
		return EmployeeMapper.MapToEmployeeDto(Update);
	}
	
	
	
	@Override
	public void deleteEmployee(int employeeId) {
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(()-> new 
				ResourceNotfoundException("Employee is Not Found Exception"+employeeId));
		employeeRepository.delete(employee);
	}

}
