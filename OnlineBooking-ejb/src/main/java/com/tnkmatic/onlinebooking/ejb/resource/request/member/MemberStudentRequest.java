/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.resource.request.member;

import java.util.List;

/**
 *
 * @author Eiichi
 */
public class MemberStudentRequest {
    private List<MemberStudentCourseRequest> memberStudentCourseRequestList;

    public List<MemberStudentCourseRequest> getMemberStudentCourseRequestList() {
        return memberStudentCourseRequestList;
    }

    public void setMemberStudentCourseRequestList(List<MemberStudentCourseRequest> memberStudentCourseRequestList) {
        this.memberStudentCourseRequestList = memberStudentCourseRequestList;
    }
}
