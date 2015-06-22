/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var API_PATH = 'http://localhost:8080/OnlineBooking-web/onlinebooking';

/***************************************************************************
 * 郵便番号検索(zipcloud api へのリクエスト)
 **************************************************************************/
function getCityByZipCode() {
    var pCallBack  = 'callback' + '=' + 'showCity';
    var pZipCode   = 'zipcode'  + '=' + $('#postal').val();
    var requestURL = 'http://zipcloud.ibsnet.co.jp/api/search' + '?'
            + pCallBack + '&' + pZipCode;
    
    /***************************************************************************
     * script要素の生成を生成してhead要素に追加
     **************************************************************************/
    $('#pageHeader').append(
            $('<script/>')
            .attr('type', 'text/javascript')
            .attr('src', requestURL));
}

/***************************************************************************
 * 郵便番号検索 JSOPコールバック関数
 **************************************************************************/
function showCity(data) {
    var prefName;
    var cityName;
    var ohazaName;
    
    if (data !== null && data.status === 200) {
        for (var i = 0; i < data.results.length; i++) {
            //http://zipcloud.ibsnet.co.jp/doc/api
            prefName  = data.results[i].address1;
            cityName  = data.results[i].address2;
            ohazaName = data.results[i].address3;

            //都道府県、市区町村、大字名のいずれかが入ればループを抜ける
            if (prefName !== null || 
                    cityName !== null || 
                    ohazaName !== null) {
                break;
            }
        }
        
        $('#address1').val(prefName);
        $('#address2').val(cityName + ohazaName);
    }
}