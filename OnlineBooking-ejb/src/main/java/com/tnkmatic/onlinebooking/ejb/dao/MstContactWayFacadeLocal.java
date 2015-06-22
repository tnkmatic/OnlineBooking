/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.dao;

import com.tnkmatic.onlinebooking.ejb.entity.MstContactWay;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tnkmatic@outlook.jp
 */
@Local
public interface MstContactWayFacadeLocal {

    void create(MstContactWay mstContactWay);

    void edit(MstContactWay mstContactWay);

    void remove(MstContactWay mstContactWay);

    MstContactWay find(Object id);

    List<MstContactWay> findAll();

    List<MstContactWay> findRange(int[] range);

    int count();
    
}
