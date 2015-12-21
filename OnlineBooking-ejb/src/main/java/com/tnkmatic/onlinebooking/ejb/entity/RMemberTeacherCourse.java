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
@Table(name = "r_member_teacher_course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RMemberTeacherCourse.findAll", query = "SELECT r FROM RMemberTeacherCourse r"),
    @NamedQuery(name = "RMemberTeacherCourse.findByMemberId", query = "SELECT r FROM RMemberTeacherCourse r WHERE r.rMemberTeacherCoursePK.memberId = :memberId"),
    @NamedQuery(name = "RMemberTeacherCourse.findByCourseId", query = "SELECT r FROM RMemberTeacherCourse r WHERE r.rMemberTeacherCoursePK.courseId = :courseId"),
    @NamedQuery(name = "RMemberTeacherCourse.findBySalaryPerHour", query = "SELECT r FROM RMemberTeacherCourse r WHERE r.salaryPerHour = :salaryPerHour"),
    @NamedQuery(name = "RMemberTeacherCourse.findByInsDate", query = "SELECT r FROM RMemberTeacherCourse r WHERE r.systemDate.insDate = :insDate"),
    @NamedQuery(name = "RMemberTeacherCourse.findByUpdDate", query = "SELECT r FROM RMemberTeacherCourse r WHERE r.systemDate.updDate = :updDate")})
public class RMemberTeacherCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RMemberTeacherCoursePK rMemberTeacherCoursePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALARY_PER_HOUR")
    private int salaryPerHour;
    
    //登録日時・更新日時
    @Embedded
    private SystemDate systemDate;

    public RMemberTeacherCourse() {
    }

    public RMemberTeacherCourse(RMemberTeacherCoursePK rMemberTeacherCoursePK) {
        this.rMemberTeacherCoursePK = rMemberTeacherCoursePK;
    }

    public RMemberTeacherCourse(RMemberTeacherCoursePK rMemberTeacherCoursePK, int salaryPerHour) {
        this.rMemberTeacherCoursePK = rMemberTeacherCoursePK;
        this.salaryPerHour = salaryPerHour;
    }

    public RMemberTeacherCourse(int memberId, short courseId) {
        this.rMemberTeacherCoursePK = new RMemberTeacherCoursePK(memberId, courseId);
    }

    public RMemberTeacherCoursePK getRMemberTeacherCoursePK() {
        return rMemberTeacherCoursePK;
    }

    public void setRMemberTeacherCoursePK(RMemberTeacherCoursePK rMemberTeacherCoursePK) {
        this.rMemberTeacherCoursePK = rMemberTeacherCoursePK;
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
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
        hash += (rMemberTeacherCoursePK != null ? rMemberTeacherCoursePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RMemberTeacherCourse)) {
            return false;
        }
        RMemberTeacherCourse other = (RMemberTeacherCourse) object;
        if ((this.rMemberTeacherCoursePK == null && other.rMemberTeacherCoursePK != null) || (this.rMemberTeacherCoursePK != null && !this.rMemberTeacherCoursePK.equals(other.rMemberTeacherCoursePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.RMemberTeacherCourse[ rMemberTeacherCoursePK=" + rMemberTeacherCoursePK + " ]";
    }
    
    @PrePersist
    public void onPrePersist() {
        systemDate = new SystemDate(new Date());
    }
    
    @PreUpdate
    public void onPreUpdate() {
        this.systemDate.setUpdDate(new Date());
    }
}
