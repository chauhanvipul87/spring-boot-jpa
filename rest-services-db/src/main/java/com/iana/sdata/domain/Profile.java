package com.iana.sdata.domain;

import javax.persistence.*;
import java.util.Set;
/**
 * Created by Vrajesh Jayswal on 11/2/2017.
 */
@Entity
@Table(name="profile")
public class Profile {

    @Id
    @GeneratedValue
    @Column(name="SIP_ID")
    private Long sipId;

    @Column(name="COMPANY_NAME")
    private String companyName;

    @Column(name="UIIA_USER_TYPE")
    private String uiiaUserType;


    public Long getSipId() {
        return sipId;
    }

    public void setSipId(Long sipId) {
        this.sipId = sipId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUiiaUserType() {
        return uiiaUserType;
    }

    public void setUiiaUserType(String uiiaUserType) {
        this.uiiaUserType = uiiaUserType;
    }


}

