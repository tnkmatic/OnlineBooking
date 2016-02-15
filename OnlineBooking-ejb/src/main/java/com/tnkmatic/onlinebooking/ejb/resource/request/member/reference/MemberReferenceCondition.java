/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource.request.member.reference;

import com.tnkmatic.onlinebooking.ejb.common.ConstantValue;
import javax.ws.rs.QueryParam;

/**
 *
 * @author tnkmatic@outlook.jp
 */
public class MemberReferenceCondition {
    @QueryParam(ConstantValue.MEMBER_CONDITION_LOGIN_ID)
    private String loginId;
    @QueryParam(ConstantValue.MEMBER_CONDITION_FIRST_NAME)
    private String firstName;
    @QueryParam(ConstantValue.MEMBER_CONDITION_LAST_NAME)
    private String lastName;
    @QueryParam(ConstantValue.MEMBER_GROUP_KBN)
    private String memberGroupKbn;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMemberGroupKbn() {
        return memberGroupKbn;
    }

    public void setMemberGroupKbn(String memberGroupKbn) {
        this.memberGroupKbn = memberGroupKbn;
    }
}
