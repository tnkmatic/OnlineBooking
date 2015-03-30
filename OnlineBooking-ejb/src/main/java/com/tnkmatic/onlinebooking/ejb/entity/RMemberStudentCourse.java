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
@Table(name = "r_member_student_course", catalog = "onlinebooking", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RMemberStudentCourse.findAll", query = "SELECT r FROM RMemberStudentCourse r"),
    @NamedQuery(name = "RMemberStudentCourse.findByMemberId", query = "SELECT r FROM RMemberStudentCourse r WHERE r.rMemberStudentCoursePK.memberId = :memberId"),
    @NamedQuery(name = "RMemberStudentCourse.findByCourseId", query = "SELECT r FROM RMemberStudentCourse r WHERE r.rMemberStudentCoursePK.courseId = :courseId"),
    @NamedQuery(name = "RMemberStudentCourse.findByPricePerHour", query = "SELECT r FROM RMemberStudentCourse r WHERE r.rMemberStudentCoursePK.pricePerHour = :pricePerHour")})
public class RMemberStudentCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RMemberStudentCoursePK rMemberStudentCoursePK;

    public RMemberStudentCourse() {
    }

    public RMemberStudentCourse(RMemberStudentCoursePK rMemberStudentCoursePK) {
        this.rMemberStudentCoursePK = rMemberStudentCoursePK;
    }

    public RMemberStudentCourse(int memberId, short courseId, int pricePerHour) {
        this.rMemberStudentCoursePK = new RMemberStudentCoursePK(memberId, courseId, pricePerHour);
    }

    public RMemberStudentCoursePK getRMemberStudentCoursePK() {
        return rMemberStudentCoursePK;
    }

    public void setRMemberStudentCoursePK(RMemberStudentCoursePK rMemberStudentCoursePK) {
        this.rMemberStudentCoursePK = rMemberStudentCoursePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rMemberStudentCoursePK != null ? rMemberStudentCoursePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RMemberStudentCourse)) {
            return false;
        }
        RMemberStudentCourse other = (RMemberStudentCourse) object;
        if ((this.rMemberStudentCoursePK == null && other.rMemberStudentCoursePK != null) || (this.rMemberStudentCoursePK != null && !this.rMemberStudentCoursePK.equals(other.rMemberStudentCoursePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.RMemberStudentCourse[ rMemberStudentCoursePK=" + rMemberStudentCoursePK + " ]";
    }
    
}
