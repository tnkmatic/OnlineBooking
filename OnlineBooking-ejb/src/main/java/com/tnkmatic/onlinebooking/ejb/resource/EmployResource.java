/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource;

import com.tnkmatic.onlinebooking.ejb.common.ConstantValue;
import com.tnkmatic.onlinebooking.ejb.entity.MstEmploy;
import com.tnkmatic.onlinebooking.ejb.resource.response.employ.EmployResponse;
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
@Path("employs")
public class EmployResource extends BaseResource {
    @EJB MstCommonServiceLocal mstCommonService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";" + ConstantValue.ENCODING)
    public Response referenceMstEmploy() throws Exception {
        Response response = null;
        try {
            //雇用形態マスタの全件取得
            List<MstEmploy> mstEmployList = mstCommonService.mstEmploySelectAll();
            //レスポンスボディの編集
            EmployResponse mstEmployReponse = new EmployResponse();
            mstEmployReponse.setMstEmploys(mstEmployList);
            //レスポンス生成
            response = ResourceUtil.createResponse(
                    Response.Status.OK, MediaType.APPLICATION_JSON, 
                    null, null, mstEmployReponse);
            
        } catch (Exception e) {
            throw new javax.ws.rs.InternalServerErrorException(
                    Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(), e);
        }
        return response;
    }
}
