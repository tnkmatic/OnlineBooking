<%-- 
    Document   : StudentEntry
    Created on : 2015/01/27, 0:52:01
    Author     : Eiichi
--%>

glassfishのデータソース設定
glassfishのレルム設定
テーブル生成
サーバサイドの認証機構の実装

サーバサイドの構築(ユーザ周りから)

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
        <script type="text/javascript" src="../../js/onlineBooking.js"></script>
        <script type="text/javascript" src="../../js/memberRegist.js"></script>
        <script type="text/javascript" src="../../js/validation.js"></script>
        <script type="text/javascript">
            $(function(){
                /***************************************************************
                 * 生年月日：datepicker設定
                 **************************************************************/
                $.datepicker.setDefaults( $.datepicker.regional["ja"] );
                $('#birthday').datepicker({
                    dateFormat: 'yy/mm/dd'
                });

                /***************************************************************
                 * 電話番号/メールアドレス クリックイベント登録
                 * on でイベント登録しておくと動的に要素を追加したタイミングでも
                 * 新しく生成された要素に対してもイベント登録される
                 **************************************************************/
                $('#telkbn').on('click', function() {
                    $('#tel').prop('disabled', false);
                    $('#mailaddress').prop('disabled', true);
                    $('#mailaddress').val('');
                });
                $('#emailkbn').on('click', function() {
                    $('#tel').prop('disabled', true);
                    $('#mailaddress').prop('disabled', false);
                    $('#tel').val('');
                });
                
                /***************************************************************
                 * 郵便番号　フォーカスアウトイベント登録
                 **************************************************************/
                $('#postal').on('focusout', function() { 
                    getCityByZipCode();
                });
                
                /***************************************************************
                 * 登録ボタンクリックイベント登録
                 *************************************************************/
                $('#memberregist').on('click', memberRegist);
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
                    <li id="menuMemberEntry"><a href="xxx.html"></a></li>
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
                    <ul id="errorarea"></ul>
                    <ul id="infoarea"></ul>
                    <form id="mainfm" action="" method="post">
                        <h2>生徒登録</h2>
                        <div class="field">
                            <label for="studentfname">名前（姓）：</label>
                                <input id="studentfname" name="fn" type="text" size="20"
                                       class="valid required"
                                       value="田中"/><br/>
                        </div>
                        <div class="field">
                            <label for="studentlname">名前（名）：</label>
                                <input id="studentlname" name="ln" type="text" size="20"
                                       class="valid required"
                                       value="栄一"/><br/>
                        </div>
                        <div class="field">
                            <label for="studentfnamekana">名前カナ（姓）：</label>
                                <input id="studentfnamekana" name="fnk" type="text" size="20"
                                       class="valid required" 
                                       value="タナカ"/><br/>
                        </div>
                        <div class="field">
                            <label for="studentlnamekana">名前カナ（名）：</label>
                                <input id="studentlnamekana" name="lnk" type="text" size="20"
                                       class="valid required" 
                                       value="エイイチ"/><br/>
                        </div>
                        <div class="field">
                            <label for="password">パスワード：</label>
                                <input id="password" name="pw" type="password" size="20"
                                       class="valid required"
                                       value="password"/><br/>
                        </div>
                        <div class="field">
                            <label for="passwordc">パスワード（確認用）：</label>
                                <input id="passwordc" name="pwc" type="password" size="20"
                                       class="valid required"
                                       value="password"/><br/>
                        </div>
                        <div class="field">
                            <label for="birthday">生年月日：</label>
                                <input type="text" id="birthday" name="b" 
                                       class="valid required"
                                       value="2015/03/10"/><br/>
                        </div>
                        <div class="field">
                            <label for="skypeid">SkypeID：</label>
                                <input id="skypeid" name="s" type="text" size="64"
                                       class="valid required"
                                       value="tnkmatic"/><br/>
                        </div>
                        <div class="field">
                            <input type="radio" name="l" id="telkbn" checked >
                                <label for="telkbn">電話番号</label>
                                <input type="text" name="t" id="tel" size="13"
                                       class="valid regexp-nullable" 
                                       data-pattern="0\d{1,4}-\d{1,4}-\d{4}"/><br/>
                            <input type="radio" name="l" id="emailkbn">
                                <label for="emailkbn">メールアドレス</label>
                                <input type="text" name="m" id="mailaddress" size="36"
                                       disabled="true" class="valid regexp-nullable"
                                       data-pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$"
                                       value="eiichi1208@gmail.com"/><br/>
                        </div>
                        <div class="field">
                            <label for="postal">郵便番号：</label>
                                <input type="text" name="ps" id="postalcd" 
                                       class="valid required length" data-length="7"
                                       value="1350021"/><br/>
                        </div>
                        <div class="field">
                            <label for="address1">都道府県：</label>
                                <input type="text" name="a1" id="prefname" 
                                       class="valid required length" data-length="4"
                                       value="東京都"/><br/>
                        </div>
                        <div class="field">
                            <label for="address2">市区町村：</label>
                                <input type="text" name="a2" id="cityname" 
                                       class="valid required length" data-length="20"
                                       value="江東区白河"><br/>
                        </div>
                        <div class="field">
                        <label for="address3">丁目・番地・号：</label>
                            <input type="text" name="a3" id="chomeName"
                                   class="valid required length" data-length="100"
                                   value="4-9-14"/><br/>
                        </div>
                        <div class="field">
                        <label for="address4">建物名：</label>
                            <input type="text" name="a3" id="buildingname"
                                   class="valid length" data-length="100"
                                   value="ビル"/><br/>
                        </div>
                        <div class="field">
                            <input type="button" id="memberregist" value="登録" />
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
