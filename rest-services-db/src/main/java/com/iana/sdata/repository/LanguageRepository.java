package com.iana.sdata.repository;

import com.iana.sdata.domain.Language;
import com.iana.sdata.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


//@RepositoryRestResource
public interface LanguageRepository extends JpaRepository<Language, Long>{

    /* By using blow annotation we should restrict some specific method to export/expose to the world. */
    //@RestResource(exported = false)
    public List<Language> findLanguageByLanguageName(@Param("name") String name);

}
