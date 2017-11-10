package com.iana.sdata.domain;

import javax.persistence.*;
/**
 * Created by Vrajesh Jayswal on 11/2/2017.
 */
@Entity
@Table(name="config")
public class Config {

    @Id
    @GeneratedValue
    @Column(name="C_ID")
    private Long cId;

    @Column(name="SENDER_ID")
    private String senderId;

    @Column(name="TRAN_TYPE")
    private String tranType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SIP_ID")
    private Profile profile;

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}

