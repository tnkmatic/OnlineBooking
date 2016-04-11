/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var MstService = function(mstEmployService, mstCourseService) {
    var mstEmployList;
    var mstCourseList;
    
    //雇用形態マスタの内容取得
    mstEmployService.get(null, function(responseBody) {
        mstEmployList = responseBody.mstEmploys;
    });
    //コースマスタの内容取得
    mstCourseService.get(null, function(responseBody) {
        mstCourseList = responseBody.mstCourses;
    });
    // 雇用形態マスタのオブジェクトを返却
    this.getEmployList = function() {
        return mstEmployList;
    };
    // コースマスタのオブジェクトを返却
    this.getCourseList = function() {
        return mstCourseList;
    };
};