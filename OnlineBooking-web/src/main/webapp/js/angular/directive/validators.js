/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('onlineBookingModule')
        .directive('cdLessThanDate',['$parse', function($parse) {
            return {
                require: 'ngModel',
                link: function(scope, element, attrs, controller) {
                    /*
                     * param1：スコープオブジェクト
                     * param2：ディレクティブが指定された要素
                     * param3：ディレクティブが指定された要素の属性群
                     * param4：ディレクティブに適用されたコントローラ
                     */
                    scope.$watch( function() {
                       var target = $parse(attrs.cdLessThanDate)(scope);
                       return !controller.$modelValue || target <= controller.$modelValue;
                    }, function(currentValue) {
                        controller.$setValidity('lessThanDate', currentValue);
                    });
                }
            };
        }])
        .directive('parseDirective', ['$parse', function($parse) {
            return {
                template : 'x : {{x}}, y : {{y}}, literal : {{isLiteral}}, constant : {{isConstant}}',
                scope: {},
                link : function(scope) {
                    scope.x = 123;
                    // scope.x を取得する関数を$parse経由で生成
                    var getter = $parse('x');
                    // scope.y に scope.x の値を設定
                    scope.y = getter(scope);
                    // scope.xに値を設定する関数を取得
                    var setter = getter.assign;
                    setter(scope, 456);
                    // $parseに渡した式がリテラルかどうかの確認
                    scope.isLiteral = getter.literal;
                    // $parseに渡した式が変更可能かどうかの確認
                    scope.isConstant = getter.constant;
                }
            };
        }]);
    