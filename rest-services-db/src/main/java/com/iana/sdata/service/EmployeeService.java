package com.iana.sdata.service;


import com.iana.sdata.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

public interface EmployeeService {

    Employee findOne(Long id) throws Exception;

}
