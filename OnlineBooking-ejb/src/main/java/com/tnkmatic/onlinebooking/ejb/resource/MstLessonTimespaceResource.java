/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource;

import com.tnkmatic.onlinebooking.ejb.common.ConstantValue;
import com.tnkmatic.onlinebooking.ejb.entity.MstBusinessHours;
import com.tnkmatic.onlinebooking.ejb.service.MstCommonServiceLocal;
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
    public Response referenceMstLessonTimeSpace() throw Exception {
        Response response = null;
        try {
            //営業時間マスタの全件取得
            List<MstBusinessHours> mstBusinessList = 
                    mstCommonService.mstBusinessHoursSelectAll();
            //レスポンスボディの編集
            
            
        } catch (Exception e) {
            
        }
        
        return null;
    }
}
