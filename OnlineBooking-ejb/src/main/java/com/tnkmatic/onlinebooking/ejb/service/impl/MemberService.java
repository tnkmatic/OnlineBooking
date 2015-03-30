/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.service.impl;

import com.tnkmatic.onlinebooking.ejb.entity.BookingMember;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.MemberRegister;
import com.tnkmatic.onlinebooking.ejb.service.MemberServiceLocal;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Eiichi
 */
@Stateless
public class MemberService implements MemberServiceLocal {
    @PersistenceContext(unitName = "com.tnkmatic_OnlineBooking-ejb_PU")
    private EntityManager em;
    
    @Override
    public void memberRegist(final MemberRegister memberRegister) 
            throws IllegalAccessException, InvocationTargetException {
        // パスワードをハッシュ化(SHA-256)

        // Entityオブジェクトにコピー
        final BookingMember bookingMember = new BookingMember();
        BeanUtils.copyProperties(bookingMember, memberRegister);
        
        if ()
        
        
    }
}
