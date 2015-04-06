/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.dao;

import com.tnkmatic.onlinebooking.ejb.entity.MemberTeacher;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface MemberTeacherFacadeLocal {

    void create(MemberTeacher memberTeacher);

    void edit(MemberTeacher memberTeacher);

    void remove(MemberTeacher memberTeacher);

    MemberTeacher find(Object id);

    List<MemberTeacher> findAll();

    List<MemberTeacher> findRange(int[] range);

    int count();
    
}
