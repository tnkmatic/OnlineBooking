/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * factoryメソッドでは共有するオブジェクトや関数を返す関数を登録(memberService)
 */
angular.module('onlineBookingModule')
        .value('onlineBookingUri', 
                'http://localhost:8080/OnlineBooking-web/onlinebooking/')
        .factory('memberService', ['$resource', 'onlineBookingUri',
                function($resource, onlineBookingUri) {
                    return $resource(
                            onlineBookingUri + 'members/:memberId', 
                            {memberId: '@id'});
                }
        ])
        .factory('mstEmployService', ['$resource', 'onlineBookingUri',
                function($resource, onlineBookingUri) {
                    return $resource(
                            onlineBookingUri + 'mstemploys/:employKbn',
                            {employKbn: '@id'});
                }
        ])
        .factory('mstCourseService', ['$resource', 'onlineBookingUri',
                function($resource, onlineBookingUri) {
                    return $resource(
                                onlineBookingUri + 'mstcourses/:courseId',
                                {courseId: '@id'});
                }
        ])
        .service('stringUtilService', [StringUtilService])
        .service('mstService', ['mstEmployService', 'mstCourseService', MstService])
//        .service('memberService', ['$resource', '$rootScope', MemberService])
;