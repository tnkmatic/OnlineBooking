/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * factoryメソッドでは共有するオブジェクトや関数を返す関数を登録(memberService)
 */
angular.module('onlineBookingModule').factory(
        'memberService', ['$resource', '$scope', function($resource, $scope) {
    //サービスの実装(DI経由で共有するオブジェクトの返却)
    return new app.memberService($resource, $scope);
}]);