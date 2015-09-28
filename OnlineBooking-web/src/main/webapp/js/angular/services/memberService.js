/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function() {
    //コンストラクタ
    var memberService = function($resource, $scope) {
        
    };
    
    //プロトタイプの取得
    var prototype = memberService.prototype;
    var resourceName = 'members';
    
    //初期化メソッド(init)
    prototype.init = function($resource, $scope) {
        this.$resource = $resource;
        this.$scope = $scope;
    };
    
    var Member = $resource(
            onlineBookingResourceDomain + resourceName + '/' + 'memberId',
            {memberId: '@id'},
            {
                //メンバー登録
                regist: {
                    method: 'POST',
                    params: {
                        loginId: this.$scope.member.loginId,
                        loginPassword: this.$scope.member.loginPassword,
                        loginPasswordc: this.$scope.member.loginPasswordConfirm,
                        lastName: this.$scope.member.lastName,
                        firstName: this.$scope.member.firstName,
                        lastNameKana: this.$scope.member.lastNameKana,
                        firstNameKana: this.$scope.member.firstNameKana,
                        gender: null,
                        birthday: this.$scope.member.birthday, 
                        skypeId: this.$scope.member.skypeId,
                        contactWayKbn: this.$scope.member.contactWayKbn,
                        tel: this.$scope.member.tel,
                        email: this.$scope.member.email,
                        postalCd: this.$scope.member.postalCd,
                        prefName: this.$scope.member.cityName,
                        cityName: this.$scope.member.cityName,
                        addressDetailName: this.$scope.member.addressDetailName,
                        buildingName: this.$scope.member.buildingName,
                        memberGroupKbn: this.$scope.member.memberGroupKbn
                    }
                }
            }
        );
    
    //メンバー登録
    prototype.memberRegist = function() {
        var member = Member.query();
        return member.$regist();
    };
}(this.app));




    
                

    
    
    
    
