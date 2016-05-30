/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource;

import com.tnkmatic.onlinebooking.ejb.common.ConstantValue;
import com.tnkmatic.onlinebooking.ejb.entity.MstBusinessHours;
import com.tnkmatic.onlinebooking.ejb.resource.response.mstbusinesshours.MstBusinessHoursResponse;
import com.tnkmatic.onlinebooking.ejb.service.MstCommonServiceLocal;
import com.tnkmatic.onlinebooking.ejb.util.ResourceUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author tnkmatic
 */
@Stateless
@LocalBean
@Path("mstbusinesshours")
public class MstBusinessHoursResource extends BaseResource {
    @EJB MstCommonServiceLocal mstCommonService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";" + ConstantValue.ENCODING)
    public Response referenceMstBusinessHours() throws Exception {
        Response response = null;
        try {
            //営業時間マスタの取得(テーブルには1件のみ登録されている想定)
            List<MstBusinessHours> mstBusinessHoursList = 
                    mstCommonService.mstBusinessHoursSelectAll();
            //2件以上検索された場合はエラー
            if (mstBusinessHoursList.size() > 1) {
                throw new javax.ws.rs.InternalServerErrorException(
                        "営業日マスタに2件以上レコードが存在",
                        Response.status(
                                Response.Status.INTERNAL_SERVER_ERROR).build());
            }
            //レスポンスボディの編集
            
            // TODO PKオブジェクトをクライアントに意識させないためにオブジェクトの詰め替えを行う
            // BeanUtilsの例外ハンドリングについていまいちだったので、setMstBusinessHoursの内容を見直し
            // Controllerに直接コーディングするように修正する。            
            
            MstBusinessHoursResponse mstBusinessHoursResponse = new MstBusinessHoursResponse();
            mstBusinessHoursResponse.setMstBusinessHours(mstBusinessHoursList.get(0));
            
            
            //レスポンス生成
            response = ResourceUtil.createResponse(Response.Status.OK, 
                    MediaType.APPLICATION_JSON, null, null, mstBusinessHoursResponse);
        } catch (Exception e) {
            throw new javax.ws.rs.InternalServerErrorException(
                    Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(), e);
        }
        return response;
    }

}
