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
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eiichi
 */
@Entity
@Table(name = "member_teacher_schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberTeacherSchedule.findAll", query = "SELECT m FROM MemberTeacherSchedule m"),
    @NamedQuery(name = "MemberTeacherSchedule.findByMemberId", query = "SELECT m FROM MemberTeacherSchedule m WHERE m.memberId = :memberId"),
    @NamedQuery(name = "MemberTeacherSchedule.findByScheduleSeq", query = "SELECT m FROM MemberTeacherSchedule m WHERE m.scheduleSeq = :scheduleSeq"),
    @NamedQuery(name = "MemberTeacherSchedule.findByDayOfWeekKbn", query = "SELECT m FROM MemberTeacherSchedule m WHERE m.dayOfWeekKbn = :dayOfWeekKbn"),
    @NamedQuery(name = "MemberTeacherSchedule.findByLessonTimeFrom", query = "SELECT m FROM MemberTeacherSchedule m WHERE m.lessonTimeFrom = :lessonTimeFrom"),
    @NamedQuery(name = "MemberTeacherSchedule.findByLessonTimeTo", query = "SELECT m FROM MemberTeacherSchedule m WHERE m.lessonTimeTo = :lessonTimeTo"),
    @NamedQuery(name = "MemberTeacherSchedule.findByInsDate", query = "SELECT m FROM MemberTeacherSchedule m WHERE m.embDate.insDate = :insDate"),
    @NamedQuery(name = "MemberTeacherSchedule.findByUpdDate", query = "SELECT m FROM MemberTeacherSchedule m WHERE m.embDate.updDate = :updDate")})
public class MemberTeacherSchedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBER_ID")
    private int memberId;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SCHEDULE_SEQ")
    private Integer scheduleSeq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DAY_OF_WEEK_KBN")
    private String dayOfWeekKbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "LESSON_TIME_FROM")
    private String lessonTimeFrom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "LESSON_TIME_TO")
    private String lessonTimeTo;
    
    @Embedded
    private EmbeddableDate embDate;

    public MemberTeacherSchedule() {
    }

    public MemberTeacherSchedule(Integer scheduleSeq) {
        this.scheduleSeq = scheduleSeq;
    }

    public MemberTeacherSchedule(Integer scheduleSeq, int memberId, String dayOfWeekKbn, String lessonTimeFrom, String lessonTimeTo, Date insDate, Date updDate) {
        this.scheduleSeq = scheduleSeq;
        this.memberId = memberId;
        this.dayOfWeekKbn = dayOfWeekKbn;
        this.lessonTimeFrom = lessonTimeFrom;
        this.lessonTimeTo = lessonTimeTo;
        this.embDate.setInsDate(insDate);
        this.embDate.setUpdDate(updDate);
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Integer getScheduleSeq() {
        return scheduleSeq;
    }

    public void setScheduleSeq(Integer scheduleSeq) {
        this.scheduleSeq = scheduleSeq;
    }

    public String getDayOfWeekKbn() {
        return dayOfWeekKbn;
    }

    public void setDayOfWeekKbn(String dayOfWeekKbn) {
        this.dayOfWeekKbn = dayOfWeekKbn;
    }

    public String getLessonTimeFrom() {
        return lessonTimeFrom;
    }

    public void setLessonTimeFrom(String lessonTimeFrom) {
        this.lessonTimeFrom = lessonTimeFrom;
    }

    public String getLessonTimeTo() {
        return lessonTimeTo;
    }

    public void setLessonTimeTo(String lessonTimeTo) {
        this.lessonTimeTo = lessonTimeTo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduleSeq != null ? scheduleSeq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberTeacherSchedule)) {
            return false;
        }
        MemberTeacherSchedule other = (MemberTeacherSchedule) object;
        if ((this.scheduleSeq == null && other.scheduleSeq != null) || (this.scheduleSeq != null && !this.scheduleSeq.equals(other.scheduleSeq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.MemberTeacherSchedule[ scheduleSeq=" + scheduleSeq + " ]";
    }
    
    @PrePersist
    public void onPrePersist() {
        embDate = (embDate == null) ? new EmbeddableDate() : embDate;
        embDate.persistEmbeddableDate();
    }
    
    @PreUpdate
    public void onPreUpdate() {
        embDate.updateEmbeddableDate();
    }
    
}
