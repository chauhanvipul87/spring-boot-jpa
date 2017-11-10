package com.iana.sdata.domain;

/**
 * Created by Vrajesh Jayswal on 11/3/2017.
 */
public class EmployeeDetails {

    private Long empId;
    private String empName;
    private String street;
    private String city;

    public EmployeeDetails(Long empId, String empName, String street, String city) {
        this.empId = empId;
        this.empName = empName;
        this.street = street;
        this.city = city;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
