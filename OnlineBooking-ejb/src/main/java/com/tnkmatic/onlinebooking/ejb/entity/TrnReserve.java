/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.entity;

import com.tnkmatic.onlinebooking.ejb.entity.embeddable.SystemDate;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eiichi
 */
@Entity
@Table(name = "trn_reserve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrnReserve.findAll", query = "SELECT t FROM TrnReserve t"),
    @NamedQuery(name = "TrnReserve.findByReserveId", query = "SELECT t FROM TrnReserve t WHERE t.trnReservePK.reserveId = :reserveId"),
    @NamedQuery(name = "TrnReserve.findByTeacherMemberId", query = "SELECT t FROM TrnReserve t WHERE t.trnReservePK.teacherMemberId = :teacherMemberId"),
    @NamedQuery(name = "TrnReserve.findByCourseId", query = "SELECT t FROM TrnReserve t WHERE t.trnReservePK.courseId = :courseId"),
    @NamedQuery(name = "TrnReserve.findByStudentMemberId", query = "SELECT t FROM TrnReserve t WHERE t.studentMemberId = :studentMemberId"),
    @NamedQuery(name = "TrnReserve.findByReserveDate", query = "SELECT t FROM TrnReserve t WHERE t.reserveDate = :reserveDate"),
    @NamedQuery(name = "TrnReserve.findByInsDate", query = "SELECT t FROM TrnReserve t WHERE t.systemDate.insDate = :insDate"),
    @NamedQuery(name = "TrnReserve.findByUpdDate", query = "SELECT t FROM TrnReserve t WHERE t.systemDate.updDate = :updDate")})
public class TrnReserve implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrnReservePK trnReservePK;
    @Column(name = "STUDENT_MEMBER_ID")
    private Integer studentMemberId;
    @Column(name = "RESERVE_DATE")
    @Temporal(TemporalType.DATE)
    private Date reserveDate;
    
    @Embedded
    private SystemDate systemDate;

    public TrnReserve() {
    }

    public TrnReserve(TrnReservePK trnReservePK) {
        this.trnReservePK = trnReservePK;
    }

    public TrnReserve(int reserveId, int teacherMemberId, int courseId) {
        this.trnReservePK = new TrnReservePK(reserveId, teacherMemberId, courseId);
    }

    public TrnReservePK getTrnReservePK() {
        return trnReservePK;
    }

    public void setTrnReservePK(TrnReservePK trnReservePK) {
        this.trnReservePK = trnReservePK;
    }

    public Integer getStudentMemberId() {
        return studentMemberId;
    }

    public void setStudentMemberId(Integer studentMemberId) {
        this.studentMemberId = studentMemberId;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
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
        hash += (trnReservePK != null ? trnReservePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrnReserve)) {
            return false;
        }
        TrnReserve other = (TrnReserve) object;
        if ((this.trnReservePK == null && other.trnReservePK != null) || (this.trnReservePK != null && !this.trnReservePK.equals(other.trnReservePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.TrnReserve[ trnReservePK=" + trnReservePK + " ]";
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
