/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource.response.lessontimespace;

import com.tnkmatic.onlinebooking.ejb.entity.MstLessonTimespace;

/**
 *
 * @author tnkmatic
 */
public class LessonTimespaceResponse {
    private MstLessonTimespace lessonTimeSpace;

    public MstLessonTimespace getMstLessonTimeSpace() {
        return lessonTimeSpace;
    }

    public void setMstLessonTimeSpace(MstLessonTimespace mstLessonTimeSpace) {
        this.lessonTimeSpace = mstLessonTimeSpace;
    }
}
