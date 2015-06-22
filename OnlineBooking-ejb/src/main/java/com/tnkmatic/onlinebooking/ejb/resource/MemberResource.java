/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.resource;

import com.tnkmatic.onlinebooking.ejb.common.ConstantValue;
import com.tnkmatic.onlinebooking.ejb.entity.BookingMember;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.MemberRequest;
import com.tnkmatic.onlinebooking.ejb.resource.response.member.MemberResponse;
import com.tnkmatic.onlinebooking.ejb.service.MemberServiceLocal;
import com.tnkmatic.onlinebooking.ejb.util.ResourceUtil;
import java.util.Arrays;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Eiichi
 */
@RequestScoped
@Path("members")
public class MemberResource extends BaseResource {
    @EJB private MemberServiceLocal memberService;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";" + ConstantValue.ENCODING)
    @Produces(MediaType.APPLICATION_JSON + ";" + ConstantValue.ENCODING)
    @RolesAllowed({"administratorsRole"})
    public Response memberRegist(final MemberRequest memberRequest) throws Exception {
        Response response = null;
        
        try {
            // TODO バリデーションチェック

            // 登録対象メンバーの永続化
            final BookingMember bookingMember = 
                    memberService.memberRegist(memberRequest.getMemberRegister());            
            // レスポンス生成
            MemberResponse memberResponse = new MemberResponse();
            memberResponse.setMember(bookingMember);
            response = ResourceUtil.createResponse(Response.Status.CREATED, MediaType.APPLICATION_JSON, 
                    uriInfo, Arrays.asList(bookingMember.getMemberId().toString()),
                    bookingMember);
        } catch (Exception e) {
            throw new javax.ws.rs.InternalServerErrorException(
                    Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(), e);
        }
        
        return response;
    }
}
