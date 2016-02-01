/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//memberリソース用オブジェクト
//var MemberResource = {};

//コンストラクタ
var MemberService = function($resource, $rootScope) {
//    this.Member = $resource(
//            $rootScope.onlineBookingUri, {memberId: '@id'}, null);
    //this.memberReference = getMember;
    
    //Memberリソース用のインスタンスを取得
//    MemberResource = this.$resource(
//        $rootScope.onlineBookingUri, {memberId: '@id'});    //'@idはデフォルト'

    var Member = $resource(
            'http://localhost:8080/OnlineBooking-web/onlinebooking/members/:memberId', {memberId: '@id'}, null);
    
    var members;
    this.getMembers = function () {
        return members;
    };
    
    this.memberReference = function(memberCondition) {
        Member.get(null, function(responseBody) {
            return function() {
                return responseBody;
            };
        });
    };
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

//prototype.memberReference = function(memberCondition) {
//    var members = this.Member.get(memberCondition);
//    return members;
//};


var getMember = function(memberCondition) {
   //サーバリクエストオブジェクトの生成
   var promise = this.resource.get(memberCondition).$promise;
   //→戻り値はモジュールのインスタンスになる・・・なので$promiseの指定→なのでもうちょい工夫必要
   
   
   return promise;
   
//    var members = this.resource.get(
//            memberCondition, function(result, headers) {
//                membersList = result.members;
//    });
};
//メンバー参照(検索)
//prototype.memberReference = function(memberCondition) {
//     var membersList;
//   //サーバリクエストオブジェクトの生成
//    var members = this.$resourceService.get(
//            memberCondition, function(result, headers) {
//                membersList = result;
//    });
//    
//    return membersList;
//};