package com.iana.sdata.repository;


import com.iana.sdata.domain.Book;
import com.iana.sdata.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
public interface PublisherRepository extends JpaRepository<Publisher,Long> {

}
