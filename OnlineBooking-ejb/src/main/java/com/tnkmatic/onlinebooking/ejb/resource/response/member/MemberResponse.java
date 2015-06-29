/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource.response.member;

import java.util.List;

/**
 *
 * @author Eiichi
 */
public class MemberResponse {
    private MemberResponseDetail member;
    private List<MemberResponseDetail> members;

    public MemberResponseDetail getMember() {
        return member;
    }

    public void setMember(MemberResponseDetail member) {
        this.member = member;
    }
    
    public List<MemberResponseDetail> getMembers() {
        return members;
    }

    public void setMembers(List<MemberResponseDetail> members) {
        this.members = members;
    }

}
