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
@Table(name = "mst_course", catalog = "onlinebooking", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstCourse.findAll", query = "SELECT m FROM MstCourse m"),
    @NamedQuery(name = "MstCourse.findByCourseId", query = "SELECT m FROM MstCourse m WHERE m.courseId = :courseId"),
    @NamedQuery(name = "MstCourse.findByCourseName", query = "SELECT m FROM MstCourse m WHERE m.courseName = :courseName")})
public class MstCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COURSE_ID")
    private Short courseId;
    @Size(max = 45)
    @Column(name = "COURSE_NAME")
    private String courseName;

    public MstCourse() {
    }

    public MstCourse(Short courseId) {
        this.courseId = courseId;
    }

    public Short getCourseId() {
        return courseId;
    }

    public void setCourseId(Short courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstCourse)) {
            return false;
        }
        MstCourse other = (MstCourse) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.MstCourse[ courseId=" + courseId + " ]";
    }
    
}
