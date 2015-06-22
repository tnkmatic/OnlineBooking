/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.service.impl;

import com.tnkmatic.onlinebooking.ejb.dao.MemberGroupFacadeLocal;
import com.tnkmatic.onlinebooking.ejb.entity.MemberGroup;
import com.tnkmatic.onlinebooking.ejb.service.MemberGroupServiceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author Eiichi
 */
@Stateless
@Local(MemberGroupServiceLocal.class)
public class MemberGroupService implements MemberGroupServiceLocal {
    @EJB MemberGroupFacadeLocal memberGroupDao;
    
    @Override
    public List<MemberGroup> selectMemberGroupList() {
        List<MemberGroup> memberGroupList = memberGroupDao.findAll();
        return memberGroupList;
    }
}
