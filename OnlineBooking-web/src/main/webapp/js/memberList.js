/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var w2gridSeq = 0;
var w2gridName = "memberGrid";
var w2gridHeader = "登録メンバー一覧";
var w2gridColumns = [
    {field: 'loginId', caption: 'ログインID', size: '120px', sortable: true},
    {field: 'lastName', caption: '氏名（姓）', size: '120px', searchable: true},
    {field: 'firstName', caption: '氏名（名）', size: '120px'},
    {field: 'lastNameKana', caption: '氏名カナ（姓）', size: '120px'},
    {field: 'firstNameKana', caption: '氏名カナ（名）', size: '120px'},
    {field: 'genderName', caption: '性別', size: '120px'},
    {field: 'birthday', caption: '誕生日', size: '120px'},
    {field: 'skypeId', caption: 'SkypeID', size: '120px'},
    {field: 'contactWayName', caption: '連絡方法', size: '120px'},
    {field: 'tel', caption: '電話番号', size: '120px'},
    {field: 'email', caption: 'メールアドレス', size: '120px'},
    {field: 'postalCd', caption: '郵便番号', size: '120px'},
    {field: 'prefName', caption: '都道府県名', size: '120px'},
    {field: 'cityName', caption: '市区町村名', size: '120px'},
    {field: 'addressDetailName', caption: '住所詳細名', size: '120px'},
    {field: 'buildingName', caption: '建物名', size: '120px'},
    {field: 'memberGroupKbnName', caption: 'メンバーグループ', size: '120px'}
];

var w2gridOnSelect = function(event) {
    $('#memberDetailReference').attr('disabled', false);
};
var w2gridOnUnselect = function(event) {
    $('#memberDetailReference').attr('disabled', true);
}

var w2gridObj = {
    name: w2gridName + w2gridSeq,
    header: w2gridHeader,
    columns: w2gridColumns,
    records: undefined,
    onSelect: w2gridOnSelect,
    onUnselect: w2gridOnUnselect
};

function memberReference() {
    var button = $(this);
    button.attr('disabled', true);
    
    /***************************************************************
     * メンバー検索
     **************************************************************/
    $.ajax({
        url: API_PATH + '/' + 'members',
        type: 'get',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (data, dataType) {
            // TODO nameプロパティの値重複でエラーがコンソールに表示されるのでインクリメントで動的変更(他にやり方がないか？)
            w2gridSeq = w2gridSeq + 1;
            w2gridObj.name = w2gridName + w2gridSeq;
            w2gridObj.records = data.members;
            $('#memberGrid').w2grid(w2gridObj);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            
        },
        complete: function (jqXHR, textStatus) {
            button.attr('disabled', false);
        }
    });
}