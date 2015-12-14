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
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eiichi
 */
@Entity
@Table(name = "member_teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberTeacher.findAll", query = "SELECT m FROM MemberTeacher m"),
    @NamedQuery(name = "MemberTeacher.findByMemberId", query = "SELECT m FROM MemberTeacher m WHERE m.memberId = :memberId"),
    @NamedQuery(name = "MemberTeacher.findByEmployKbn", query = "SELECT m FROM MemberTeacher m WHERE m.employKbn = :employKbn"),
    @NamedQuery(name = "MemberTeacher.findByEmployYmdFrom", query = "SELECT m FROM MemberTeacher m WHERE m.employYmdFrom = :employYmdFrom"),
    @NamedQuery(name = "MemberTeacher.findByEmployYmdTo", query = "SELECT m FROM MemberTeacher m WHERE m.employYmdTo = :employYmdTo"),
    @NamedQuery(name = "MemberTeacher.findByInsDate", query = "SELECT m FROM MemberTeacher m WHERE m.insDate = :insDate"),
    @NamedQuery(name = "MemberTeacher.findByUpdDate", query = "SELECT m FROM MemberTeacher m WHERE m.updDate = :updDate")})
public class MemberTeacher extends Base implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBER_ID")
    private Integer memberId;
    @Basic(optional = false)
    @Size(min = 1, max = 1)
    @Column(name = "EMPLOY_KBN")
    private String employKbn;
    @Basic(optional = false)
    @Column(name = "EMPLOY_YMD_FROM")
    @Temporal(TemporalType.DATE)
    private Date employYmdFrom;
    @Basic(optional = false)
    @Column(name = "EMPLOY_YMD_TO")
    @Temporal(TemporalType.DATE)
    private Date employYmdTo;

    public MemberTeacher() {
    }

    public MemberTeacher(Integer memberId) {
        this.memberId = memberId;
    }

    public MemberTeacher(Integer memberId, String employKbn, Date employYmdFrom, Date employYmdTo, Date insDate, Date updDate) {
        this.memberId = memberId;
        this.employKbn = employKbn;
        this.employYmdFrom = employYmdFrom;
        this.employYmdTo = employYmdTo;
        this.insDate = insDate;
        this.updDate = updDate;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getEmployKbn() {
        return employKbn;
    }

    public void setEmployKbn(String employKbn) {
        this.employKbn = employKbn;
    }

    public Date getEmployYmdFrom() {
        return employYmdFrom;
    }

    public void setEmployYmdFrom(Date employYmdFrom) {
        this.employYmdFrom = employYmdFrom;
    }

    public Date getEmployYmdTo() {
        return employYmdTo;
    }

    public void setEmployYmdTo(Date employYmdTo) {
        this.employYmdTo = employYmdTo;
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
        if (!(object instanceof MemberTeacher)) {
            return false;
        }
        MemberTeacher other = (MemberTeacher) object;
        if ((this.memberId == null && other.memberId != null) || (this.memberId != null && !this.memberId.equals(other.memberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.MemberTeacher[ memberId=" + memberId + " ]";
    }
    
    @PrePersist
    public void onPrePersist() {
        persistEmbeddableDate();
    }
    
    @PreUpdate
    public void onPreUpdate() {
        updateEmbeddableDate();
    }    
}
