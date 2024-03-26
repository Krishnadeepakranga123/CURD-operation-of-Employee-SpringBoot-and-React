package org.mk.Employee.Controller;

import java.util.List;

import org.mk.Employee.EmployeeService.EmployeeService;
import org.mk.Employee.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	//Add Employee RestAPI
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto saveEmployee=employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(saveEmployee,HttpStatus.CREATED);
	}
	//Get Employee RestAPI
		@GetMapping(value = "/{id}")
		public ResponseEntity<EmployeeDto> getEmployee(@PathVariable(name="id") int employeeId){
			EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
			return new ResponseEntity<>(employeeDto,HttpStatus.OK);
		}
		
		//Get All Employee restApi
		@GetMapping
		public ResponseEntity<List<EmployeeDto> >getAllEmployee(){
			List<EmployeeDto> employees=employeeService.getAllEmployee();
			return new ResponseEntity<>(employees,HttpStatus.OK);
		}
		
		//Update employee RestAPI
		@PutMapping(value="/{id}")
		public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable( name="id") int employeeId,
				                                         @RequestBody EmployeeDto updateEmployee){
			EmployeeDto employeeDto=employeeService.updateEmployee(employeeId, updateEmployee);
			return new ResponseEntity<>(employeeDto,HttpStatus.OK);
		}
		
		//Delete Employee RestApI
		@DeleteMapping(value="/{id}")
		public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") int employeeId){
			employeeService.deleteEmployee(employeeId);
			return new ResponseEntity<>("Employee deleted Successfully",HttpStatus.OK);
		}

	

}
