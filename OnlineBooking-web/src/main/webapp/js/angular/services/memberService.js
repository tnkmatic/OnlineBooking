/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//memberリソース用オブジェクト
var MemberResource = {};

//コンストラクタ
var MemberService = function($resource, $rootScope) {
    this.$resource = $resource;
    //Memberリソース用のインスタンスを取得
    MemberResource = this.$resource(
        $rootScope.onlineBookingUri, {memberId: '@id'});    //'@idはデフォルト'
};

//プロトタイプの取得
var prototype = MemberService.prototype;

//メンバー登録
prototype.memberRegist = function($scope) {
    //サーバリクエストオブジェクトの生成
    var memberResource = new MemberResource({memberRegister: $scope.member}); //memberRegisterRequest
    //サーバリクエスト(メンバー登録)
    memberResource.$save()
            .then(function success(result) {
                $scope.debug.statusCode = result.status;
                $scope.debug.data = result.data;
    });
};

//メンバー参照(検索)
prototype.memberReference = function(memberCondition) {
    //サーバリクエストオブジェクトの生成
    //var memberResource = new MemberResource({memberCondition: memberCondition});
    //サーバリクエスト(メンバー参照(検索))
    //return memberResource.$get(memberCondition);

    MemberResource.$get(memberCondition)
            .then(function success(result) {
                return result;
    });
    
    //MemberResource.$get is not a function が不明
};