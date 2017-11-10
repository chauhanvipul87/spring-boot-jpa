package com.iana.sdata.repository;


import com.iana.sdata.domain.Config;
import com.iana.sdata.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface ConfigRepository extends JpaRepository<Config,Long> {

}
