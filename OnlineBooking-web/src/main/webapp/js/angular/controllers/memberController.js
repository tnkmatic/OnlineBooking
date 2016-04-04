/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('onlineBookingModule').controller('memberController',
    ['$scope', 'memberService', 'stringUtilService', 'mstService',
        function($scope, memberService, stringUtilService, mstService) {
        //**********************************************************************
        // モデル定義
        //**********************************************************************
        $scope.member = {};
        $scope.memberCondition = {};      //メンバ検索条件用
        $scope.memberList = {};            //メンバ検索結果格納用
        $scope.debug = {};                  //デバッグ用
        
        // 表示対象の変更
        $scope.changePage = function(showObj, showMode) {
           for (var name in showObj) {
               if (name === showMode) {
                   showObj[name] = true;
               } else {
                   showObj[name] = false;
               }
           }
        };
        
        // マスタ値の取得
        $scope.mstEmployList = mstService.getEmployList();
            
        //**********************************************************************
        // メンバ追加用(memberRegist)
        //**********************************************************************
        // SPA表示制御用
        $scope.showRegist = {
           entry : true,
           confirm  : false,
           complete : false
        };

        //連絡方法区分のチェックボックス切替
        $scope.contactWayKbnTelChecked = true;
        $scope.contactWayKbnEmailChecked = !$scope.contactWayKbnTelChecked;
        //連絡方法区分のラジオボタン切り替え(電話番号)
        $scope.contactWayKbnOn = function(compareValue) {
            return !($scope.member.contactWayKbn === compareValue);
        };
        //入力画面への遷移(entry)
        $scope.entry = function() {
            $scope.changePage($scope.showRegist, 'entry');
        };
        //確認画面への遷移(confirm)
        $scope.confirm = function() {
            $scope.changePage($scope.showRegist, 'confirm');
        };
        //メンバー登録(submit)
        $scope.submit = function() {
            //memberServiceを介してメンバー登録
            memberService.save({memberRegister: $scope.member});
            //完了画面の表示
            $scope.changePage($scope.showRegist, 'complete');
        };

        //**********************************************************************
        // メンバ参照(memberReference)
        //**********************************************************************
        // SPA表示制御用
        $scope.showReference = {
           reference : true,
           addAttribute  : false
        };

        //Grid初期設定
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
            enableGridMenu: true,
            //CSV出力
            exporterCsvFilename: 'members' + '_' + formatDate(new Date(), 'YYYYMMDDhhmmss') + '.csv',
            //グリッド列の定義
            columnDefs: [
                {name: 'loginId',displayName: 'ログインID', width: 120},
                {name: 'lastName',displayName: '氏名(姓)', width: 120},
                {name: 'firstName',displayName: '氏名(名)', width: 120},
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
            data : [],
            onRegisterApi : function( gridApi ) {
                $scope.gridApi = gridApi;
                // 行選択時の選択行の取得
                gridApi.selection.on.rowSelectionChanged($scope, function(row){
                    if (row.isSelected) {
                        $scope.selectedMember = row.entity;
                    } else {
                        $scope.selectedMember = null;
                    }
                });
            }
        };

        //メンバー検索
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
        
        //メンバー編集の表示
        $scope.addAttribute = function() {
            $scope.changePage($scope.showReference, 'addAttribute');
        };

        //**********************************************************************
        // メンバ追加属性設定(memberAddAttribute)
        //**********************************************************************
        


    }]
);