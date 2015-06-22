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
@Table(name = "mst_gender")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstGender.findAll", query = "SELECT m FROM MstGender m"),
    @NamedQuery(name = "MstGender.findByGender", query = "SELECT m FROM MstGender m WHERE m.gender = :gender"),
    @NamedQuery(name = "MstGender.findByGenderName", query = "SELECT m FROM MstGender m WHERE m.genderName = :genderName")})
public class MstGender implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "GENDER")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "GENDER_NAME")
    private String genderName;

    public MstGender() {
    }

    public MstGender(String gender) {
        this.gender = gender;
    }

    public MstGender(String gender, String genderName) {
        this.gender = gender;
        this.genderName = genderName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gender != null ? gender.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstGender)) {
            return false;
        }
        MstGender other = (MstGender) object;
        if ((this.gender == null && other.gender != null) || (this.gender != null && !this.gender.equals(other.gender))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.common.MstGender[ gender=" + gender + " ]";
    }
    
}
