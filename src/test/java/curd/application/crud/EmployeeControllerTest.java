package curd.application.crud;

import curd.application.crud.controller.EmployeeController;
import curd.application.crud.entity.Employee;
import curd.application.crud.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
public class EmployeeControllerTest {
	@Mock
	private EmployeeService employeeService;
	private EmployeeController employeeController;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		employeeController = new EmployeeController(employeeService);
	}
	@Test
	public void testSaveEmployee() {
// Create a sample employee
		Employee sampleEmployee = new Employee(1,"john.doe@example.com", 1, "Developer", 5000, "IT", "John Doe");
// Mock the behavior of the employeeService.saveEmployee() method
		Mockito.when(employeeService.saveEmployee(Mockito.any(Employee.class))).thenReturn(sampleEmployee);

// Call the saveEmployee() method of the employeeAPI
		Employee result = employeeController.saveEmployee(sampleEmployee);
// Verify that the employeeService.saveEmployee() method was called with the correct employee
		Mockito.verify(employeeService).saveEmployee(sampleEmployee);
		Assertions.assertEquals(sampleEmployee, result);
	}
	@Test
	public void testFindEmployeeById() {
// Create a sample employee
		Employee sampleEmployee = new Employee(1,"john.doe@example.com", 1, "Developer", 5000, "IT", "John Doe");
		Mockito.when(employeeService.findById(Mockito.anyInt())).thenReturn(sampleEmployee);

// Call the findById() method of the employeeAPI
		Employee result = employeeController.findById(1);
// Verify that the returned employee matches the sample employee
		Assertions.assertEquals(sampleEmployee, result);
	}
	@Test
	public void testFindBySalary() {

		Employee employee1 = new Employee(2,"john.doe@example.com", 1, "Developer", 5000, "IT", "John Doe");
		Employee employee2 = new Employee(3,"pragati@example.com", 2, "Developer1", 2000, "IT", "Pragati");
		Mockito.when(employeeService.getEmployeesBySalary(Mockito.anyInt())).thenReturn(List.of(employee1, employee2));

// Call the findBySalary() method of the employeeAPI
		List<Employee> result = employeeController.findBySalary(6000);

// Verify that the employeeService.getEmployeesBySalary() method was called with the correct salary
		Mockito.verify(employeeService).getEmployeesBySalary(6000);

// Verify that the returned employees match the expected employees
		Assertions.assertEquals(List.of(employee1, employee2), result);
	}
	@Test
	public void testFindByName() {

		Employee employee1 = new Employee(2,"john.doe@example.com", 1, "Developer", 5000, "IT", "John Doe");
		Employee employee2 = new Employee(3,"john.doe@example.com", 2, "Developer1", 2000, "IT", "John Doe");
		Mockito.when(employeeService.getEmployeesByName(Mockito.anyString())).thenReturn(List.of(employee1, employee2));

// Call the findBySalary() method of the employeeAPI
		List<Employee> result = employeeController.findByName("John Doe");

// Verify that the employeeService.getEmployeesBySalary() method was called with the correct salary
		Mockito.verify(employeeService).getEmployeesByName("John Doe");

// Verify that the returned employees match the expected employees
		Assertions.assertEquals(List.of(employee1, employee2), result);
	}
	@Test
	public void testUpdateEmployee() {
// Create a sample employee
		Employee existingEmployee = new Employee(1,"john.doe@example.com", 1, "Developer", 5000, "IT", "John Doe");
		Employee updatedEmployee = new Employee(1,"john.doe@example.com", 1, "Senior Developer", 6000, "IT", "John Doe");

// Mock the behavior of the employeeService.updateEmployee() method
		Mockito.when(employeeService.updateEmployee(Mockito.anyInt(), Mockito.any(Employee.class))).thenReturn(updatedEmployee);

// Call the update() method of the employeeAPI
		Employee result = employeeController.update(1, updatedEmployee);

// Verify that the employeeService.updateEmployee() method was called with the correct ID and employee
		Mockito.verify(employeeService).updateEmployee(1, updatedEmployee);

// Verify that the returned employee matches the updated employee
		Assertions.assertEquals(updatedEmployee, result);
	}

	@Test
	public void testDeleteEmployee() {
		Employee sampleEmployee = new Employee(1,"john.doe@example.com", 1, "Developer", 5000, "IT", "John Doe");
		String result = employeeController.deleteEmployee(1);
// Verify that the employeeService.delete() method was called with the correct ID
		Mockito.verify(employeeService).delete(1);
// Verify that the returned message is as expected
		Assertions.assertEquals(null, result);
	}

}

