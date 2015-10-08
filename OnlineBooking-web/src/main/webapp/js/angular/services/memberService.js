/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//コンストラクタ
var MemberService = function($resource, $rootScope) {
    this.init($resource, $rootScope);
};

//プロトタイプの取得
var prototype = MemberService.prototype;
var resourceName = 'members';
var Member = {};

//初期化メソッド(init)
prototype.init = function($resource, $rootScope) {
    this.$resource = $resource;
    this.$scope = $rootScope;
};

//リソースサービスの初期設定
prototype.resourceConfig = function($scope) {
        //リソースサービスの初期設定
    Member = this.$resource(
        onlineBookingResourceDomain + resourceName + '/',
        {memberId: '@id'},
        {
            //メンバー登録
            regist: {
                method: 'POST',
                params: {
                    memberRegisterRequest: {
                        loginId: $scope.member.loginId,
                        loginPassword: $scope.member.loginPassword,
                        loginPasswordc: $scope.member.loginPasswordConfirm,
                        lastName: $scope.member.lastName,
                        firstName: $scope.member.firstName,
                        lastNameKana: $scope.member.lastNameKana,
                        firstNameKana: $scope.member.firstNameKana,
                        gender: null,
                        birthday: $scope.member.birthday, 
                        skypeId: $scope.member.skypeId,
                        contactWayKbn: $scope.member.contactWayKbn,
                        tel: $scope.member.tel,
                        email: $scope.member.email,
                        postalCd: $scope.member.postalCd,
                        prefName: $scope.member.cityName,
                        cityName: $scope.member.cityName,
                        addressDetailName: $scope.member.addressDetailName,
                        buildingName: $scope.member.buildingName,
                        memberGroupKbn: $scope.member.memberGroupKbn
                    } //memberRegisterRequest
                }
            }
        }
    );
};

//メンバー登録
prototype.memberRegist = function() {
    return Member.regist();
};