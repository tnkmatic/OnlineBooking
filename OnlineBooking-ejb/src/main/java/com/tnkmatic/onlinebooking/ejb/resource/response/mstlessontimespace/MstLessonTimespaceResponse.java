/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource.response.mstlessontimespace;

import com.tnkmatic.onlinebooking.ejb.entity.MstLessonTimespace;

/**
 *
 * @author tnkmatic
 */
public class MstLessonTimespaceResponse {
    private MstLessonTimespace mstLessonTimeSpace;

    public MstLessonTimespace getMstLessonTimeSpace() {
        return mstLessonTimeSpace;
    }

    public void setMstLessonTimeSpace(MstLessonTimespace mstLessonTimeSpace) {
        this.mstLessonTimeSpace = mstLessonTimeSpace;
    }
}
