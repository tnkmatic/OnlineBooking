/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.dao.impl;

import com.tnkmatic.onlinebooking.ejb.dao.MemberTeacherFacadeLocal;
import com.tnkmatic.onlinebooking.ejb.entity.MemberTeacher;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Eiichi
 */
@Stateless
public class MemberTeacherFacade extends AbstractFacade<MemberTeacher> implements MemberTeacherFacadeLocal {
    @PersistenceContext(unitName = "com.tnkmatic_OnlineBooking-ejb_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MemberTeacherFacade() {
        super(MemberTeacher.class);
    }
    
}
