/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.dao;

import com.tnkmatic.onlinebooking.ejb.entity.MstBusinessHours;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface MstBusinessHoursFacadeLocal {

    void create(MstBusinessHours mstBusinessHours);

    void edit(MstBusinessHours mstBusinessHours);

    void remove(MstBusinessHours mstBusinessHours);

    MstBusinessHours find(Object id);

    List<MstBusinessHours> findAll();

    List<MstBusinessHours> findRange(int[] range);

    int count();
    
}
