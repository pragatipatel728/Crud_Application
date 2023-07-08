package curd.application.crud.service;

import curd.application.crud.dao.EmployeeDao;
import curd.application.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service//it perform functions in spring boot application
public class EmployeeService {
    @Autowired//
    private EmployeeDao employeeDao;//i have auto wired employeeDao in EmployeeService

    public List<Employee> getAllEmployee() {

        return employeeDao.findAll();
    }

    public Employee saveEmployee(Employee emp) {
        return employeeDao.save(emp);
    }

    public Employee findById(Integer id) {
        return employeeDao.getById(id);
    }
    public List<Employee> getEmployeesByName(String empName) {

        return employeeDao.findByName(empName);
    }
    public List<Employee> getEmployeesBySalary(Integer empSalary) {

        return employeeDao.findBySalary(empSalary);
    }

    public Employee updateEmployee(int empId,Employee employee) {
        Employee updateEmp = employeeDao.getById(empId);
        if (updateEmp!=null) {
            updateEmp.setName(employee.getName());
            updateEmp.setEmail(employee.getEmail());
            updateEmp.setDepartmentId(employee.getDepartmentId());
            updateEmp.setDepartmentName(employee.getDepartmentName());
            updateEmp.setSalary(employee.getSalary());
            updateEmp.setDesignation(employee.getDesignation());
            return employeeDao.save(updateEmp);
        } else {
            return null;
        }
    }
    public String delete(Integer id){
        try {
            Employee emp = employeeDao.getById(id);
            employeeDao.delete(emp);
            return "Deleting Employee "+emp;
        }
        catch (Exception e){
            return "Employee does't exist so unable to delete";
        }

    }
}