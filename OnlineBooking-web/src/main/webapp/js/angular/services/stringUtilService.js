/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Stringユーティリティサービス
var StringUtilService = function() {
    this.emptyOrUndefinedToNull = function(target) {
                return (target === undefined || target === "") ? null : target;
            };
};