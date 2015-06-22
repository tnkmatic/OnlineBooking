<%-- 
    Document   : StudentEntry
    Created on : 2015/01/27, 0:52:01
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
        <script type="text/javascript" src="../../js/common/onlineBooking.js"></script>
        <script type="text/javascript" src="../../js/common/validation.js"></script>
        <script type="text/javascript" src="../../js/lib/jquery.blockUI.js"></script>
        <script type="text/javascript" src="../../js/memberRegist.js"></script>
        <script type="text/javascript">
            $(function(){
                /***************************************************************
                 * 生年月日：datepicker設定
                 **************************************************************/
                $.datepicker.setDefaults( $.datepicker.regional["ja"] );
                $('#birthday').datepicker({
                    dateFormat: 'yy-mm-dd'
                });

                /***************************************************************
                 * 電話番号/メールアドレス クリックイベント登録
                 * on でイベント登録しておくと動的に要素を追加したタイミングでも
                 * 新しく生成された要素に対してもイベント登録される
                 **************************************************************/
                $('#contactWayKbnTel').on('click', function() {
                    $('#tel').prop('disabled', false);
                    $('#email').prop('disabled', true);
                    $('#email').val('');
                });
                $('#contactWayKbnEmail').on('click', function() {
                    $('#tel').prop('disabled', true);
                    $('#email').prop('disabled', false);
                    $('#email').val('');
                });
                
                /***************************************************************
                 * 郵便番号　フォーカスアウトイベント登録
                 **************************************************************/
                $('#postalCd').on('focusout', function() { 
                    getCityByZipCode();
                });
                
                /***************************************************************
                 * 郵便番号　フォーカスアウトイベント登録
                 **************************************************************/
                $('.tab li').on('click', function() {
                    // クリックされたタブの番号を取得
                    var index = $('.tab li').index(this);
                    // コンテンツを非表示
                    $('.tabContent li').css('display', 'none');
                    // クリックされたタブと同じインデックスのコンテントを表示
                    $('.tabContent li').eq(index).css('display', 'block');
                    // 一度タブについているclass=~tabSelect"を消去しクリックされたタブに付与
                    $('.tab li').removeClass('tabSelect');
                    $(this).addClass('tabSelect');
                });
                
                /***************************************************************
                 * 登録ボタンクリックイベント登録
                 *************************************************************/
                $('#memberRegist').on('click', memberRegist);
                
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
                <div id="submenu_header">目的で探す</div>
                <ul id="submenu_body">
                    <li><a href="xxx.html">CSSの適用</a></li>
                    <li><a href="xxx.html">セレクタ</a></li>
                    <li><a href="xxx.html">フォント</a></li>
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
                        <h2>メンバ登録</h2>
                        <div class="field">
                            <label for="loginId">ログインＩＤ：</label>
                                <input id="loginId" name="loginId" type="text" size="20"
                                       class="valid required"
                                       value="tnkmatic"/><br/>
                        </div>
                        <div class="field">
                            <label for="lastName">名前（姓）：</label>
                                <input id="lastName" name="lastName" type="text" size="20"
                                       class="valid required"
                                       value="田中"/><br/>
                        </div>
                        <div class="field">
                            <label for="firstName">名前（名）：</label>
                                <input id="firstName" name="firstName" type="text" size="20"
                                       class="valid required"
                                       value="栄一"/><br/>
                        </div>
                        <div class="field">
                            <label for="lastNameKana">名前カナ（姓）：</label>
                                <input id="lastNameKana" name="lastNameKana" type="text" size="20"
                                       class="valid required" 
                                       value="タナカ"/><br/>
                        </div>
                        <div class="field">
                            <label for="firstNameKana">名前カナ（名）：</label>
                                <input id="firstNameKana" name="firstNameKana" type="text" size="20"
                                       class="valid required" 
                                       value="エイイチ"/><br/>
                        </div>
                        <div class="field">
                            <label for="loginPassword">パスワード：</label>
                                <input id="loginPassword" name="loginPassword" type="password" size="20"
                                       class="valid required"
                                       value="password"/><br/>
                        </div>
                        <div class="field">
                            <label for="loginPasswordc">パスワード（確認用）：</label>
                                <input id="loginPasswordc" name="loginPasswordc" type="password" size="20"
                                       class="valid required"
                                       value="password"/><br/>
                        </div>
                        <div class="field">
                            <label for="birthday">生年月日：</label>
                                <input type="text" id="birthday" name="birthday" 
                                       class="valid required"
                                       value="2015-03-10"/><br/>
                        </div>
                        <div class="field">
                            <label for="skypeId">SkypeID：</label>
                                <input id="skypeId" name="skypeId" type="text" size="64"
                                       class="valid required"
                                       value="tnkmatic"/><br/>
                        </div>
                        <div class="field">
                            <input type="radio" name="contactWayKbn" id="contactWayKbnTel" checked >
                                <label for="contactWayKbnTel">電話番号</label>
                                <input type="text" name="t" id="contactWayKbnTel" size="13"
                                       class="valid regexp-nullable" 
                                       data-pattern="0\d{1,4}-\d{1,4}-\d{4}"/><br/>
                            <input type="radio" name="contactWayKbn" id="contactWayKbnEmail">
                                <label for="contactWayKbnEmail">メールアドレス</label>
                                <input type="text" name="m" id="contactWayKbnEmail" size="36"
                                       disabled="true" class="valid regexp-nullable"
                                       data-pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$"
                                       value="eiichi1208@gmail.com"/><br/>
                        </div>
                        <div class="field">
                            <label for="postalCd">郵便番号：</label>
                                <input type="text" name="postalCd" id="postalCd" 
                                       class="valid required length" data-length="7"
                                       value="1350021"/><br/>
                        </div>
                        <div class="field">
                            <label for="prefName">都道府県：</label>
                                <input type="text" name="prefName" id="prefName" 
                                       class="valid required length" data-length="4"
                                       value="東京都"/><br/>
                        </div>
                        <div class="field">
                            <label for="cityName">市区町村：</label>
                                <input type="text" name="cityName" id="cityName" 
                                       class="valid required length" data-length="20"
                                       value="江東区白河"><br/>
                        </div>
                        <div class="field">
                        <label for="addressDetailName">丁目・番地・号：</label>
                            <input type="text" name="addressDetailName" id="addressDetailName"
                                   class="valid required length" data-length="100"
                                   value="4-9-14"/><br/>
                        </div>
                        <div class="field">
                        <label for="buildingName">建物名：</label>
                            <input type="text" name="buildingName" id="buildingName"
                                   class="valid length" data-length="100"
                                   value="ビル"/><br/>
                        </div>
                        <div class="field">
                            <input type="radio" name="memberGroupKbn" id="memberGroupKbnTeacher" value="1" checked />
                                <label for="memberGroupKbnTeacher">講師</label>
                            <input type="radio" name="memberGroupKbn" id="memberGroupKbnStudent" value="2" />
                                <label for="memberGroupKbnStudent">生徒</label>
                            <input type="radio" name="memberGroupKbn" id="memberGroupKbnAdmin" value="9" />
                                <label for="memberGroupKbnAdmin">管理者</label>
                        </div>
                        
                        
<!--                        <div>
                            <ul class="tab">
                                <li class="tabSelect">講師情報</li>
                                <li>生徒情報</li>
                                <li>管理者情報</li>
                            </ul>
                            <ul class="tabContent">
                                 講師情報 
                                <li>
                                    <div class="field">
                                        <input type="radio" name="employKbn" id="employKbnRegular" value="1" checked />
                                            <label for="employKbnRegular">正社員</label>
                                        <input type="radio" name="employKbn" id="employKbnContract" value="2" />
                                            <label for="employKbnContract">契約社員</label>
                                        <input type="radio" name="employKbn" id="employKbnTemporary" value="3" />
                                            <label for="employKbnTemporary">派遣社員</label>
                                        <input type="radio" name="employKbn" id="employKbnParttime" value="3" />
                                            <label for="employKbnParttime">アルバイト</label>
                                    </div>
                                    <div class="field">
                                        <label for="employDayFrom">雇用期間FROM：</label>
                                            <input type="text" id="employDayFrom" name="employDayFrom" 
                                                class="valid required"
                                                value="2015-03-10"/><br/>
                                    </div>
                                    <div class="field">
                                        <label for="employDayFrom">雇用期間TO：</label>
                                            <input type="text" id="employDayTo" name="employDayTo" 
                                                class="valid required"
                                                value="2015-03-10"/><br/>
                                    </div>
                                </li>
                                 生徒情報 
                                <li class="tabHide">
                                </li>
                                 管理者情報 
                                <li class="tabHide">
                                </li>
                            </ul>
                            
                        </div>-->
                        
                        <div class="field">
                            <input type="button" id="memberRegist" value="登録" />
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
                    </ul>
                </div>
            </div>
            <!-- フッタ -->
            <div id="footer"><address>Copyright (c) tnkmatic Online Booking All Rights Reserved.</address></div>
        </div>


    </body>
</html>
