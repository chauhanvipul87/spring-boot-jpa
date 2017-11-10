package com.iana.sdata.service;


import com.iana.sdata.domain.Employee;
import com.iana.sdata.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository emp;

    @Transactional
    @Override
    public Employee findOne(Long id) throws Exception {
        return emp.findOne(id);
    }

}
