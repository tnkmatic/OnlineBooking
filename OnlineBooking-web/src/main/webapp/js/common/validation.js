/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(
    function() {
        var msgs;

        /***********************************************************************
         * バリデーションエラーの画面表現
         **********************************************************************/
        var setError = function(elem, msg) {
            msgs.push('<li>' + msg + '</li>');
            $(elem).addClass('errorfield')
                    .after('<span class="errormark">*</span>');
        };
        
        /***********************************************************************
         * #mainfm.submitへのイベントリスナー登録
         **********************************************************************/
        $('#mainfm').submit(function(e) {
            msgs = [];

            //エラーリストのクリア 
            //#mainfmの子要素でclass属性にerror_markが設定いる場合に消去
            $('.errormark', this).remove();
            $('.valid', this)
                //エラー表現のクリア
                .removeClass('errorfield')
        
                //必須チェック
                .filter('.required')
                .each(function() {
                    //$(selector).val()はvalueの属性値を返却
                    //$(selector).text()は要素に囲まれたテキストノードを取得
                    if ($(this).val() === '') {
                        setError(this, $(this).prev('label').text() 
                                + 'は必須入力です。');
                    }
                })
                .end()
                
                //文字列長チェック
                .filter('.length')
                .each(function() {
                    if ($(this).val().length > $(this).data('length')) {
                        setError(this, $(this).prev('label').text() + 'は'
                                + $(this).data('length') + '文字以内で入力してください。');
                        
                    }
                })
                .end()
        
                //範囲チェック
                .filter('.range')
                .each(function() {
                    var v = parseFloat($(this).val());
                    if (v < $(this).data('min') || v > $(this).data('max')) {
                        setError(this, $(this).prev('label').text() + 'は'
                                + $(this).data('min') + '～' + $(this).data('max') 
                                + 'の範囲で入力してください。');
                    }
                })
                .end()
        
                //候補値チェック
                .filter('.inarray')
                .each(function() {
                    var opts = $(this).data('option').split(' ');
                    //$.inArrayメソッドは値が配列の何番目に含まれているかを返却
                    if ($.inArray($(this).val(), opts) === -1) {
                        setError(this, $(this).prev('label').text() + 'は'
                                + opts.toString() + 'のいずれかを入力してください。');
                    }
                })
                .end()
                
                //正規表現チェック
                .filter('.regexp')
                .each(function() {
                    var reg = new RegExp($(this).data('pattern'), 'gi');
                    if (!reg.test($(this).val())) {
                        setError(this, $(this).prev('label').text()
                                + 'の形式が間違っています。');
                    }
                })
                .end()
        
                //正規表現チェック(空白を許可)
                .filter('.regexp-nullable')
                .each(function() {
                    if ($(this).val().length > 0) {
                        var reg = new RegExp($(this).data('pattern'), 'gi');
                        if (!reg.test($(this).val())) {
                            setError(this, $(this).prev('label').text()
                                    + 'の形式が間違っています。');
                        }
                    }
                })
                .end();

            /******************************************************************
             * エラーメッセ―ジ表示エリアへのメッセージ表示制御
             ******************************************************************/
            if (msgs.length === 0) {
                //display noneを設定すると非表示
                $('#error_summary').css('display', 'none');
            } else {
                //display blockを設定すると表示
                $('#error_summary').css('display', 'block')
                        .html(msgs.join(''));
                //イベントをキャンセル
                e.preventDefault();
            }
        });
    }
);