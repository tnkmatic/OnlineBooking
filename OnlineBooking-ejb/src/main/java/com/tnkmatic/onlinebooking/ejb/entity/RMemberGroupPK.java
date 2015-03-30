/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Eiichi
 */
@Embeddable
public class RMemberGroupPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBER_MEMBER_ID")
    private int memberMemberId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBER_KBN")
    private String memberKbn;

    public RMemberGroupPK() {
    }

    public RMemberGroupPK(int memberMemberId, String memberKbn) {
        this.memberMemberId = memberMemberId;
        this.memberKbn = memberKbn;
    }

    public int getMemberMemberId() {
        return memberMemberId;
    }

    public void setMemberMemberId(int memberMemberId) {
        this.memberMemberId = memberMemberId;
    }

    public String getMemberKbn() {
        return memberKbn;
    }

    public void setMemberKbn(String memberKbn) {
        this.memberKbn = memberKbn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) memberMemberId;
        hash += (memberKbn != null ? memberKbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RMemberGroupPK)) {
            return false;
        }
        RMemberGroupPK other = (RMemberGroupPK) object;
        if (this.memberMemberId != other.memberMemberId) {
            return false;
        }
        if ((this.memberKbn == null && other.memberKbn != null) || (this.memberKbn != null && !this.memberKbn.equals(other.memberKbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.RMemberGroupPK[ memberMemberId=" + memberMemberId + ", memberKbn=" + memberKbn + " ]";
    }
    
}
