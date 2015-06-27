/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource.response.member;

import com.tnkmatic.onlinebooking.ejb.entity.BookingMember;

/**
 *
 * @author tnkmatic@outlook.jp
 */
public class MemberResponseDetail extends BookingMember {
    private Integer recid;

    public Integer getRecid() {
        return recid;
    }

    public void setRecid(Integer recid) {
        this.recid = recid;
    }
    
}
