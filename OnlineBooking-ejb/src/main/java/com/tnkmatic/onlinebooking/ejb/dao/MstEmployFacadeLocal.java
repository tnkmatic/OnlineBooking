/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.dao;

import com.tnkmatic.onlinebooking.ejb.entity.MstEmploy;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface MstEmployFacadeLocal {

    void create(MstEmploy mstEmploy);

    void edit(MstEmploy mstEmploy);

    void remove(MstEmploy mstEmploy);

    MstEmploy find(Object id);

    List<MstEmploy> findAll();

    List<MstEmploy> findRange(int[] range);

    int count();
    
}
