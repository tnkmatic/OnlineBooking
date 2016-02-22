/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * factoryメソッドでは共有するオブジェクトや関数を返す関数を登録(memberService)
 */
angular.module('onlineBookingModule')
        .factory('memberService', ['$resource', 
                function($resource) {
                    return $resource(
                            'http://localhost:8080/OnlineBooking-web/onlinebooking/members/:memberId', 
                            {memberId: '@id'});
                }
        ])
        .service('stringUtilService', [StringUtilService])
//        .service('memberService', ['$resource', '$rootScope', MemberService])
;