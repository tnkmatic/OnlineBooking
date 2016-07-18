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
                            {memberId: '@id'},
                            {update: {method: 'PUT'}});
                }
        ])
        //雇用形態マスタサービス
        .factory('employService', ['$resource', '$cacheFactory', '$q', 'onlineBookingUri',
                function($resource, $cacheFactory, $q, onlineBookingUri) {
                    //$resourceのcacheプロパティによるキャッシュが動作しなかったため
                    //独自にキャッシュを実装
                    var cache = $cacheFactory('employService');
                    var Employs = $resource(
                            onlineBookingUri + 'employs/:employKbn',
                            {employKbn: '@id'});
                    return {
                        getCachedAllResource: function() {
                            //プロミスのdeferredインスタンスを生成
                            var deferrd = $q.defer();
                            //キャッシュからドロップダウンの一覧を取得
                            var employList = cache.get('all');
                            if (!employList) {
                                Employs.get(null, function(responseBody) {
                                    employList = responseBody.employs;
                                    cache.put('all', employList);
                                    //プロミスに処理成功時のオブジェクトを設定
                                    deferrd.resolve(employList);
                                });
                            } else {
                                //プロミスに処理成功時のオブジェクトを設定
                                deferrd.resolve(employList);
                            }
                            //呼び出し元にプロミスオブジェクトを返す
                            return deferrd.promise;
                        }
                    };
                }
        ])
        //コースマスタサービス
        .factory('courseService', ['$resource', '$cacheFactory', '$q', 'onlineBookingUri',
                function($resource, $cacheFactory, $q, onlineBookingUri) {
                    //$resourceのcacheプロパティによるキャッシュが動作しなかったため
                    //独自にキャッシュを実装
                    var cache = $cacheFactory('courseService');
                    var Courses = $resource(
                            onlineBookingUri + 'courses/:courseId',
                            {courseId: '@id'});
                    return {
                        getCachedAllResource: function() {
                            //プロミスのdeferredインスタンスを生成
                            var deferrd = $q.defer();
                            //キャッシュからドロップダウンの一覧を取得
                            var courseList = cache.get('all');
                            if (!courseList) {
                                Courses.get(null, function(responseBody) {
                                    courseList= responseBody.courses;
                                    cache.put('all', courseList);
                                    //プロミスに処理成功時のオブジェクトを設定
                                    deferrd.resolve(courseList);
                                });
                            } else {
                                //プロミスに処理成功時のオブジェクトを設定
                                deferrd.resolve(courseList);
                            }
                            //呼び出し元にプロミスオブジェクトを返す
                            return deferrd.promise;
                        }
                    };
                }
        ])
        //営業時間マスタサービス
        .factory('businessHoursService', ['$resource', '$cacheFactory', '$q', 'onlineBookingUri',
                function($resource, $cacheFactory, $q, onlineBookingUri) {
                    //$resourceのcacheプロパティによるキャッシュが動作しなかったため
                    //独自にキャッシュを実装
                    var cache = $cacheFactory('businessHoursService');
                    var BusinessHours = $resource(
                            onlineBookingUri + 'businesshours',{});
                    return {
                        getCachedAllResource: function() {
                            //プロミスのdeferredインスタンスを生成
                            var deferrd = $q.defer();
                            //キャッシュから取得
                            var businessHours = cache.get('record');
                            if (!businessHours) {
                                BusinessHours.get(null, function(responseBody) {
                                    businessHours= responseBody.businessHours;
                                    cache.put('record', businessHours);
                                    //プロミスに処理成功時のオブジェクトを設定
                                    deferrd.resolve(businessHours);
                                });
                            } else {
                                //プロミスに処理成功時のオブジェクトを設定
                                deferrd.resolve(businessHours);
                            }
                            //呼び出し元にプロミスオブジェクトを返す
                            return deferrd.promise;
                        }
                    };
                }
        ])
        //授業時間間隔マスタ
        .factory('lessonTimespacesService', ['$resource', '$cacheFactory', '$q', 'onlineBookingUri',
                function($resource, $cacheFactory, $q, onlineBookingUri) {
                    //$resourceのcacheプロパティによるキャッシュが動作しなかったため
                    //独自にキャッシュを実装
                    var cache = $cacheFactory('lessonTimespacesService');
                    var LessonTimeSpaces = $resource(
                            onlineBookingUri + 'lessontimespaces',{});
                    return {
                        getCachedAllResource: function() {
                            //プロミスのdeferredインスタンスを生成
                            var deferrd = $q.defer();
                            //キャッシュから取得
                            var lessonTimeSpaces = cache.get('record');
                            if (!lessonTimeSpaces) {
                                LessonTimeSpaces.get(null, function(responseBody) {
                                    lessonTimeSpaces = responseBody.lessonTimeSpace;
                                    cache.put('record', lessonTimeSpaces);
                                    //プロミスに処理成功時のオブジェクトを設定
                                    deferrd.resolve(lessonTimeSpaces);
                                });
                            } else {
                                //プロミスに処理成功時のオブジェクトを設定
                                deferrd.resolve(lessonTimeSpaces);
                            }
                            //呼び出し元にプロミスオブジェクトを返す
                            return deferrd.promise;
                        }
                    };
                }
        ])
        .service('stringUtilService', [StringUtilService])
//        .service('mstService', ['mstEmployService', 'mstCourseService', MstService])
//        .service('memberService', ['$resource', '$rootScope', MemberService])
;