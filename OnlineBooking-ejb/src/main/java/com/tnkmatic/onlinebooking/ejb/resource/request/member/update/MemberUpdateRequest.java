/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource.request.member.update;

import static com.tnkmatic.onlinebooking.ejb.entity.BookingMember_.loginId;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.common.MemberTeacherCourseRequest;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.common.MemberTeacherRequest;

/**
 *
 * @author tnkmatic
 */
public class MemberUpdateRequest {
    private String loginId;
    private MemberTeacherRequest memberTeacher;
    private MemberTeacherCourseRequest teacherCourse;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public MemberTeacherRequest getMemberTeacher() {
        return memberTeacher;
    }

    public void setMemberTeacher(MemberTeacherRequest memberTeacher) {
        this.memberTeacher = memberTeacher;
    }

    public MemberTeacherCourseRequest getTeacherCourse() {
        return teacherCourse;
    }

    public void setTeacherCourse(MemberTeacherCourseRequest teacherCourse) {
        this.teacherCourse = teacherCourse;
    }
}
