/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.resource;

import com.tnkmatic.onlinebooking.ejb.common.ConstantValue;
import com.tnkmatic.onlinebooking.ejb.entity.BookingMember;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.MemberRequest;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.reference.MemberReferenceCondition;
import com.tnkmatic.onlinebooking.ejb.resource.response.member.MemberResponse;
import com.tnkmatic.onlinebooking.ejb.resource.response.member.MemberResponseDetail;
import com.tnkmatic.onlinebooking.ejb.service.MemberServiceLocal;
import com.tnkmatic.onlinebooking.ejb.util.ResourceUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Eiichi
 */
@RequestScoped
@Path("members")
public class MemberResource extends BaseResource {
    private static final Logger LOG = Logger.getLogger(MemberResource.class.getName());
    
    
    @EJB private MemberServiceLocal memberService;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";" + ConstantValue.ENCODING)
    @Produces(MediaType.APPLICATION_JSON + ";" + ConstantValue.ENCODING)
    @RolesAllowed({"administratorsRole"})
    public Response memberRegist(final MemberRequest memberRequest) throws Exception {
        Response response = null;
        
        try {
            // TODO バリデーションチェック

            // 登録対象メンバー永続化
            final BookingMember bookingMember = 
                    memberService.memberRegist(memberRequest.getMemberRegister());            
            // レスポンスボディ編集
            MemberResponse memberResponse = new MemberResponse();
            MemberResponseDetail memberResponseDetail = new MemberResponseDetail();
            BeanUtils.copyProperties(memberResponseDetail, bookingMember);
            memberResponseDetail.setRecid(1);         
            memberResponse.setMember(memberResponseDetail);
            // レスポンス生成
            response = ResourceUtil.createResponse(Response.Status.CREATED, MediaType.APPLICATION_JSON, 
                    uriInfo, Arrays.asList(bookingMember.getMemberId().toString()),
                    memberResponse);
        } catch (Exception e) {
            throw new javax.ws.rs.InternalServerErrorException(
                    Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(), e);
        }
        
        return response;
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON + ";" + ConstantValue.ENCODING)
    @Produces(MediaType.APPLICATION_JSON + ";" + ConstantValue.ENCODING)
    public Response memgerReference(
            @BeanParam MemberReferenceCondition memberCondition) {
        Response response = null;
        
        try {
            // TODO バリデーションチェック(クエリパラメータ)

            // 登録メンバーの検索
            final List<BookingMember> bookingMemberList =
                    memberService.memberReference(memberCondition);
            // レスポンスボディ編集
            MemberResponse memberResponse = new MemberResponse();
            List<MemberResponseDetail> members = new ArrayList<>();
            memberResponse.setMembers(members);
            for (int i = 0; i < bookingMemberList.size(); i++) {
                final MemberResponseDetail memberResponseDetail = 
                        new MemberResponseDetail();
                BeanUtils.copyProperties(memberResponseDetail, bookingMemberList.get(i));
                memberResponseDetail.setRecid(i + 1);
                members.add(memberResponseDetail);
            }
            // レスポンス生成
            response = ResourceUtil.createResponse(
                    Response.Status.OK, 
                    MediaType.APPLICATION_JSON, 
                    null,
                    null,
                    memberResponse);
            LOG.log(Level.INFO, memberResponse.toString());
        } catch (Exception e) {
            throw new javax.ws.rs.InternalServerErrorException(
                    Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(), e);
        }
        
        return response;
    }
}
