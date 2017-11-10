package com.iana.sdata.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Vrajesh Jayswal on 11/2/2017.
 */
@Entity
@Table(name="INTCHG_REQUESTS")
public class IntchgRequests {

    @Id
    @GeneratedValue
    @Column(name="IR_ID")
    private Long irId;

    @Column(name="EP_COMPANY_NAME")
    private String epCompanyName;

    @Column(name="INTCHG_TYPE")
    private String intchgType;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "IR_ID")
    private Set<Workflow> workflow;

    public IntchgRequests()
    {
        super();
    }

    public IntchgRequests(Long irId, String epCompanyName, String intchgType, Set<Workflow> workflow)
    {
        super();
        this.irId = irId;
        this.epCompanyName = epCompanyName;
        this.intchgType = intchgType;
        this.workflow = workflow;
    }

    public Long getIrId() {
        return irId;
    }

    public void setIrId(Long irId) {
        this.irId = irId;
    }

    public String getEpCompanyName() {
        return epCompanyName;
    }

    public void setEpCompanyName(String epCompanyName) {
        this.epCompanyName = epCompanyName;
    }

    public String getIntchgType() {
        return intchgType;
    }

    public void setIntchgType(String intchgType) {
        this.intchgType = intchgType;
    }

    public Set<Workflow> getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Set<Workflow> workflow) {
        this.workflow = workflow;
    }
}
