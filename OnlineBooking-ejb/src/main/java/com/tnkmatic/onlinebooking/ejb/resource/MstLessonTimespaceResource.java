/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource;

import com.tnkmatic.onlinebooking.ejb.common.ConstantValue;
import com.tnkmatic.onlinebooking.ejb.entity.MstLessonTimespace;
import com.tnkmatic.onlinebooking.ejb.resource.response.mstlessontimespace.MstLessonTimespaceResponse;
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
@Path("mstlessontimespaces")
public class MstLessonTimespaceResource {
    @EJB MstCommonServiceLocal mstCommonService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";" + ConstantValue.ENCODING)
    public Response referenceMstLessonTimeSpace() throws Exception {
        Response response = null;
        try {
            //営業時間マスタの全件取得
            List<MstLessonTimespace> mstLessonTimespaceList = 
                    mstCommonService.mstLessonTimespaceSelectAll();
            //2件以上検索された場合はエラー
            if (mstLessonTimespaceList.size() > 1) {
                throw new javax.ws.rs.InternalServerErrorException(
                        "授業時間間隔マスタに2件以上レコードが存在",
                        Response.status(
                                Response.Status.INTERNAL_SERVER_ERROR).build());
            }
            //レスポンスボディの編集
            MstLessonTimespaceResponse mstLessonTimespaceResponse = new MstLessonTimespaceResponse();
            mstLessonTimespaceResponse.setMstLessonTimeSpace(mstLessonTimespaceList.get(0));
            //レスポンス生成
            response = ResourceUtil.createResponse(
                    Response.Status.OK, MediaType.APPLICATION_JSON, 
                    null, null, mstLessonTimespaceResponse);      
        } catch (Exception e) {
            throw new javax.ws.rs.InternalServerErrorException(
                    Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(), e);
        }
        
        return response;
    }
}
