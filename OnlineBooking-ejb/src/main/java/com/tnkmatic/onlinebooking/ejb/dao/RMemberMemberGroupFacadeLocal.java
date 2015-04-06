/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.dao;

import com.tnkmatic.onlinebooking.ejb.entity.RMemberMemberGroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface RMemberMemberGroupFacadeLocal {

    void create(RMemberMemberGroup rMemberMemberGroup);

    void edit(RMemberMemberGroup rMemberMemberGroup);

    void remove(RMemberMemberGroup rMemberMemberGroup);

    RMemberMemberGroup find(Object id);

    List<RMemberMemberGroup> findAll();

    List<RMemberMemberGroup> findRange(int[] range);

    int count();
    
}
