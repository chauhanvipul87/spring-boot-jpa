package com.iana.sdata.repository;


import com.iana.sdata.domain.Employee;
import com.iana.sdata.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

//@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
