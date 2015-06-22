/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource;

import com.tnkmatic.onlinebooking.ejb.common.ConstantValue;
import com.tnkmatic.onlinebooking.ejb.entity.MemberGroup;
import com.tnkmatic.onlinebooking.ejb.service.MemberGroupServiceLocal;
import com.tnkmatic.onlinebooking.ejb.util.ResourceUtil;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Eiichi
 */
@RequestScoped
@Path("membergroups")
public class MemberGroupResource {
    @EJB MemberGroupServiceLocal memberGroupService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";" + ConstantValue.ENCODING)
    public Response referenceMemberGroup() throws Exception {
        Response response = null;
        
        try {
            // TODO バリデーションチェック
            
            // メンバーグループの取得
            List<MemberGroup> memberGroupList =
                    memberGroupService.selectMemberGroupList();
            //レスポンス生成
            response = ResourceUtil.createResponse(
                    Response.Status.OK, MediaType.APPLICATION_JSON, 
                    null, null, memberGroupList);
        } catch (Exception e) {
            throw new javax.ws.rs.InternalServerErrorException(
                    Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(), e);
            
        }
        return response;
    }
}