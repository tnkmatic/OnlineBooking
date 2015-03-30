/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.resource;

import com.tnkmatic.onlinebooking.ejb.common.ConstantValue;
import com.tnkmatic.onlinebooking.ejb.resource.request.MemberRequest;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Eiichi
 */
@RequestScoped
@Path("members")
public class MemberResource {
    @Context
    UriInfo uriInfo;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";" + ConstantValue.ENCODING)
    @Produces(MediaType.APPLICATION_JSON + ";" + ConstantValue.ENCODING)
    @RolesAllowed({"administratorsRole"})
    public Response memberRegist(final MemberRequest memberRequest) {
        // バリデーションチェック
        
        
        
        
        
        
//        URI uri = uriInfo.getAbsolutePathBuilder()
//                .path("999999").build();
//        
//        Response response = Response.created(uri)
//                .entity(memberRegister)
//                .build();
        
        return null;
    }
}
