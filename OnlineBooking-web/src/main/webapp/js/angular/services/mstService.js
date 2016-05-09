/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var MstService = function(mstEmployService, mstCourseService) {
    var mstEmployList = null;
    var mstCourseList = null;

    // 雇用形態マスタのオブジェクトを返却
    this.getEmployList = function(list) {
        if (mstEmployList === null) {
            //雇用形態マスタの内容取得
            mstEmployService.get(null, function(responseBody) {
                console.log(responseBody.mstEmploys);
                mstEmployList = responseBody.mstEmploys;
                list = mstEmployList;
            });            
        } else {
            list = mstEmployList;
        }
    };
    // コースマスタのオブジェクトを返却
    this.getCourseList = function(list) {
        if (mstCourseList === null) {
            //コースマスタの内容取得
            mstCourseService.get(null, function(responseBody) {
                console.log(responseBody.mstCourses);
                mstCourseList = responseBody.mstCourses;
                list = mstCourseList;
            });
        } else {
            list = mstCourseList;
        }
    };
};