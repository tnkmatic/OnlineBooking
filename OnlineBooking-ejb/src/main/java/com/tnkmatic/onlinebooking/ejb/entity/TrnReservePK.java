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
public class TrnReservePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESERVE_ID")
    private int reserveId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEACHER_MEMBER_ID")
    private int teacherMemberId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COURSE_ID")
    private int courseId;

    public TrnReservePK() {
    }

    public TrnReservePK(int reserveId, int teacherMemberId, int courseId) {
        this.reserveId = reserveId;
        this.teacherMemberId = teacherMemberId;
        this.courseId = courseId;
    }

    public int getReserveId() {
        return reserveId;
    }

    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }

    public int getTeacherMemberId() {
        return teacherMemberId;
    }

    public void setTeacherMemberId(int teacherMemberId) {
        this.teacherMemberId = teacherMemberId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) reserveId;
        hash += (int) teacherMemberId;
        hash += (int) courseId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrnReservePK)) {
            return false;
        }
        TrnReservePK other = (TrnReservePK) object;
        if (this.reserveId != other.reserveId) {
            return false;
        }
        if (this.teacherMemberId != other.teacherMemberId) {
            return false;
        }
        if (this.courseId != other.courseId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.TrnReservePK[ reserveId=" + reserveId + ", teacherMemberId=" + teacherMemberId + ", courseId=" + courseId + " ]";
    }
    
}
