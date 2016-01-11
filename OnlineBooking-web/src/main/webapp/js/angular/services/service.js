/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * factoryメソッドでは共有するオブジェクトや関数を返す関数を登録(memberService)
 */
onlineBookingModule.service(
        'memberService', ['$resource', '$rootScope', MemberService]
);