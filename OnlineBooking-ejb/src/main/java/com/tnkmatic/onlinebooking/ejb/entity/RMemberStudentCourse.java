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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eiichi
 */
@Entity
@Table(name = "r_member_student_course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RMemberStudentCourse.findAll", query = "SELECT r FROM RMemberStudentCourse r"),
    @NamedQuery(name = "RMemberStudentCourse.findByMemberId", query = "SELECT r FROM RMemberStudentCourse r WHERE r.rMemberStudentCoursePK.memberId = :memberId"),
    @NamedQuery(name = "RMemberStudentCourse.findByCourseId", query = "SELECT r FROM RMemberStudentCourse r WHERE r.rMemberStudentCoursePK.courseId = :courseId"),
    @NamedQuery(name = "RMemberStudentCourse.findByPricePerHour", query = "SELECT r FROM RMemberStudentCourse r WHERE r.pricePerHour = :pricePerHour"),
    @NamedQuery(name = "RMemberStudentCourse.findByInsDate", query = "SELECT r FROM RMemberStudentCourse r WHERE r.systemDate.insDate = :insDate"),
    @NamedQuery(name = "RMemberStudentCourse.findByUpdDate", query = "SELECT r FROM RMemberStudentCourse r WHERE r.systemDate.updDate = :updDate")})
public class RMemberStudentCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RMemberStudentCoursePK rMemberStudentCoursePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE_PER_HOUR")
    private int pricePerHour;

    //登録日時・更新日時
    @Embedded
    private SystemDate systemDate;
    
    public RMemberStudentCourse() {
    }

    public RMemberStudentCourse(RMemberStudentCoursePK rMemberStudentCoursePK) {
        this.rMemberStudentCoursePK = rMemberStudentCoursePK;
    }

    public RMemberStudentCourse(RMemberStudentCoursePK rMemberStudentCoursePK, int pricePerHour) {
        this.rMemberStudentCoursePK = rMemberStudentCoursePK;
        this.pricePerHour = pricePerHour;
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

        public SystemDate getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(SystemDate systemDate) {
        this.systemDate = systemDate;
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
    
    @PrePersist
    public void onPrePersist() {
        this.systemDate = new SystemDate(new Date());
    }
    
    @PreUpdate
    public void onPreUpdate() {
        this.systemDate.setUpdDate(new Date());
    }
}
