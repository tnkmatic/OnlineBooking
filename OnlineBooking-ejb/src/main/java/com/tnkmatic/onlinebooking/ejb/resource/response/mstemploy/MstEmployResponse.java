/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource.response.mstemploy;

import com.tnkmatic.onlinebooking.ejb.entity.MstEmploy;
import java.util.List;

/**
 *
 * @author tnkmatic
 */
public class MstEmployResponse {
    private MstEmploy mstEmploy;
    private List<MstEmploy> mstEmploys;

    public MstEmploy getMstEmploy() {
        return mstEmploy;
    }

    public void setMstEmploy(MstEmploy mstEmploy) {
        this.mstEmploy = mstEmploy;
    }

    public List<MstEmploy> getMstEmploys() {
        return mstEmploys;
    }

    public void setMstEmploys(List<MstEmploy> mstEmploys) {
        this.mstEmploys = mstEmploys;
    }
}
