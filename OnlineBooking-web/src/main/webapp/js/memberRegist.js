/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/***************************************************************************
 * ユーザ登録
 **************************************************************************/
function memberRegist() {
    var button = $(this);
    button.attr('disabled', true);
    
    // 生年月日の分割
    dateAry = $('#birthday').val().split(new RegExp('[/-]', 'g'));
    // Dateオブジェクトの生年月日を生成
    birthday = new Date(dateAry[0], dateAry[1] - 1, dateAry[2]);
    
    // 連絡方法区分の値を設定
    var contractWayKbn = null;
    if ($('input[name="contactWayKbn"]:checked').attr('id') === 'contactWayKbnTel') {
        contractWayKbn = '1';
    } else if ($('input[name="contactWayKbn"]:checked').attr('id') === 'contactWayKbnEmail') {
        contractWayKbn = '2';
    }
    
    var memberRegister = {
        loginId:$('#loginId').val(),
        lastName:$('#lastName').val(),
        firstName:$('#firstName').val(),
        lastNameKana:$('#lastNameKana').val(),
        firstNameKana:$('#firstNameKana').val(),
        loginPassword:$('#loginPassword').val(),
        loginPasswordc:$('#loginPasswordc').val(),
        birthday:birthday,
        skypeId:$('#skypeId').val(),
        contactWayKbn:contractWayKbn,
        postalCd:$('#postalCd').val(),
        prefName:$('#prefName').val(),
        cityName:$('#cityName').val(),
        addressDetailName:$('#addressDetailName').val(),
        buildingName:$('#buildingName').val(),
        memberGroupKbn:$('input[name="memberGroupKbn"]:checked').val()
    };
    
    var data = {
        memberRegister:memberRegister
    };
    
    // TODO 処理完成後に削除予定
    alert(JSON.stringify(data));
    
    /***************************************************************
     * メンバー登録
     **************************************************************/
    //$.blockUI();
    $.ajax({
        url: API_PATH + '/' + 'members',
        type: 'post',
        data: JSON.stringify(data),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function() {
            $('#infoarea').append('<li>メンバー登録が完了しました。</li>');
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            $('#errorarea')
                    .append('<li>メンバー登録に失敗しました。管理者にお問合せください。' 
                            + '[ ' + textStatus + ' ]');
            $('#main_result_area').text(XMLHttpRequest.toString());
        },
        complete: function() {
            button.attr('disabled', false);
        }
    });
}

/***************************************************************************
 * 会員区分マスタ取得
 **************************************************************************/
function getMemberGroup() {
    $.ajax({
       url: API_PATH + '/' + 'membergroups' ,
       type: 'get',
       success: function() {
           // TODO メンバー区分のvalue, 名称を動的にセット(LABEL)
       },
       error: function() {
            $('#errorarea').val(
                    'サーバ通信に失敗しました。管理者にお問い合わせください。');
       }
    });
}