/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.dao;

import com.tnkmatic.onlinebooking.ejb.entity.MstGender;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tnkmatic@outlook.jp
 */
@Local
public interface MstGenderFacadeLocal {

    void create(MstGender mstGender);

    void edit(MstGender mstGender);

    void remove(MstGender mstGender);

    MstGender find(Object id);

    List<MstGender> findAll();

    List<MstGender> findRange(int[] range);

    int count();
    
}
