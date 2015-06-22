/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.resource.request.member.register;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Eiichi
 */
public class MemberTeacherRequest {
    private String employKbn;
    private Date employYmdFrom;
    private Date employYmdTo;
    private List<MemberTeacherCourseRequest> memberTeacherCourseRequestList;

    public String getEmployKbn() {
        return employKbn;
    }

    public void setEmployKbn(String employKbn) {
        this.employKbn = employKbn;
    }

    public Date getEmployYmdFrom() {
        return employYmdFrom;
    }

    public void setEmployYmdFrom(Date employYmdFrom) {
        this.employYmdFrom = employYmdFrom;
    }

    public Date getEmployYmdTo() {
        return employYmdTo;
    }

    public void setEmployYmdTo(Date employYmdTo) {
        this.employYmdTo = employYmdTo;
    }

    public List<MemberTeacherCourseRequest> getMemberTeacherCourseRequestList() {
        return memberTeacherCourseRequestList;
    }

    public void setMemberTeacherCourseRequestList(List<MemberTeacherCourseRequest> memberTeacherCourseRequestList) {
        this.memberTeacherCourseRequestList = memberTeacherCourseRequestList;
    }
}
