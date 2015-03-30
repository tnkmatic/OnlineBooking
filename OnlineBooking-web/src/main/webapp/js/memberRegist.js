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
    
    var memberRegister = {
        studentFName:$('#studentfname').val(),
        studentLName:$('#studentlname').val(),
        studentFNameKana:$('#studentfnamekana').val(),
        studentLNameKana:$('#studentfnamekana').val(),
        password:$('#password').val(),
        birthday:$('#birthday').val(),
        skypeId:$('#skypeid').val(),
        lineKbn:$('input[name="l"]:checked').val(),
        postalCd:$('#postalcd').val(),
        prefName:$('#prefname').val(),
        cityName:$('#cityname').val(),
        chomeName:$('#chomeName').val(),
        buildingName:$('#buildingname').val()
    };
    
    var data = {
        memberRegister:memberRegister
    };
    
    /***************************************************************
     * メンバー登録
     **************************************************************/
    $.ajax({
        url: API_PATH + '/' + 'members',
        type: 'post',
        data: JSON.stringify(data),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function() {
            $('#infoarea').val('メンバー登録が完了しました。')
        },
        error: function() {
            $('#errorarea').val(
                    'メンバー登録に失敗しました。管理者にお問合せください。');
        },
        complete: function() {
            button.attr('disabled', false);
        }
    });
}