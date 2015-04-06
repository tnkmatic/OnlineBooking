/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eiichi
 */
@Entity
@Table(name = "member_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberGroup.findAll", query = "SELECT m FROM MemberGroup m"),
    @NamedQuery(name = "MemberGroup.findByMemberGroupKbn", query = "SELECT m FROM MemberGroup m WHERE m.memberGroupKbn = :memberGroupKbn"),
    @NamedQuery(name = "MemberGroup.findByMemberGroupName", query = "SELECT m FROM MemberGroup m WHERE m.memberGroupName = :memberGroupName")})
public class MemberGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MEMBER_GROUP_KBN")
    private String memberGroupKbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MEMBER_GROUP_NAME")
    private String memberGroupName;

    public MemberGroup() {
    }

    public MemberGroup(String memberGroupKbn) {
        this.memberGroupKbn = memberGroupKbn;
    }

    public MemberGroup(String memberGroupKbn, String memberGroupName) {
        this.memberGroupKbn = memberGroupKbn;
        this.memberGroupName = memberGroupName;
    }

    public String getMemberGroupKbn() {
        return memberGroupKbn;
    }

    public void setMemberGroupKbn(String memberGroupKbn) {
        this.memberGroupKbn = memberGroupKbn;
    }

    public String getMemberGroupName() {
        return memberGroupName;
    }

    public void setMemberGroupName(String memberGroupName) {
        this.memberGroupName = memberGroupName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberGroupKbn != null ? memberGroupKbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberGroup)) {
            return false;
        }
        MemberGroup other = (MemberGroup) object;
        if ((this.memberGroupKbn == null && other.memberGroupKbn != null) || (this.memberGroupKbn != null && !this.memberGroupKbn.equals(other.memberGroupKbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.MemberGroup[ memberGroupKbn=" + memberGroupKbn + " ]";
    }
    
}
