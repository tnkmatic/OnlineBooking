<%-- 
    Document   : memberList
    Created on : 2015/06/16, 0:40:31
    Author     : Eiichi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head id="pageHeader">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" 
              href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css" />
        <link rel="stylesheet" type="text/css" href="../../css/OnlineBokking.css" />
        <link rel="stylesheet" type="text/css" href="../../css/w2ui.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/i18n/jquery-ui-i18n.min.js"></script>
        <script type="text/javascript" src="../../js/common/onlineBooking.js"></script>
        <script type="text/javascript" src="../../js/common/validation.js"></script>
        <script type="text/javascript" src="../../js/lib/jquery.blockUI.js"></script>
        <script type="text/javascript" src="../../js/lib/w2ui.min.js"></script>
        <script type="text/javascript" src="../../js/memberList.js"></script>
        <script>
            $(function() {
                $('#memberGrid').w2grid({
                    name: 'memberGrid',
                    header: '登録メンバー一覧',
                    columns: [
                        {field: 'loginId', caption: 'ログインID'},
                        {field: 'lastName', caption: '氏名（姓）'},
                        {field: 'firstName', caption: '氏名（名）'},
                        {field: 'lastNameKana', caption: '氏名カナ（姓）'},
                        {field: 'firstNameKana', caption: '氏名カナ（名）'},
                        {field: 'genderName', caption: '性別'},
                        {field: 'birthday', caption: '誕生日'},
                        {field: 'skypeId', caption: 'SkypeID'},
                        {field: 'contactWayName', caption: '連絡方法'},
                        {field: 'tel', caption: '電話番号'},
                        {field: 'email', caption: 'メールアドレス'},
                        {field: 'postalCd', caption: '郵便番号'},
                        {field: 'prefName', caption: '都道府県名'},
                        {field: 'cityName', caption: '市区町村名'},
                        {field: 'addressDetailName', caption: '住所詳細名'},
                        {field: 'buildingName', caption: '建物名'},
                        {field: 'memberGroupKbnName', caption: 'メンバーグループ'}
                    ]
                });
            });
        </script>
        <title>オンライン授業予約</title>
    </head>
    <body>
        <div id="pagebody">
            <!-- ヘッダ -->
            <div id="header"><h1><a href="index.html">オンライン授業予約</a></h1></div>
            <!-- メインメニュー -->
            <ul id="menu">
                <li id="menuHome"><a href="xxx.html">ホーム</a></li>
                <li id="menuMemberEntry"><a href="xxx.html">メンバ登録</a></li>
                <li id="menu3"><a href="xxx.html"></a></li>
                <li id="menu4"><a href="xxx.html"></a></li>
                <li id="menu5"><a href="xxx.html"></a></li>              
            </ul>
                        <!-- サブメニュー（左カラム） -->
            <div id="submenu">
                <div id="submenu_header">メンバー管理</div>
                <ul id="submenu_body">
                    <li><a href="xxx.html">メンバー登録</a></li>
                    <li><a href="xxx.html">メンバー検索</a></li>
                    <li><a href="xxx.html">aaaaaaaaaaaa</a></li>
                </ul>
            </div>
            
            <div id="content">
                <div id="main">
                    <!-- エラーメッセージを表示するエリア -->
                    <div id="main_message_area">
                        <ul id="errorarea"></ul>
                        <ul id="infoarea"></ul>
                    </div>
                    <!-- デバッグ用 -->
                    <div id="main_result_area"></div>
                    <form id="mainfm" action="" method="post">
                        <h2>メンバ検索</h2>
                        <!-- 検索条件 -->
                        <div id="condition">
                            <div class="field">                    
                                <label for="loginId">ログインＩＤ：</label>
                                    <input id="loginId" name="loginId" type="text" size="20"
                                           class=""
                                           value="tnkmatic"/><br/>
                            </div>
                        </div>
                        <!-- 検索結果(一覧)表示エリア　-->
                        <div id="memberGrid" style="width: 100%; height: 250px;"></div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
