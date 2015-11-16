/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('onlineBookingModule').controller('memberReferenceController',
    ['$scope', 'memberService', function($scope, memberService) {
        //メンバ検索用のモデル
        $scope.memberCondition = {};
        
        //メンバ検索結果用のモデル
        $scope.memberList = {};
        
        //メンバー参照(検索)
        $scope.reference = function() {
            //memberServiceを介して検索を実行
            memberService.memberReference($scope);
        };
    }]
);

