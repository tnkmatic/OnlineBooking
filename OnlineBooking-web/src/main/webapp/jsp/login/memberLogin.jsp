<%-- 
    Document   : memberLogin
    Created on : 2015/03/02, 23:39:39
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
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/i18n/jquery-ui-i18n.min.js"></script>
        <script type="text/javascript" src="../../js/memberLogin.js"></script>
        <script type="text/javascript" src="../../js/validation.js"></script>
        <title>オンライン授業予約</title>
    </head>
    <body>
        <div id="pagebody">
            <!-- ヘッダ -->
            <div id="header"><h1><a href="index.html">オンライン授業予約</a></h1></div>
            <!-- メインメニュー -->
            <ul id="menu">
                    <li id="menuHome"><a href="xxx.html">ホーム</a></li>
                    <li id="menuStudentEntry"><a href="xxx.html"></a></li>
                    <li id="menu3"><a href="xxx.html"></a></li>
                    <li id="menu4"><a href="xxx.html"></a></li>
                    <li id="menu5"><a href="xxx.html"></a></li>
            </ul>
            <!-- サブメニュー（左カラム） -->
            <div id="submenu">
                <div id="submenu_header">目的で探す</div>
                <ul id="submenu_body">
                    <li><a href="xxx.html">CSSの適用</a></li>
                    <li><a href="xxx.html">セレクタ</a></li>
                    <li><a href="xxx.html">フォント</a></li>
                    <li><a href="xxx.html">テキスト</a></li>
                    <li><a href="xxx.html">文字色・背景</a></li>
                    <li><a href="xxx.html">幅・高さ・余白</a></li>
                    <li><a href="xxx.html">ボーダー</a></li>
                    <li><a href="xxx.html">表示・配置</a></li>
                    <li><a href="xxx.html">リスト</a></li>
                    <li><a href="xxx.html">テーブル</a></li>
                    <li><a href="xxx.html">生成内容の挿入</a></li>)
                    <li><a href="xxx.html">インターフェース</a></li>
                    <li><a href="xxx.html">フィルタ・ズーム</a></li>
                    <li><a href="xxx.html">テキスト（IE独自）</a></li>
                    <li><a href="xxx.html">印刷</a></li>
                    <li><a href="xxx.html">音声</a></li>
                </ul>
            </div>

            <div id="content">
                <div id="main">
                    <!-- エラーメッセージを表示するエリア -->
                    <ul id="error_summary"></ul>
                    <form id="mainfm" action="j_security_check" method="post">
                        <h2>ログイン</h2>
                        <div class="field">
                            <label for="memberId">ログイン：</label>
                                <input id="memberId" name="j_username" type="text" size="20"
                                       class="valid required" /><br/>
                        </div>
                        <div class="field">
                            <label for="memberPassword">名前（名）：</label>
                            <input id="memberPassword" name="j_password" type="password" size="20"
                                       class="valid required" /><br/>
                        </div>
                        <div class="field">
                            <input id="memberLogin" type="submit" value="ログイン" />
                            <input type="reset" value="クリア" />
                        </div>
                        <hr />
                    </form>
                </div>
                <!-- ピックアップ（右カラム） -->
                <div id="pickup">
                    <h2>ピックアップ</h2>
                    <ul>
                        <li><a href="xxx.html">CSSのメリット</a></li>
                        <li><a href="xxx.html">Web標準とは</a></li>
                        <li><a href="xxx.html">CSSのバージョン</a></li>
                        <li><a href="xxx.html">HTML/XHTMLの基礎</a></li>
                        <li><a href="xxx.html">CSSの書き方</a></li>
                        <li><a href="xxx.html">文書に適用する</a></li>
                        <li><a href="xxx.html">代替スタイルシート</a></li>
                        <li><a href="xxx.html">メディアタイプ</a></li>
                        <li><a href="xxx.html">セレクタの種類</a></li>
                        <li><a href="xxx.html">@ルール</a></li>
                        <li><a href="xxx.html">スタイルの優先順位</a></li>
                        <li><a href="xxx.html">スタイルの継承</a></li>
                        <li><a href="xxx.html">CSSでの長さの指定</a></li>
                        <li><a href="xxx.html">ボックス</a></li>
                        <li><a href="xxx.html">DOCTYPE宣言</a></li>
                    </ul>
                </div>
            </div>
            <!-- フッタ -->
            <div id="footer"><address>Copyright (c) tnkmatic Online Booking All Rights Reserved.</address></div>
        </div>


    </body>
</html>
