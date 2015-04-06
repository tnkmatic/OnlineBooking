/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.dao;

import com.tnkmatic.onlinebooking.ejb.entity.TrnReserve;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface TrnReserveFacadeLocal {

    void create(TrnReserve trnReserve);

    void edit(TrnReserve trnReserve);

    void remove(TrnReserve trnReserve);

    TrnReserve find(Object id);

    List<TrnReserve> findAll();

    List<TrnReserve> findRange(int[] range);

    int count();
    
}
