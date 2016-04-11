/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource.response.mstcourse;

import com.tnkmatic.onlinebooking.ejb.entity.MstCourse;
import java.util.List;

/**
 *
 * @author tnkmatic
 */
public class MstCourseResponse {
    private MstCourse mstCourse;
    private List<MstCourse> mstCourses;

    public MstCourse getMstCourse() {
        return mstCourse;
    }

    public void setMstCourse(MstCourse mstCourse) {
        this.mstCourse = mstCourse;
    }

    public List<MstCourse> getMstCourseList() {
        return mstCourses;
    }

    public void setMstCourseList(List<MstCourse> mstCourseList) {
        this.mstCourses = mstCourseList;
    }
    
}
