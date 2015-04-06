/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.dao;

import com.tnkmatic.onlinebooking.ejb.entity.MemberTeacherSchedule;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface MemberTeacherScheduleFacadeLocal {

    void create(MemberTeacherSchedule memberTeacherSchedule);

    void edit(MemberTeacherSchedule memberTeacherSchedule);

    void remove(MemberTeacherSchedule memberTeacherSchedule);

    MemberTeacherSchedule find(Object id);

    List<MemberTeacherSchedule> findAll();

    List<MemberTeacherSchedule> findRange(int[] range);

    int count();
    
}
