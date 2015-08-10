/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('onlineBookingModule').controller('memberRegistController', 
        function($scope) {
            //メンバ追加用のモデル
            $scope.member = {};
            
            //submit
            $scope.submit = function() {
                //TODO サーバへの通信処理を記述（メンバー登録処理）
            };
});