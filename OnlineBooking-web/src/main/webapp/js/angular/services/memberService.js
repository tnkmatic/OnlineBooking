/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//memberリソース用オブジェクト
var MemberResource = {};
var uri = onlineBookingResourceDomain + 'members/:memberId';
var resourcekey = {memberId: '@id'};
var condition = {};

//コンストラクタ
var MemberService = function($resource) {
    this.$resource = $resource;
    //Memberリソース用のインスタンスを取得
    MemberResource = this.$resource(
        onlineBookingResourceDomain + 'members/:memberId', {memberId: '@id'});
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
    
    var members = MemberResource.get({loginId: memberCondition.loginId}, function(){
        members.firstName = memberCondition.firstName;
        members.$get();
    });
    
    return members;
};