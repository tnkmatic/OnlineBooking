/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var onlineBookingModule = angular.module(
        'onlineBookingModule', ['ngMessages', 'ngResource', 'onlineBookingRouteModule']);

onlineBookingModule
        //$resourceProvider設定
        .config(['$resourceProvider',    
            function($resourceProvider) {
                //リソースキーを指定しなかった場合にURL末尾に/を付与するかどうか
                //$resourceProvider.defaults.stripTrailingSlashes = true;
            }]);

/*
 * アプリケーション共通変数定義
 */
var onlineBookingResourceDomain = 'http://localhost:8080/OnlineBooking-web/onlinebooking/';