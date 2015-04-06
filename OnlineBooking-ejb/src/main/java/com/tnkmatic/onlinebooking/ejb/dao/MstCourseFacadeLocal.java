/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.dao;

import com.tnkmatic.onlinebooking.ejb.entity.MstCourse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface MstCourseFacadeLocal {

    void create(MstCourse mstCourse);

    void edit(MstCourse mstCourse);

    void remove(MstCourse mstCourse);

    MstCourse find(Object id);

    List<MstCourse> findAll();

    List<MstCourse> findRange(int[] range);

    int count();
    
}
