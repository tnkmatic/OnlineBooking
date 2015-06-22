/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.service;

import com.tnkmatic.onlinebooking.ejb.entity.BookingMember;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.reference.MemberReferenceCondition;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.register.MemberRegisterRequest;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eiichi
 */
@Local
public interface MemberServiceLocal {
    public BookingMember memberRegist(MemberRegisterRequest memberRegister) throws Exception;
    public List<BookingMember> memberReference(MemberReferenceCondition memberCondition) throws Exception;
}
