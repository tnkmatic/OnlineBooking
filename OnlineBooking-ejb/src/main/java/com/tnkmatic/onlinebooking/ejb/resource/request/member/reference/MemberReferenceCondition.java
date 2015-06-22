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

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
