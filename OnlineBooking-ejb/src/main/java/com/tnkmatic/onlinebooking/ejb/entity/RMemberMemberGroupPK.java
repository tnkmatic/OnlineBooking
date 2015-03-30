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
import javax.validation.constraints.Size;

/**
 *
 * @author Eiichi
 */
@Embeddable
public class RMemberMemberGroupPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBER_ID")
    private int memberId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MEMBER_GROUP_KBN")
    private String memberGroupKbn;

    public RMemberMemberGroupPK() {
    }

    public RMemberMemberGroupPK(int memberId, String memberGroupKbn) {
        this.memberId = memberId;
        this.memberGroupKbn = memberGroupKbn;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberGroupKbn() {
        return memberGroupKbn;
    }

    public void setMemberGroupKbn(String memberGroupKbn) {
        this.memberGroupKbn = memberGroupKbn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) memberId;
        hash += (memberGroupKbn != null ? memberGroupKbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RMemberMemberGroupPK)) {
            return false;
        }
        RMemberMemberGroupPK other = (RMemberMemberGroupPK) object;
        if (this.memberId != other.memberId) {
            return false;
        }
        if ((this.memberGroupKbn == null && other.memberGroupKbn != null) || (this.memberGroupKbn != null && !this.memberGroupKbn.equals(other.memberGroupKbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.RMemberMemberGroupPK[ memberId=" + memberId + ", memberGroupKbn=" + memberGroupKbn + " ]";
    }
    
}
