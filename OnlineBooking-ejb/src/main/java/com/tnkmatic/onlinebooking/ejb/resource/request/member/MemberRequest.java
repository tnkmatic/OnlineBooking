/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.resource.request.member;

import com.tnkmatic.onlinebooking.ejb.resource.request.member.register.MemberRegisterRequest;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.update.MemberUpdateRequest;
import java.util.List;

/**
 *
 * @author Eiichi
 */
public class MemberRequest {
    private MemberRegisterRequest memberRegister;
    private List<MemberUpdateRequest> memberUpdates;

    public MemberRegisterRequest getMemberRegister() {
        return memberRegister;
    }

    public void setMemberRegister(MemberRegisterRequest memberRegister) {
        this.memberRegister = memberRegister;
    }

    public List<MemberUpdateRequest> getMemberUpdates() {
        return memberUpdates;
    }

    public void setMemberUpdates(List<MemberUpdateRequest> memberUpdates) {
        this.memberUpdates = memberUpdates;
    }
}
