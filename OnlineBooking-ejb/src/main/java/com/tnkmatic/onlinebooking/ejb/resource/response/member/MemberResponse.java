/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource.response.member;

import com.tnkmatic.onlinebooking.ejb.entity.BookingMember;

/**
 *
 * @author Eiichi
 */
public class MemberResponse {
    private BookingMember member;

    public BookingMember getMember() {
        return member;
    }

    public void setMember(BookingMember member) {
        this.member = member;
    }
}
