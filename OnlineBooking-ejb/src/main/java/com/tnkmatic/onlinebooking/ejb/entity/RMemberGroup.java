/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eiichi
 */
@Entity
@Table(name = "r_member_group", catalog = "onlinebooking", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RMemberGroup.findAll", query = "SELECT r FROM RMemberGroup r"),
    @NamedQuery(name = "RMemberGroup.findByMemberMemberId", query = "SELECT r FROM RMemberGroup r WHERE r.rMemberGroupPK.memberMemberId = :memberMemberId"),
    @NamedQuery(name = "RMemberGroup.findByMemberKbn", query = "SELECT r FROM RMemberGroup r WHERE r.rMemberGroupPK.memberKbn = :memberKbn")})
public class RMemberGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RMemberGroupPK rMemberGroupPK;

    public RMemberGroup() {
    }

    public RMemberGroup(RMemberGroupPK rMemberGroupPK) {
        this.rMemberGroupPK = rMemberGroupPK;
    }

    public RMemberGroup(int memberMemberId, Character memberKbn) {
        this.rMemberGroupPK = new RMemberGroupPK(memberMemberId, memberKbn);
    }

    public RMemberGroupPK getRMemberGroupPK() {
        return rMemberGroupPK;
    }

    public void setRMemberGroupPK(RMemberGroupPK rMemberGroupPK) {
        this.rMemberGroupPK = rMemberGroupPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rMemberGroupPK != null ? rMemberGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RMemberGroup)) {
            return false;
        }
        RMemberGroup other = (RMemberGroup) object;
        if ((this.rMemberGroupPK == null && other.rMemberGroupPK != null) || (this.rMemberGroupPK != null && !this.rMemberGroupPK.equals(other.rMemberGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.RMemberGroup[ rMemberGroupPK=" + rMemberGroupPK + " ]";
    }
    
}
