package curd.application.crud.entity;


import jakarta.persistence.*;
import org.springframework.http.HttpStatus;

import java.util.Objects;

@Entity//it specifies that the class is entity and is mapped to a database table
public class Employee {
    @Id//primary key attribute is empid
    @GeneratedValue(strategy = GenerationType.AUTO)//primary key value will be automatically generated
    @Column(name="id")//it is used to specify the mapped column for database
    private int id;
    @Column(name="email")
    private String email;
    @Column(name="departmentId")
    private int departmentId;
    @Column(name="departmentName")
    private String departmentName;
    @Column(name="salary")
    private double salary;
    @Column(name="designation")
    private String designation;
    @Column(name="name")
    private String name;

    public Employee(int empId, String email, int departmentId, String departmentName, double salary, String designation, String name) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.salary = salary;
        this.designation = designation;
    }

    public Employee() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {//to get string representation of a java object
        return "Employee{" +
                "empId=" + id +
                ", name='" +name + '\''+
                ", email='" + email + '\'' +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                '}';
    }
}