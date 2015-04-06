/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.dao;

import com.tnkmatic.onlinebooking.ejb.entity.RMemberStudentCourse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface RMemberStudentCourseFacadeLocal {

    void create(RMemberStudentCourse rMemberStudentCourse);

    void edit(RMemberStudentCourse rMemberStudentCourse);

    void remove(RMemberStudentCourse rMemberStudentCourse);

    RMemberStudentCourse find(Object id);

    List<RMemberStudentCourse> findAll();

    List<RMemberStudentCourse> findRange(int[] range);

    int count();
    
}
