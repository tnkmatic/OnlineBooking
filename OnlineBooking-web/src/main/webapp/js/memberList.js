/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var w2gridName = "memberGrid";
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

//var config = {
//    layout: {
//        name: 'layout',
//        padding: 0,
//        panels: [
//            {type:'top',  content:'top',  size:700, resizable: false},
//            {type:'left', content:'left', size:200, resizable: true, minSize: 120},
//            {type:'main', content:'main', size:500, resizable: true}
//        ]
//    },
//    sidebar: {
//        name: 'sidebar',
//        nodes: [
//            {id: 'memberRegist', text: 'メンバ登録'},
//            {id: 'memberList', text: 'メンバ参照'}
//        ],
//        onClick: function() {
//
//        }
//    },
//    grid: {
//        name: w2gridName,
//        header: w2gridHeader,
//        columns: w2gridColumns,
//        onSelect: w2gridOnSelect,
//        onUnselect: w2gridOnUnselect
//    }  
//};

var config = {
    layout: {
        name: 'layout',
        padding: 0,
        panels: [
            { type: 'top', size: 50}, 
            { type: 'left', size: 200, resizable: true, minSize: 120 },
            { type: 'main', minSize: 550, overflow: 'hidden' }
        ]
    },
    toolbar: {
        name: 'toolbar',
        items: [
            { id: 'btnSpacer', type: 'spacer' },
            { id: 'btnReset', type: 'button', caption: 'クリア', img: 'icon-page' },
            { id: 'btnSearch', type: 'button', caption: '検索', img: 'icon-page' }
        ],
        onClick: function (event) {
            if (event.target === 'btnSearch') {
                memberReference();
            }
        }
    },
    sidebar: {
        name: 'sidebar',
        nodes: [ 
            { id: 'general', text: 'General', group: true, expanded: true, nodes: [
                { id: 'grid1', text: 'Grid 1', img: 'icon-page', selected: true },
                { id: 'grid2', text: 'Grid 2', img: 'icon-page' },
                { id: 'html', text: 'Some HTML', img: 'icon-page' }
            ]}
        ]
    },
    grid: { 
        name: w2gridName,
        header: "登録メンバー一覧",
        columns: w2gridColumns,
        records: undefined
    }
};

/*
 * 画面初期化
 * @returns {undefined}
 */
function init() {
    w2utils.locale('/src/locale/ja-jp.json');
    // initialization
    $('#main').w2layout(config.layout);
    w2ui.layout.content('top', $().w2toolbar(config.toolbar));
    w2ui.layout.content('left', $().w2sidebar(config.sidebar));
    w2ui.layout.content('main', $().w2grid(config.grid));
    // in memory initialization
    //$().w2grid(config.grid2);
}

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
            var w2grid = w2ui[w2gridName];
            w2grid.records = data.members;
            w2grid.reload();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            
        },
        complete: function (jqXHR, textStatus) {
            button.attr('disabled', false);
        }
    });
}