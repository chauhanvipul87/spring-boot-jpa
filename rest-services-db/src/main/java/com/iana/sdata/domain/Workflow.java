package com.iana.sdata.domain;

import javax.persistence.*;

/**
 * Created by Vrajesh Jayswal on 11/2/2017.
 */

@Entity
@Table(name="WORKFLOW")
public class Workflow {

    @Id
    @GeneratedValue
    @Column(name="WF_ID")
    private Long wfId;

    @Column(name="ACTION")
    private String action;

    @Column(name="REQ_TYPE")
    private String reqType;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "IR_ID")
    private IntchgRequests intchgRequests;

    public Workflow()
    {
        super();
    }

    public Workflow(Long wfId, String action, String reqType, IntchgRequests intchgRequests)
    {
        super();
        this.wfId = wfId;
        this.action = action;
        this.reqType = reqType;
        this.intchgRequests = intchgRequests;
    }

    public Long getWfId() {
        return wfId;
    }

    public void setWfId(Long wfId) {
        this.wfId = wfId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public IntchgRequests getIntchgRequests() {
        return intchgRequests;
    }

    public void setIntchgRequests(IntchgRequests intchgRequests) {
        this.intchgRequests = intchgRequests;
    }
}
