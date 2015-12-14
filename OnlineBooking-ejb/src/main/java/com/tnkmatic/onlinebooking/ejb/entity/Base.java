/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author tnkmatic@outlook.jp
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class Base {
    @Basic(optional = false)
    @NotNull
    @Column(name = "INS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date insDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updDate;

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
    
    protected void persistEmbeddableDate() {
        Date persistDate  = new Date();
        this.insDate = persistDate;
        this.updDate = persistDate;
    }
    
    protected void updateEmbeddableDate() {
        Date updateDate  = new Date();
        this.updDate = updateDate;
    }
}
