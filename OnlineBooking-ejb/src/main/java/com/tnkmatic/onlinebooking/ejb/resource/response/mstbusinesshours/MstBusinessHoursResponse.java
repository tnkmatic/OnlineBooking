/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource.response.mstbusinesshours;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author tnkmatic
 */
public class MstBusinessHoursResponse {
    private MstBusinessHours mstBusinessHours;

    public MstBusinessHours getMstBusinessHours() {
        return mstBusinessHours;
    }

    public void setMstBusinessHours(
            com.tnkmatic.onlinebooking.ejb.entity.MstBusinessHours entity) throws Exception {
        mstBusinessHours = new MstBusinessHours();
        try {
            BeanUtils.copyProperties(mstBusinessHours, entity.getMstBusinessHoursPK());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new Exception("営業時間マスタのプロパティコピーエラー", e);
        }
    }
}
