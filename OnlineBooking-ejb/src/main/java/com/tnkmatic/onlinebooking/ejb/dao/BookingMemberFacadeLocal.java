/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.dao;

import com.tnkmatic.onlinebooking.ejb.entity.BookingMember;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface BookingMemberFacadeLocal {

    void create(BookingMember bookingMember);

    void edit(BookingMember bookingMember);

    void remove(BookingMember bookingMember);

    BookingMember find(Object id);

    List<BookingMember> findAll();

    List<BookingMember> findRange(int[] range);

    int count();
    
}
