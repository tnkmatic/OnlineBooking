/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var stringToDate = function(str) {
    var splitArray = str.split(new RegExp('[/-]', 'g'));
    return new Date(splitArray[0], splitArray[1] - 1, splitArray[2]);
};
