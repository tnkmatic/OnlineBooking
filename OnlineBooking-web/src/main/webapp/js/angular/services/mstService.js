/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var MstService = function(mstEmployService) {
    var mstEmployList;
    mstEmployService.get(null, function(responseBody) {
        mstEmployList = responseBody.mstEmploys;
    });
    // 雇用形態マスタのオブジェクトを返却
    this.getEmployList = function() {
        return mstEmployList;
    };
};


