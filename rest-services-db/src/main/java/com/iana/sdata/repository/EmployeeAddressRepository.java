package com.iana.sdata.repository;


import com.iana.sdata.domain.Employee;
import com.iana.sdata.domain.Employee_Address;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
@Resource
@Transactional
public interface EmployeeAddressRepository extends JpaRepository<Employee_Address,Long> {


}
