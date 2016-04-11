/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module('onlineBookingModule', ['ngMessages', 'ngResource', 
        'ui.grid', 'ui.grid.selection', 'ui.grid.pagination', 'ui.grid.exporter',
        'ui.grid.resizeColumns',
        'onlineBookingRouteModule'])
        //各サービスインスタンスが生成される前の設定を実行
        .config(['$resourceProvider',    
            function($resourceProvider) {
                //リソースキーを指定しなかった場合にURL末尾に/を付与するかどうか
                //$resourceProvider.defaults.stripTrailingSlashes = true;
            }])
        //すべてのモジュールの読み込み完了後に実行される(モジュール全体の初期処理を実行)
        .run(
            function($rootScope) {

            });