/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource;

import com.tnkmatic.onlinebooking.ejb.common.ConstantValue;
import com.tnkmatic.onlinebooking.ejb.entity.MstCourse;
import com.tnkmatic.onlinebooking.ejb.resource.response.mstcourse.MstCourseResponse;
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
@Path("mstcourses")
public class MstCourseResource {
    @EJB MstCommonServiceLocal mstCommonService;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";" + ConstantValue.ENCODING)
    public Response referenceMstCourse() throws Exception {
        Response response = null;
        try {
            //コースマスタの全件取得
            List<MstCourse> mstCourseList = mstCommonService.mstCourseSelectAll();
            //レスポンスボディの編集
            MstCourseResponse mstCourseResponse = new MstCourseResponse();
            mstCourseResponse.setMstCourseList(mstCourseList);
            //レスポンス生成
            response = ResourceUtil.createResponse(
                    Response.Status.OK, MediaType.APPLICATION_JSON, 
                    null, null, mstCourseResponse);
            
        } catch (Exception e) {
            throw new javax.ws.rs.InternalServerErrorException(
                    Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(), e);
            
        }
        return response;
    }
    
}
