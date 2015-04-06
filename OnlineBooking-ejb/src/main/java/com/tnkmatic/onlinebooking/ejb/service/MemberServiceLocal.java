/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.service;

import com.tnkmatic.onlinebooking.ejb.resource.request.member.MemberRegisterRequest;
import java.lang.reflect.InvocationTargetException;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface MemberServiceLocal {
    public void memberRegist(MemberRegisterRequest memberRegister) throws IllegalAccessException, InvocationTargetException;
}
