/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('onlineBookingModule')
        .directive('currency', function() {
            return {
                require : 'ngModel',
                link: function(elem, $scope, attrs, ngModel) {
                    ngModel.$formatters.push(function(val) {
                        return '￥' + val;
                    });
                    ngModel.$parsers.push(function(val) {
                        if (val === undefined) {
                            val = '';
                        } 
                        return val.replace(/^￥/, '');
                    });
                }
            };
});
