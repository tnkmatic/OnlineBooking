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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eiichi
 */
@Entity
@Table(name = "mst_lesson_timespace")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstLessonTimespace.findAll", query = "SELECT m FROM MstLessonTimespace m"),
    @NamedQuery(name = "MstLessonTimespace.findByLessonTimespace", query = "SELECT m FROM MstLessonTimespace m WHERE m.lessonTimespace = :lessonTimespace")})
public class MstLessonTimespace implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LESSON_TIMESPACE")
    private Short lessonTimespace;

    public MstLessonTimespace() {
    }

    public MstLessonTimespace(Short lessonTimespace) {
        this.lessonTimespace = lessonTimespace;
    }

    public Short getLessonTimespace() {
        return lessonTimespace;
    }

    public void setLessonTimespace(Short lessonTimespace) {
        this.lessonTimespace = lessonTimespace;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lessonTimespace != null ? lessonTimespace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstLessonTimespace)) {
            return false;
        }
        MstLessonTimespace other = (MstLessonTimespace) object;
        if ((this.lessonTimespace == null && other.lessonTimespace != null) || (this.lessonTimespace != null && !this.lessonTimespace.equals(other.lessonTimespace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.MstLessonTimespace[ lessonTimespace=" + lessonTimespace + " ]";
    }
    
}
