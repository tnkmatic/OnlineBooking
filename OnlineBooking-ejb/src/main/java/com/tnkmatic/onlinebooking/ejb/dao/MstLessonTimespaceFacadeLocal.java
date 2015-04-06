/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.dao;

import com.tnkmatic.onlinebooking.ejb.entity.MstLessonTimespace;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface MstLessonTimespaceFacadeLocal {

    void create(MstLessonTimespace mstLessonTimespace);

    void edit(MstLessonTimespace mstLessonTimespace);

    void remove(MstLessonTimespace mstLessonTimespace);

    MstLessonTimespace find(Object id);

    List<MstLessonTimespace> findAll();

    List<MstLessonTimespace> findRange(int[] range);

    int count();
    
}
