package com.iana.sdata.domain;

import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.*;

/**
 * Created by ianaoffshore on 30-10-2017.
 */
@Entity
@Table(name ="language")
@NoRepositoryBean
public class Language {

    @Id
    @Column(name = "L_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "LANGUAGE_NAME")
    private String languageName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", languageName='" + languageName + '\'' +
                '}';
    }
}



