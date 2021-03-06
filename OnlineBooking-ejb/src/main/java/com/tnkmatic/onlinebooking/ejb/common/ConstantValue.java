/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.common;

/**
 *
 * @author Eiichi
 */
public class ConstantValue {
    public static final String ENCODING = "charset=utf-8";
    
    // メンバーグループ区分
    public static final String MEMBER_GROUP_KBN_TEACHER = "1"; //講師
    public static final String MEMBER_GROUP_KBN_STUDENT = "2"; //生徒
    public static final String MEMBER_GROUP_KBN_ADMIN = "9"; //管理者
    
    //HTTPレスポンス系
    public static final String RESPONSE_CHARSET_UTF8 = "charset=UTF-8";
    
    //検索パラメータ
    public static final String MEMBER_CONDITION_LOGIN_ID = "loginId";
    public static final String MEMBER_CONDITION_FIRST_NAME = "firstName";
    public static final String MEMBER_CONDITION_LAST_NAME = "lastName";
    public static final String MEMBER_GROUP_KBN = "memberGroupKbn";
    
}
