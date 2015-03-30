/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.resource.request;

import com.tnkmatic.onlinebooking.ejb.resource.request.member.MemberRegister;

/**
 *
 * @author Eiichi
 */
public class MemberRequest {
    private MemberRegister memberRegister;

    public MemberRegister getMemberRegister() {
        return memberRegister;
    }

    public void setMemberRegister(MemberRegister memberRegister) {
        this.memberRegister = memberRegister;
    }
}
