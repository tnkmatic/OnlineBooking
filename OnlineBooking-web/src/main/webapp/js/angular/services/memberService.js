/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var Member = {};

//コンストラクタ
var MemberService = function($resource, $rootScope) {
    this.$resource = $resource;
    this.$scope = $rootScope;
    Member = this.$resource(
        onlineBookingResourceDomain + 'members' + '/',
        {memberId: '@id'},
        {
            //メンバー登録
            regist: {
                method: 'POST',
                params: {}
            }
        }
    );
};

//プロトタイプの取得
var prototype = MemberService.prototype;

//メンバー登録
prototype.memberRegist = function($scope) {
    //生年月日の文字列をDate型に変換
    $scope.member.birthday = stringToDate($scope.member.birthday);
    
    //サーバリクエストオブジェクトの生成
    var member = new Member({memberRegister: $scope.member}); //memberRegisterRequest
    //サーバリクエスト(メンバー登録)
    member.$save()
            .then(function success(result) {
                $scope.debug.statusCode = result.status;
                $scope.debug.data = result.data;
    });
};