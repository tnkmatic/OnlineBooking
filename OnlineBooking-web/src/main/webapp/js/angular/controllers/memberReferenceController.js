/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('onlineBookingModule').controller('memberReferenceController',
    ['$scope', 'uiGridConstants', 'memberService', function($scope, uiGridConstants, memberService) {
        //メンバ検索用のモデル
        $scope.memberCondition = {};
        
        //メンバ検索結果用のモデル
        $scope.memberList = {};
        
        //Gridの初期設定
        $scope.memberGrid = {
            enablePaginationControls: true,
            paginationPageSize: 5,
            columnDefs: [
                {field: 'loginId',              displayName: 'ログインID'},
                {field: 'lastName',             displayName: '氏名(姓)'},
                {field: 'firstName',            displayName: '氏名(名)'},
                {field: 'lastNameKana',         displayName: '氏名(姓カナ)'},
                {field: 'firstNameKana',        displayName: '氏名(名カナ)'},
                {field: 'genderName',           displayName: '性別'},
                {field: 'birthday',             displayName: '生年月日'}, //,    cellFilter:'date: yyyy年MM月dd日'
                {field: 'skypeId',              displayName: 'Skype'},
                {field: 'contactWayName',       displayName: '連絡先'},
                {field: 'contactWayName',       displayName: '連絡方法'},
                {field: 'tel',                  displayName: '電話番号'},
                {field: 'email',                displayName: 'メールアドレス'},
                {field: 'postalCd',             displayName: '郵便番号'},
                {field: 'prefName',             displayName: '都道府県'},
                {field: 'cityName',             displayName: '市区町村'},
                {field: 'addressDetailName',    displayName: '住所'},
                {field: 'buildingName',         displayName: '建物名'},
                {field: 'memberGroupKbnName',   displayName: 'メンバー区分'}
            ],
            data : []
        };
        
        //メンバー参照(検索)
        $scope.reference = function() {
            //memberServiceを介して検索を実行
            memberService.memberReference($scope.memberCondition)
                    .then(function success(result) {
                        $scope.memberGrid.data = result.members;
                    });
        };
    }]
);

