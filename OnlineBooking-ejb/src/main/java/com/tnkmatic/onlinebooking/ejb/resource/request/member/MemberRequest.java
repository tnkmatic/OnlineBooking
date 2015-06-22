/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.resource.request.member;

import com.tnkmatic.onlinebooking.ejb.resource.request.member.register.MemberRegisterRequest;

/**
 *
 * @author Eiichi
 */
public class MemberRequest {
    private MemberRegisterRequest memberRegister;

    public MemberRegisterRequest getMemberRegister() {
        return memberRegister;
    }

    public void setMemberRegister(MemberRegisterRequest memberRegister) {
        this.memberRegister = memberRegister;
    }
}
