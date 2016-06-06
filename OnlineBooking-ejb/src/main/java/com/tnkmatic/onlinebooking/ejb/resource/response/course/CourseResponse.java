/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource.response.course;

import com.tnkmatic.onlinebooking.ejb.entity.MstCourse;
import java.util.List;

/**
 *
 * @author tnkmatic
 */
public class CourseResponse {
    private MstCourse course;
    private List<MstCourse> courses;

    public MstCourse getMstCourse() {
        return course;
    }

    public void setMstCourse(MstCourse mstCourse) {
        this.course = mstCourse;
    }

    public List<MstCourse> getMstCourseList() {
        return courses;
    }

    public void setMstCourseList(List<MstCourse> mstCourseList) {
        this.courses = mstCourseList;
    }
    
}
