package com.iana.sdata.domain;

/**
 * Created by Vrajesh Jayswal on 11/1/2017.
 */
import java.util.Set;

import javax.persistence.*;
@SqlResultSetMapping(name="EmployeeDetailsMapping",
        classes = {
                @ConstructorResult(targetClass = EmployeeDetails.class,
                        columns = {@ColumnResult(name="empId"), @ColumnResult(name="empName"),@ColumnResult(name="street"), @ColumnResult(name="city")}
                )}
)
@Entity
@Table(name="EMPLOYEE")
public class Employee
{
    @Id
    @GeneratedValue
    @Column(name="EMP_ID")
    private Long empId;

    @Column(name="NAME")
    private String empName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMP_ID")
    private Set<Employee_Address> employeeAddress;

    public Employee()
    {
        super();
    }

    public Employee(Long empId, String empName, Set<Employee_Address> employeeAddress)
    {
        super();
        this.empId = empId;
        this.empName = empName;
        this.employeeAddress = employeeAddress;
    }

    public Long getEmpId()
    {
        return empId;
    }

    public void setEmpId(Long empId)
    {
        this.empId = empId;
    }

    public String getEmpName()
    {
        return empName;
    }

    public void setEmpName(String empName)
    {
        this.empName = empName;
    }

    public Set<Employee_Address> getEmployeeAddress()
    {
        return employeeAddress;
    }

    public void setEmployeeAddress(Set<Employee_Address> employeeAddress)
    {
        this.employeeAddress = employeeAddress;

    }

    @Override
    public String toString()
    {
        return "Employee [empId=" + empId + ", empName=" + empName + "]";
    }
}