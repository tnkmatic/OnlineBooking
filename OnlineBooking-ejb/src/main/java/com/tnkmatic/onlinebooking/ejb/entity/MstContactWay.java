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
 * @author tnkmatic@outlook.jp
 */
@Entity
@Table(name = "mst_contact_way")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstContactWay.findAll", query = "SELECT m FROM MstContactWay m"),
    @NamedQuery(name = "MstContactWay.findByContactWayKbn", query = "SELECT m FROM MstContactWay m WHERE m.contactWayKbn = :contactWayKbn"),
    @NamedQuery(name = "MstContactWay.findByContactWayKbnName", query = "SELECT m FROM MstContactWay m WHERE m.contactWayKbnName = :contactWayKbnName")})
public class MstContactWay implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CONTACT_WAY_KBN")
    private String contactWayKbn;
    @Size(max = 50)
    @Column(name = "CONTACT_WAY_KBN_NAME")
    private String contactWayKbnName;

    public MstContactWay() {
    }

    public MstContactWay(String contactWayKbn) {
        this.contactWayKbn = contactWayKbn;
    }

    public String getContactWayKbn() {
        return contactWayKbn;
    }

    public void setContactWayKbn(String contactWayKbn) {
        this.contactWayKbn = contactWayKbn;
    }

    public String getContactWayKbnName() {
        return contactWayKbnName;
    }

    public void setContactWayKbnName(String contactWayKbnName) {
        this.contactWayKbnName = contactWayKbnName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactWayKbn != null ? contactWayKbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstContactWay)) {
            return false;
        }
        MstContactWay other = (MstContactWay) object;
        if ((this.contactWayKbn == null && other.contactWayKbn != null) || (this.contactWayKbn != null && !this.contactWayKbn.equals(other.contactWayKbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.common.MstContactWay[ contactWayKbn=" + contactWayKbn + " ]";
    }
    
}
