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
        //雇用形態マスタサービス
        .factory('mstEmployService', ['$resource', '$cacheFactory', '$q', 'onlineBookingUri',
                function($resource, $cacheFactory, $q, onlineBookingUri) {
                    //$resourceのcacheプロパティによるキャッシュが動作しなかったため
                    //独自にキャッシュを実装
                    var cache = $cacheFactory('mstEmployService');
                    var MstEmploys = $resource(
                            onlineBookingUri + 'mstemploys/:employKbn',
                            {employKbn: '@id'});
                    return {
                        getCachedAllResource: function() {
                            //プロミスのdeferredインスタンスを生成
                            var deferrd = $q.defer();
                            //キャッシュからドロップダウンの一覧を取得
                            var mstEmployList = cache.get('all');
                            if (!mstEmployList) {
                                MstEmploys.get(null, function(responseBody) {
                                    mstEmployList = responseBody.mstEmploys;
                                    cache.put('all', mstEmployList);
                                    //プロミスに処理成功時のオブジェクトを設定
                                    deferrd.resolve(mstEmployList);
                                });
                            } else {
                                //プロミスに処理成功時のオブジェクトを設定
                                deferrd.resolve(mstEmployList);
                            }
                            //呼び出し元にプロミスオブジェクトを返す
                            return deferrd.promise;
                        }
                    };
                }
        ])
        //コースマスタサービス
        .factory('mstCourseService', ['$resource', '$cacheFactory', '$q', 'onlineBookingUri',
                function($resource, $cacheFactory, $q, onlineBookingUri) {
                    //$resourceのcacheプロパティによるキャッシュが動作しなかったため
                    //独自にキャッシュを実装
                    var cache = $cacheFactory('mstCourseService');
                    var MstCourses = $resource(
                            onlineBookingUri + 'mstcourses/:courseId',
                            {courseId: '@id'});
                    return {
                        getCachedAllResource: function() {
                            //プロミスのdeferredインスタンスを生成
                            var deferrd = $q.defer();
                            //キャッシュからドロップダウンの一覧を取得
                            var mstCourseList = cache.get('all');
                            if (!mstCourseList) {
                                MstCourses.get(null, function(responseBody) {
                                    mstCourseList= responseBody.mstCourses;
                                    cache.put('all', mstCourseList);
                                    //プロミスに処理成功時のオブジェクトを設定
                                    deferrd.resolve(mstCourseList);
                                });
                            } else {
                                //プロミスに処理成功時のオブジェクトを設定
                                deferrd.resolve(mstCourseList);
                            }
                            //呼び出し元にプロミスオブジェクトを返す
                            return deferrd.promise;
                        }
                    };
                }
        ])
        //営業時間マスタサービス
        .factory('mstBusinessHoursService', ['$resource', '$cacheFactory', '$q', 'onlineBookingUri',
                function($resource, $cacheFactory, $q, onlineBookingUri) {
                    //$resourceのcacheプロパティによるキャッシュが動作しなかったため
                    //独自にキャッシュを実装
                    var cache = $cacheFactory('mstBusinessHoursService');
                    var MstBusinessHours = $resource(
                            onlineBookingUri + 'mstbusinesshours',{});
                    return {
                        getCachedAllResource: function() {
                            //プロミスのdeferredインスタンスを生成
                            var deferrd = $q.defer();
                            //キャッシュから取得
                            var mstBusinessHours = cache.get('record');
                            if (!mstBusinessHours) {
                                MstBusinessHours.get(null, function(responseBody) {
                                    mstBusinessHours= responseBody.mstBusinessHours;
                                    cache.put('record', mstBusinessHours);
                                    //プロミスに処理成功時のオブジェクトを設定
                                    deferrd.resolve(mstBusinessHours);
                                });
                            } else {
                                //プロミスに処理成功時のオブジェクトを設定
                                deferrd.resolve(mstBusinessHours);
                            }
                            //呼び出し元にプロミスオブジェクトを返す
                            return deferrd.promise;
                        }
                    };
                }
        ])
        //授業時間間隔マスタ
        .factory('mstLessonTimespacesService', ['$resource', '$cacheFactory', '$q', 'onlineBookingUri',
                function($resource, $cacheFactory, $q, onlineBookingUri) {
                    //$resourceのcacheプロパティによるキャッシュが動作しなかったため
                    //独自にキャッシュを実装
                    var cache = $cacheFactory('mstLessonTimespaceService');
                    var MstLessonTimeSpaces = $resource(
                            onlineBookingUri + 'mstlessontimespaces',{});
                    return {
                        getCachedAllResource: function() {
                            //プロミスのdeferredインスタンスを生成
                            var deferrd = $q.defer();
                            //キャッシュから取得
                            var mstLessonTimeSpaces = cache.get('record');
                            if (!mstLessonTimeSpaces) {
                                MstLessonTimeSpaces.get(null, function(responseBody) {
                                    mstLessonTimeSpaces = responseBody.mstLessonTimeSpace;
                                    cache.put('record', mstLessonTimeSpaces);
                                    //プロミスに処理成功時のオブジェクトを設定
                                    deferrd.resolve(mstLessonTimeSpaces);
                                });
                            } else {
                                //プロミスに処理成功時のオブジェクトを設定
                                deferrd.resolve(mstLessonTimeSpaces);
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