package com.iana.sdata.domain;

/**
 * Created by Vrajesh Jayswal on 11/1/2017.
 */

import javax.persistence.*;


@Entity
@Table(name="EMPLOYEE_ADDRESS")
public class Employee_Address
{
    @Id
    @Column(name = "ADDR_ID")
    @GeneratedValue
    private Long addrId;

    @Column(name="STREET")
    private String street;
    @Column(name="CITY")
    private String city;


    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "EMP_ID", nullable = false)
    private Employee employee;

    public Employee_Address()
    {
        super();
    }

    public Employee_Address(Long addrId, String street, String city, String state, String country, Employee employee)
    {
        super();
        this.addrId = addrId;
        this.street = street;
        this.city = city;

        this.employee = employee;
    }

    public Long getAddrId()
    {
        return addrId;
    }

    public void setAddrId(Long addrId)
    {
        this.addrId = addrId;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }


    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
}