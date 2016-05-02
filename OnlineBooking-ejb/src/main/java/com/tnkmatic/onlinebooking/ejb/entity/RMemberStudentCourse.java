/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tnkmatic
 */
@Entity
@Table(name = "r_member_student_course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RMemberStudentCourse.findAll", query = "SELECT r FROM RMemberStudentCourse r"),
    @NamedQuery(name = "RMemberStudentCourse.findByMemberId", query = "SELECT r FROM RMemberStudentCourse r WHERE r.rMemberStudentCoursePK.memberId = :memberId"),
    @NamedQuery(name = "RMemberStudentCourse.findByCourseId", query = "SELECT r FROM RMemberStudentCourse r WHERE r.rMemberStudentCoursePK.courseId = :courseId"),
    @NamedQuery(name = "RMemberStudentCourse.findByPricePerHour", query = "SELECT r FROM RMemberStudentCourse r WHERE r.pricePerHour = :pricePerHour"),
    @NamedQuery(name = "RMemberStudentCourse.findByInsDate", query = "SELECT r FROM RMemberStudentCourse r WHERE r.insDate = :insDate"),
    @NamedQuery(name = "RMemberStudentCourse.findByUpdDate", query = "SELECT r FROM RMemberStudentCourse r WHERE r.updDate = :updDate")})
public class RMemberStudentCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RMemberStudentCoursePK rMemberStudentCoursePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE_PER_HOUR")
    private int pricePerHour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updDate;

    public RMemberStudentCourse() {
    }

    public RMemberStudentCourse(RMemberStudentCoursePK rMemberStudentCoursePK) {
        this.rMemberStudentCoursePK = rMemberStudentCoursePK;
    }

    public RMemberStudentCourse(RMemberStudentCoursePK rMemberStudentCoursePK, int pricePerHour, Date insDate, Date updDate) {
        this.rMemberStudentCoursePK = rMemberStudentCoursePK;
        this.pricePerHour = pricePerHour;
        this.insDate = insDate;
        this.updDate = updDate;
    }

    public RMemberStudentCourse(int memberId, short courseId) {
        this.rMemberStudentCoursePK = new RMemberStudentCoursePK(memberId, courseId);
    }

    public RMemberStudentCoursePK getRMemberStudentCoursePK() {
        return rMemberStudentCoursePK;
    }

    public void setRMemberStudentCoursePK(RMemberStudentCoursePK rMemberStudentCoursePK) {
        this.rMemberStudentCoursePK = rMemberStudentCoursePK;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
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
