package com.iana.sdata.repository;


import com.iana.sdata.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findAllByFirstName(@Param("name") String name);

    List<User> findAllByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);


}
