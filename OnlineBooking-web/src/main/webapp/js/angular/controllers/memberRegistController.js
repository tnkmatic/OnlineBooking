/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('onlineBookingModule').controller('memberRegistController', 
        function($scope) {
            //メンバ追加用のモデル
            $scope.member = {};
            
            //画面制御用
            $scope.contactWayKbnTelChecked = true;
            $scope.contactWayKbnEmailChecked = !$scope.contactWayKbnTelChecked;
            
            //連絡方法区分のラジオボタン切り替え(電話番号)
            $scope.contactWayKbnOn = function(compareValue) {
                return !($scope.member.contactWayKbn === compareValue);
            };
            
            //submit
            $scope.submit = function() {
                //TODO サーバへの通信処理を記述（メンバー登録処理）
            };
});