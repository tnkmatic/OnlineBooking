/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.dao;

import com.tnkmatic.onlinebooking.ejb.entity.MemberStudent;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface MemberStudentFacadeLocal {

    void create(MemberStudent memberStudent);

    void edit(MemberStudent memberStudent);

    void remove(MemberStudent memberStudent);

    MemberStudent find(Object id);

    List<MemberStudent> findAll();

    List<MemberStudent> findRange(int[] range);

    int count();
    
}
