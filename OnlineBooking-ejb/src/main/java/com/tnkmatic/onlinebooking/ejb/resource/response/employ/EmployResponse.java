/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource.response.employ;

import com.tnkmatic.onlinebooking.ejb.entity.MstEmploy;
import java.util.List;

/**
 *
 * @author tnkmatic
 */
public class EmployResponse {
    private MstEmploy employ;
    private List<MstEmploy> employs;

    public MstEmploy getMstEmploy() {
        return employ;
    }

    public void setMstEmploy(MstEmploy mstEmploy) {
        this.employ = mstEmploy;
    }

    public List<MstEmploy> getMstEmploys() {
        return employs;
    }

    public void setMstEmploys(List<MstEmploy> mstEmploys) {
        this.employs = mstEmploys;
    }
}
