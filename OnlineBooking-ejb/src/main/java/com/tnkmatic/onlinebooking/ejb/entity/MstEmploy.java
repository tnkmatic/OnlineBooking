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
@Table(name = "mst_employ", catalog = "onlinebooking", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstEmploy.findAll", query = "SELECT m FROM MstEmploy m"),
    @NamedQuery(name = "MstEmploy.findByEmployKbn", query = "SELECT m FROM MstEmploy m WHERE m.employKbn = :employKbn"),
    @NamedQuery(name = "MstEmploy.findByEmployName", query = "SELECT m FROM MstEmploy m WHERE m.employName = :employName")})
public class MstEmploy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "EMPLOY_KBN")
    private String employKbn;
    @Size(max = 20)
    @Column(name = "EMPLOY_NAME")
    private String employName;

    public MstEmploy() {
    }

    public MstEmploy(String employKbn) {
        this.employKbn = employKbn;
    }

    public String getEmployKbn() {
        return employKbn;
    }

    public void setEmployKbn(String employKbn) {
        this.employKbn = employKbn;
    }

    public String getEmployName() {
        return employName;
    }

    public void setEmployName(String employName) {
        this.employName = employName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employKbn != null ? employKbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstEmploy)) {
            return false;
        }
        MstEmploy other = (MstEmploy) object;
        if ((this.employKbn == null && other.employKbn != null) || (this.employKbn != null && !this.employKbn.equals(other.employKbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.MstEmploy[ employKbn=" + employKbn + " ]";
    }
    
}
