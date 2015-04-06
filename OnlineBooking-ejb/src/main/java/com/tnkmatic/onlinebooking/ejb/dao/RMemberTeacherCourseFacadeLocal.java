/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.dao;

import com.tnkmatic.onlinebooking.ejb.entity.RMemberTeacherCourse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface RMemberTeacherCourseFacadeLocal {

    void create(RMemberTeacherCourse rMemberTeacherCourse);

    void edit(RMemberTeacherCourse rMemberTeacherCourse);

    void remove(RMemberTeacherCourse rMemberTeacherCourse);

    RMemberTeacherCourse find(Object id);

    List<RMemberTeacherCourse> findAll();

    List<RMemberTeacherCourse> findRange(int[] range);

    int count();
    
}
