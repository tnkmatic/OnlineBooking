/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.resource.request.member;

/**
 *
 * @author Eiichi
 */
public class MemberTeacherCourseRequest {
    private short courseId;
    private int salaryPerHour;

    public short getCourseId() {
        return courseId;
    }

    public void setCourseId(short courseId) {
        this.courseId = courseId;
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }
}
