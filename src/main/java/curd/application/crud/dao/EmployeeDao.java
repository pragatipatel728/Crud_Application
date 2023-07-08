package curd.application.crud.dao;


import curd.application.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDao extends JpaRepository <Employee, Integer> {//JPARepository contain full api of crud repository

    List<Employee> findByName(String empName);
    List<Employee> findBySalary(Integer empSalary);


}