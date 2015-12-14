/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eiichi
 */
@Entity
@Table(name = "r_member_member_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RMemberMemberGroup.findAll", query = "SELECT r FROM RMemberMemberGroup r"),
    @NamedQuery(name = "RMemberMemberGroup.findByMemberId", query = "SELECT r FROM RMemberMemberGroup r WHERE r.rMemberMemberGroupPK.memberId = :memberId"),
    @NamedQuery(name = "RMemberMemberGroup.findByMemberGroupKbn", query = "SELECT r FROM RMemberMemberGroup r WHERE r.rMemberMemberGroupPK.memberGroupKbn = :memberGroupKbn"),
    @NamedQuery(name = "RMemberMemberGroup.findByInsDate", query = "SELECT r FROM RMemberMemberGroup r WHERE r.insDate = :insDate"),
    @NamedQuery(name = "RMemberMemberGroup.findByUpdDate", query = "SELECT r FROM RMemberMemberGroup r WHERE r.updDate = :updDate")})
public class RMemberMemberGroup extends Base implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RMemberMemberGroupPK rMemberMemberGroupPK;
    
    @OneToOne
    @JoinColumn(name = "MEMBER_GROUP", nullable = false, insertable = false, updatable = false)
    private RMemberMemberGroup rMemberMemberGroup;
    ここから。、。。、
    
    

    public void setrMemberMemberGroup(RMemberMemberGroup rMemberMemberGroup) {
        this.rMemberMemberGroup = rMemberMemberGroup;
    }

    public RMemberMemberGroup() {
    }
    
    public RMemberMemberGroup(RMemberMemberGroupPK rMemberMemberGroupPK) {
        this.rMemberMemberGroupPK = rMemberMemberGroupPK;
    }

    public RMemberMemberGroup(RMemberMemberGroupPK rMemberMemberGroupPK, Date insDate, Date updDate) {
        this.rMemberMemberGroupPK = rMemberMemberGroupPK;
        this.insDate = insDate;
        this.updDate = updDate;
    }

    public RMemberMemberGroup(int memberId, String memberGroupKbn) {
        this.rMemberMemberGroupPK = new RMemberMemberGroupPK(memberId, memberGroupKbn);
    }

    public RMemberMemberGroupPK getRMemberMemberGroupPK() {
        return rMemberMemberGroupPK;
    }

    public void setRMemberMemberGroupPK(RMemberMemberGroupPK rMemberMemberGroupPK) {
        this.rMemberMemberGroupPK = rMemberMemberGroupPK;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rMemberMemberGroupPK != null ? rMemberMemberGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RMemberMemberGroup)) {
            return false;
        }
        RMemberMemberGroup other = (RMemberMemberGroup) object;
        if ((this.rMemberMemberGroupPK == null && other.rMemberMemberGroupPK != null) || (this.rMemberMemberGroupPK != null && !this.rMemberMemberGroupPK.equals(other.rMemberMemberGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.RMemberMemberGroup[ rMemberMemberGroupPK=" + rMemberMemberGroupPK + " ]";
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
