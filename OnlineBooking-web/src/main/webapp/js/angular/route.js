/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var onlineBookingRouteModule = angular.module(
        'onlineBookingRouteModule', ['ngRoute']);

onlineBookingRouteModule.config(['$routeProvider',
    function($routeProvider) {
        //ルーティング設定
        $routeProvider
                .when('/member/regist', {
                    templateUrl: './member/views/memberRegist.html',
                    //template: '<h1>TEST</h1>'
                    controller: 'memberController'
                })
                .when('/member', {
                    templateUrl: './member/views/member.html',
                    controller: 'memberController'
                })
                .otherwise({
                   redirectTo: '/member' 
                });
        
    }
]);