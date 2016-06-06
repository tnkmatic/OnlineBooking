/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource.response.businesshours;

import com.tnkmatic.onlinebooking.ejb.dto.BusinessHoursResponseDto;

/**
 *
 * @author tnkmatic
 */
public class BusinessHoursResponse {
    private BusinessHoursResponseDto businessHours;

    public BusinessHoursResponseDto getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(BusinessHoursResponseDto businessHours) {
        this.businessHours = businessHours;
    }
}
