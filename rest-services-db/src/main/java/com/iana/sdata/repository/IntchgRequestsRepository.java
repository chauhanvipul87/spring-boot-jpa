package com.iana.sdata.repository;


import com.iana.sdata.domain.Employee;
import com.iana.sdata.domain.IntchgRequests;
import com.iana.sdata.domain.Person;
import com.iana.sdata.domain.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@RepositoryRestResource
public interface IntchgRequestsRepository extends JpaRepository<IntchgRequests,Long> {
    List<IntchgRequests> findIntchgRequestsByIrId(@Param("irId") Long irId);
}
