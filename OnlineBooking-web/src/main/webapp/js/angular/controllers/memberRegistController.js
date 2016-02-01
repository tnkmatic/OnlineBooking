/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('onlineBookingModule').controller('memberRegistController',
    ['$scope', 'memberService', function($scope, memberService) {
        //メンバ追加用のモデル
        $scope.member = {};
        
        //デバッグ用のモデル
        $scope.debug = {};
        
        // 表示対象の管理
       $scope.show = {
           entry : true,
           confirm  : false,
           complete : false
       };

        //画面制御用
        $scope.contactWayKbnTelChecked = true;
        $scope.contactWayKbnEmailChecked = !$scope.contactWayKbnTelChecked;

        //連絡方法区分のラジオボタン切り替え(電話番号)
        $scope.contactWayKbnOn = function(compareValue) {
            return !($scope.member.contactWayKbn === compareValue);
        };
        
        //入力画面への遷移(entry)
        $scope.entry = function() {
            $scope.changePage('entry');
        };
        
        //確認画面への遷移(confirm)
        $scope.confirm = function() {
            $scope.changePage('confirm');
        };

        //メンバー登録(submit)
        $scope.submit = function() {
            //memberServiceを介してメンバー登録
            memberService.save({memberRegister: $scope.member});
            //完了画面の表示
            $scope.changePage('complete');
        };
        
        // 表示対象を変更する
       $scope.changePage = function(type) {
           for (var name in $scope.show) {
               if (name === type) {
                   $scope.show[name] = true;
               } else {
                   $scope.show[name] = false;
               }
           }
       };
    }]
);