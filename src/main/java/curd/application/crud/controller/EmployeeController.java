package curd.application.crud.controller;

import curd.application.crud.entity.Employee;
import curd.application.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//it is used to build rest api in declarative ways
@RequestMapping("/employee")//it is used to map web requests onto specific classes or methods and make web resources addressable
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
//this method works as @Autowiring so here we can use Employee service class

    @GetMapping("/all")//for mapping http get requests onto specific handler method
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    @PostMapping("/createEmployee")//handles the http post requests
    public Employee saveEmployee(@RequestBody Employee emp){//maps the http request body to a transfer object
        return employeeService.saveEmployee(emp);

    }

    @GetMapping("/{id}")

    public Employee findById(@PathVariable Integer id)//in this url contains some value
    {
        return employeeService.findById(id);
    }
    @GetMapping(params = "name")
    public List<Employee> findByName(@RequestParam String name)//to get query parameters
    {
        return employeeService.getEmployeesByName(name);
    }
    @GetMapping(params = "salary")
    public List<Employee> findBySalary(@RequestParam Integer salary){
        return employeeService.getEmployeesBySalary(salary);
    }
    @PutMapping("/{id}")
    public Employee update(@PathVariable Integer id, @RequestBody Employee updateEmployee) {
        return employeeService.updateEmployee(id,updateEmployee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employeeService.delete(id);
    }
}


