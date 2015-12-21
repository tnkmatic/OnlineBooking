/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.entity;

import com.tnkmatic.onlinebooking.ejb.entity.embeddable.SystemDate;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "RMemberMemberGroup.findByMemberId", query = "SELECT r FROM RMemberMemberGroup r WHERE r.memberId = :memberId"),
    @NamedQuery(name = "RMemberMemberGroup.findByMemberGroupKbn", query = "SELECT r FROM RMemberMemberGroup r WHERE r.memberGroupKbn = :memberGroupKbn"),
    @NamedQuery(name = "RMemberMemberGroup.findByInsDate", query = "SELECT r FROM RMemberMemberGroup r WHERE r.systemDate.insDate = :insDate"),
    @NamedQuery(name = "RMemberMemberGroup.findByUpdDate", query = "SELECT r FROM RMemberMemberGroup r WHERE r.systemDate.updDate = :updDate")})
public class RMemberMemberGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBER_ID")
    private int memberId;    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MEMBER_GROUP_KBN")
    private String memberGroupKbn;

    //登録日時・更新日時
    @Embedded
    private SystemDate systemDate;
  
    @ManyToOne
    @JoinColumn(name = "MEMBER_GROUP_KBN", nullable = false, insertable = false, updatable = false)
    private MemberGroup memberGroup;

    public RMemberMemberGroup() {
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

    public SystemDate getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(SystemDate systemDate) {
        this.systemDate = systemDate;
    }

    public MemberGroup getMemberGroup() {
        return memberGroup;
    }

    public void setMemberGroup(MemberGroup memberGroup) {
        this.memberGroup = memberGroup;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.RMemberMemberGroup[ memberId=" + memberId + " ]";
    }
    
    @PrePersist
    public void onPrePersist() {
        systemDate = new SystemDate(new Date());
    }
    
    @PreUpdate
    public void onPreUpdate() {
        systemDate.setUpdDate(new Date());
    }
}
