package com.iana.sdata.repository;


import com.iana.sdata.domain.Book;
import com.iana.sdata.domain.Config;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book,Long> {

}
