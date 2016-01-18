/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var onlineBookingModule = angular.module(
        'onlineBookingModule', 
        ['ngMessages', 'ngResource', 
            'ui.grid', 'ui.grid.pagination', 'ui.grid.exporter',
            'onlineBookingRouteModule']);

onlineBookingModule
        //各サービスインスタンスが生成される前の設定を実行
        .config(['$resourceProvider',    
            function($resourceProvider) {
                //リソースキーを指定しなかった場合にURL末尾に/を付与するかどうか
                //$resourceProvider.defaults.stripTrailingSlashes = true;
            }])
        //すべてのモジュールの読み込み完了後に実行される(モジュール全体の初期処理を実行)
        .run(
            function($rootScope) {
                $rootScope.onlineBookingUri = 
                        'http://localhost:8080/OnlineBooking-web/onlinebooking/members/:memberId';
            })
;