/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module(
        'onlineBookingModule', ['ngMessages', 'ngResource']);

//$resourceProvider設定
app.config([
    '$resourceProvider',
    function($resourceProvider) {
        //リソースキーを指定しなかった場合にURL末尾に/を付与するかどうか
        $resourceProvider.defaults.stripTrailingSlashes = true;
    }]);