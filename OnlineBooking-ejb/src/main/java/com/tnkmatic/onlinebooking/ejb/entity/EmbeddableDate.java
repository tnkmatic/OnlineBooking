/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.entity;

import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author tnkmatic@outlook.jp
 */
@Embeddable
@Access(AccessType.FIELD)
public class EmbeddableDate {
    @Basic(optional = false)
    @NotNull
    @Column(name = "INS_DATE")
    @Temporal(TemporalType.DATE)
    private Date insDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPD_DATE")
    @Temporal(TemporalType.DATE)
    private Date updDate;
    
    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }
    
    public void persistEmbeddableDate() {
        Date persistDate  = new Date();
        this.insDate = persistDate;
        this.updDate = persistDate;
    }
    
    public void updateEmbeddableDate() {
        Date updateDate  = new Date();
        this.updDate = updateDate;
    }
}
