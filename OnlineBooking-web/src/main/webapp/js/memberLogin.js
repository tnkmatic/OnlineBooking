/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/***************************************************************************
 * ログイン
 **************************************************************************/
function memberLogin() {
    
    $.ajax({
        url: 'http://localhost:8080onlinebooking/j_security_check',
        type: 'post',
        headers: {
            Authorization: 'SEIBUSISHAKAI xxxxxxxxxxxx',
            Date: dateGMT
        },
        data: JSON.stringify(data),
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        success: function(json_data) {
            $.each(json_data, function(key, value){
                $('#divResponseBody')
                        .append(key + ':' + value)
                        .append('<br />');
            });
        },
        error: function() {
            alert("Server Error. Pleasy try again later.");
        },
        complete: function() {
            button.attr('disabled', false);
        }
    });
}