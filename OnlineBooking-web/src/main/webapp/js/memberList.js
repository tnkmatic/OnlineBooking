/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
            { type: 'left', size: 200, resizable: true, minSize: 120 },
            { type: 'main', minSize: 550, overflow: 'hidden' }
        ]
    },
    sidebar: {
        name: 'sidebar',
        nodes: [ 
            { id: 'general', text: 'General', group: true, expanded: true, nodes: [
                { id: 'grid1', text: 'Grid 1', img: 'icon-page', selected: true },
                { id: 'grid2', text: 'Grid 2', img: 'icon-page' },
                { id: 'html', text: 'Some HTML', img: 'icon-page' }
            ]}
        ],
        onClick: function (event) {
            switch (event.target) {
                case 'grid1':
                    w2ui.layout.content('main', w2ui.grid1);
                    break;
                case 'grid2':
                    w2ui.layout.content('main', w2ui.grid2);
                    break;
                case 'html':
                    w2ui.layout.content('main', '<div style="padding: 10px">Some HTML</div>');
                    $(w2ui.layout.el('main'))
                        .removeClass('w2ui-grid')
                        .css({ 
                            'border-left': '1px solid silver'
                        });
                    break;
            }
        }
    },
    grid1: { 
        name: 'grid1',
        columns: [
            { field: 'fname', caption: 'First Name', size: '180px' },
            { field: 'lname', caption: 'Last Name', size: '180px' },
            { field: 'email', caption: 'Email', size: '40%' },
            { field: 'sdate', caption: 'Start Date', size: '120px' },
        ],
        records: [
            { recid: 1, fname: 'John', lname: 'Doe', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
            { recid: 2, fname: 'Stuart', lname: 'Motzart', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
            { recid: 3, fname: 'Jin', lname: 'Franson', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
            { recid: 4, fname: 'Susan', lname: 'Ottie', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
            { recid: 5, fname: 'Kelly', lname: 'Silver', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
            { recid: 6, fname: 'Francis', lname: 'Gatos', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
            { recid: 7, fname: 'Mark', lname: 'Welldo', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
            { recid: 8, fname: 'Thomas', lname: 'Bahh', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
            { recid: 9, fname: 'Sergei', lname: 'Rachmaninov', email: 'jdoe@gmail.com', sdate: '4/3/2012' }
        ]
    },
    grid2: { 
        name: 'grid2',
        columns: [
            { field: 'state', caption: 'State', size: '80px' },
            { field: 'title', caption: 'Title', size: '100%' },
            { field: 'priority', caption: 'Priority', size: '80px', attr: 'align="center"' }
        ],
        records: [
            { recid: 1, state: 'Open', title: 'Short title for the record', priority: 2 },
            { recid: 2, state: 'Open', title: 'Short title for the record', priority: 3 },
            { recid: 3, state: 'Closed', title: 'Short title for the record', priority: 1 },
        ]
    }
}

var w2gridOnSelect = function(event) {
    $('#memberDetailReference').attr('disabled', false);
};
var w2gridOnUnselect = function(event) {
    $('#memberDetailReference').attr('disabled', true);
}

var w2gridObj = {
    name: w2gridName,
    header: w2gridHeader,
    columns: w2gridColumns,
    records: undefined,
    onSelect: w2gridOnSelect,
    onUnselect: w2gridOnUnselect
};

function init() {
    w2utils.locale('/src/locale/ja-jp.json');
    // initialization
    $('#main').w2layout(config.layout);
    w2ui.layout.content('left', $().w2sidebar(config.sidebar));
    w2ui.layout.content('main', $().w2grid(config.grid1));
    // in memory initialization
    $().w2grid(config.grid2);
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