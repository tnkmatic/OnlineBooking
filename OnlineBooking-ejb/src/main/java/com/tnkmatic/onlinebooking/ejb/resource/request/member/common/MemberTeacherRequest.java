/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.resource.request.member.common;

import java.util.Date;

/**
 *
 * @author Eiichi
 */
public class MemberTeacherRequest {
    private String employKbn;
    private Date employYmdFrom;
    private Date employYmdTo;

    public String getEmployKbn() {
        return employKbn;
    }

    public void setEmployKbn(String employKbn) {
        this.employKbn = employKbn;
    }

    public Date getEmployYmdFrom() {
        return employYmdFrom;
    }

    public void setEmployYmdFrom(Date employYmdFrom) {
        this.employYmdFrom = employYmdFrom;
    }

    public Date getEmployYmdTo() {
        return employYmdTo;
    }

    public void setEmployYmdTo(Date employYmdTo) {
        this.employYmdTo = employYmdTo;
    }
}
