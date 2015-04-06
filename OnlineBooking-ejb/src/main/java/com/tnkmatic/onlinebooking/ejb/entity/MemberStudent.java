/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eiichi
 */
@Entity
@Table(name = "member_student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberStudent.findAll", query = "SELECT m FROM MemberStudent m"),
    @NamedQuery(name = "MemberStudent.findByMemberId", query = "SELECT m FROM MemberStudent m WHERE m.memberId = :memberId"),
    @NamedQuery(name = "MemberStudent.findByInsDate", query = "SELECT m FROM MemberStudent m WHERE m.insDate = :insDate"),
    @NamedQuery(name = "MemberStudent.findByUpdDate", query = "SELECT m FROM MemberStudent m WHERE m.updDate = :updDate")})
public class MemberStudent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBER_ID")
    private Integer memberId;
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

    public MemberStudent() {
    }

    public MemberStudent(Integer memberId) {
        this.memberId = memberId;
    }

    public MemberStudent(Integer memberId, Date insDate, Date updDate) {
        this.memberId = memberId;
        this.insDate = insDate;
        this.updDate = updDate;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberId != null ? memberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberStudent)) {
            return false;
        }
        MemberStudent other = (MemberStudent) object;
        if ((this.memberId == null && other.memberId != null) || (this.memberId != null && !this.memberId.equals(other.memberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.MemberStudent[ memberId=" + memberId + " ]";
    }
    
}
