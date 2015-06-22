/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.service;

import com.tnkmatic.onlinebooking.ejb.entity.MemberGroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface MemberGroupServiceLocal {
    public List<MemberGroup> selectMemberGroupList();
}
