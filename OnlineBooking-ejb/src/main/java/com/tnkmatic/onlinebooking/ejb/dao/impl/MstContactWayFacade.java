/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.dao.impl;

import com.tnkmatic.onlinebooking.ejb.dao.MstContactWayFacadeLocal;
import com.tnkmatic.onlinebooking.ejb.entity.MstContactWay;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tnkmatic@outlook.jp
 */
@Stateless
public class MstContactWayFacade extends AbstractFacade<MstContactWay> implements MstContactWayFacadeLocal {
    @PersistenceContext(unitName = "com.tnkmatic_OnlineBooking-ejb_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MstContactWayFacade() {
        super(MstContactWay.class);
    }
    
}
