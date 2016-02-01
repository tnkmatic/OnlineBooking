/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('onlineBookingModule')
        .controller('memberReferenceController',['$scope', 'uiGridConstants', 'memberService', 
    function($scope, uiGridConstants, memberService) {
        //メンバ検索用のモデル
        $scope.memberCondition = {};
        
        //メンバ検索結果用のモデル
        $scope.memberList = {};
        
        //Gridの初期設定
        $scope.memberGrid = {
            enablePaginationControls: true,
            paginationPageSize: 5,
            paginationPageSizes: [20, 50, 100],
            enableGridMenu: true,
            exporterCsvFilename: 'members' + '_' + formatDate(new Date(), 'YYYYMMDDhhmmss') + '.csv',
            columnDefs: [
                {field: 'loginId',displayName: 'ログインID', width: 120},
                {field: 'lastName',displayName: '氏名(姓)', width: 120},
                {field: 'firstName',displayName: '氏名(名)', width: 120},
                {field: 'lastNameKana',displayName: '氏名(姓カナ)', width: 120},
                {field: 'firstNameKana',displayName: '氏名(名カナ)', width: 120},
                {field: 'mstGender.genderName', displayName: '性別', width: 80},
                {field: 'birthday',displayName: '生年月日', width: 200, type: 'date', cellFilter: 'date:"yyyy-MM-dd"'},
                {field: 'skypeId', displayName: 'Skype', width: 80},
                {field: 'mstContactWay.contactWayKbnName',displayName: '連絡方法', width: 80},
                {field: 'tel',displayName: '電話番号', width: 160},
                {field: 'email',displayName: 'メールアドレス', width: 220},
                {field: 'postalCd',displayName: '郵便番号', width: 80},
                {field: 'prefName',displayName: '都道府県', width: 80},
                {field: 'cityName',displayName: '市区町村', width: 80},
                {field: 'addressDetailName',displayName: '住所', width: 250},
                {field: 'buildingName',displayName: '建物名', width: 250},
                {field: 'rMemberMemberGroup.memberGroup.memberGroupName',displayName: 'メンバー区分', width: 120}
            ],
            data : []
        };

        //メンバー参照(検索)
        $scope.reference = function() {
            //memberService($resourceサービス)を介して検索を実行
            memberService.get($scope.memberCondition, function(responseBody) {
                $scope.memberGrid.data = responseBody.members;
            });
        };
    }]
);