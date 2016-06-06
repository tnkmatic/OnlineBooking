/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.dto;

/**
 *
 * @author tnkmatic
 */
public class BusinessHoursResponseDto {
    private String businessHoursFrom;
    private String businessHoursTo;

    public String getBusinessHoursFrom() {
        return businessHoursFrom;
    }

    public void setBusinessHoursFrom(String businessHoursFrom) {
        this.businessHoursFrom = businessHoursFrom;
    }

    public String getBusinessHoursTo() {
        return businessHoursTo;
    }

    public void setBusinessHoursTo(String businessHoursTo) {
        this.businessHoursTo = businessHoursTo;
    }
    
    
}
