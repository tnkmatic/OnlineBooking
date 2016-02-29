/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('onlineBookingModule')
        .controller('memberReferenceController',['$rootScope', 'memberService', 
            'stringUtilService',
    function($scope, memberService, stringUtilService) {
        //メンバ検索用のモデル
        $scope.memberCondition = {};
        
        //メンバ検索結果用のモデル
        $scope.memberList = {};

        //Gridの初期設定
        $scope.gridOptions = {
            enableColumnMenus: false,
            enableColumnResizing: true,
            //行選択
            enableRowSelection: true,
            enableRowHeaderSelection: false,
            multiSelect: false,
            //ページング設定
            enablePaginationControls: true,
            paginationPageSize: 5,
            paginationPageSizes: [20, 50, 100],
            //グリッドヘッダ行
            //enableGridMenu: true,
            //CSV出力
            exporterCsvFilename: 'members' + '_' + formatDate(new Date(), 'YYYYMMDDhhmmss') + '.csv',
            //グリッド列の定義
            columnDefs: [
                {field: 'loginId',displayName: 'ログインID', width: 120},
                {field: 'lastName',displayName: '氏名(姓)', width: 240},
                {field: 'firstName',displayName: '氏名(名)', width: 120},
                {name: 'lastNameKana',displayName: '氏名(姓カナ)', width: 120},
                {name: 'firstNameKana',displayName: '氏名(名カナ)', width: 120},
                {name: 'mstGender.genderName', displayName: '性別', width: 80},
                {name: 'birthday',displayName: '生年月日', width: 200, type: 'date', cellFilter: 'date:"yyyy-MM-dd"'},
                {name: 'skypeId', displayName: 'Skype', width: 80},
                {name: 'mstContactWay.contactWayKbnName',displayName: '連絡方法', width: 80},
                {name: 'tel',displayName: '電話番号', width: 160},
                {name: 'email',displayName: 'メールアドレス', width: 220},
                {name: 'postalCd',displayName: '郵便番号', width: 80},
                {name: 'prefName',displayName: '都道府県', width: 80},
                {name: 'cityName',displayName: '市区町村', width: 80},
                {name: 'addressDetailName',displayName: '住所', width: 250},
                {name: 'buildingName',displayName: '建物名', width: 250},
                {name: 'rMemberMemberGroup.memberGroup.memberGroupName',displayName: 'メンバー区分', width: 120}
            ],
            data : {}
        };

        //メンバー参照(検索)
        $scope.reference = function() {
            //空文字対応
            $scope.memberCondition.loginId = 
                    stringUtilService.emptyOrUndefinedToNull(
                            $scope.memberCondition.loginId);
            $scope.memberCondition.firstName =
                    stringUtilService.emptyOrUndefinedToNull(
                            $scope.memberCondition.firstName);
            $scope.memberCondition.lastName = 
                    stringUtilService.emptyOrUndefinedToNull(
                            $scope.memberCondition.lastName);
            
            //memberService($resourceサービス)を介して検索を実行
            memberService.get($scope.memberCondition, function(responseBody) {
                $scope.gridOptions.data = responseBody.members;
            });
        };
    }]
);