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
public class RMemberStudentCoursePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBER_ID")
    private int memberId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COURSE_ID")
    private short courseId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE_PER_HOUR")
    private int pricePerHour;

    public RMemberStudentCoursePK() {
    }

    public RMemberStudentCoursePK(int memberId, short courseId, int pricePerHour) {
        this.memberId = memberId;
        this.courseId = courseId;
        this.pricePerHour = pricePerHour;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public short getCourseId() {
        return courseId;
    }

    public void setCourseId(short courseId) {
        this.courseId = courseId;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) memberId;
        hash += (int) courseId;
        hash += (int) pricePerHour;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RMemberStudentCoursePK)) {
            return false;
        }
        RMemberStudentCoursePK other = (RMemberStudentCoursePK) object;
        if (this.memberId != other.memberId) {
            return false;
        }
        if (this.courseId != other.courseId) {
            return false;
        }
        if (this.pricePerHour != other.pricePerHour) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.RMemberStudentCoursePK[ memberId=" + memberId + ", courseId=" + courseId + ", pricePerHour=" + pricePerHour + " ]";
    }
    
}
