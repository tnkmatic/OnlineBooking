/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tnkmatic.onlinebooking.ejb.common.ConstantValue;
import java.util.List;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Eiichi
 */
public class ResourceUtil {
    public static Response createResponse(
            Response.Status responseStatus, String mediaType,
            UriInfo uriInfo, List<String> pathList, Object responseBodyBean) {
        Response response = null;
        
        // レスポンスボディの生成
        String responseBody = null;
        if (MediaType.APPLICATION_JSON.equals(mediaType)
                && responseBodyBean != null) {
            final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
            responseBody = gson.toJson(responseBodyBean);
        }

        // URIの生成
        UriBuilder uriBuilder = null;
        if (uriInfo != null) {
            uriBuilder = uriInfo.getAbsolutePathBuilder();
        }
        
        // レスポンスの生成
        switch(responseStatus) {
            case CREATED:
                // パスの生成
                for (String path : pathList) {
                    uriBuilder.path(path);
                }
                response = Response.created(uriBuilder.build())
                        .header(HttpHeaders.CONTENT_TYPE, 
                                mediaType + ";" + ConstantValue.RESPONSE_CHARSET_UTF8)
                        .entity(responseBody)
                        .build();
                break;
            case OK:
                response = Response.ok()
                        .header(HttpHeaders.CONTENT_TYPE, 
                                mediaType + ";" + ConstantValue.RESPONSE_CHARSET_UTF8)
                        .entity(responseBody)
                        .build();
                System.out.println(response.toString());
            default:
                break;
        }
        return response;
    }
}
