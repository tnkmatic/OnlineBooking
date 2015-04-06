/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.dao;

import com.tnkmatic.onlinebooking.ejb.entity.MemberGroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface MemberGroupFacadeLocal {

    void create(MemberGroup memberGroup);

    void edit(MemberGroup memberGroup);

    void remove(MemberGroup memberGroup);

    MemberGroup find(Object id);

    List<MemberGroup> findAll();

    List<MemberGroup> findRange(int[] range);

    int count();
    
}
