/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.resource.response.member;

import com.tnkmatic.onlinebooking.ejb.resource.response.BaseResponseDetail;
import java.util.Date;

/**
 *
 * @author tnkmatic@outlook.jp
 */
public class MemberResponseDetail extends BaseResponseDetail {
    private String loginId;
    private String lastName;
    private String firstName;
    private String lastNameKana;
    private String firstNameKana;
    private String genderName;
    private Date birthday;
    private String skypeId;
    private String contactWayName;
    private String tel;
    private String email;
    private String postalCd;
    private String prefName;
    private String cityName;
    private String addressDetailName;
    private String buildingName;
    private String memberGroupKbnName;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNameKana() {
        return lastNameKana;
    }

    public void setLastNameKana(String lastNameKana) {
        this.lastNameKana = lastNameKana;
    }

    public String getFirstNameKana() {
        return firstNameKana;
    }

    public void setFirstNameKana(String firstNameKana) {
        this.firstNameKana = firstNameKana;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSkypeId() {
        return skypeId;
    }

    public void setSkypeId(String skypeId) {
        this.skypeId = skypeId;
    }

    public String getContactWayName() {
        return contactWayName;
    }

    public void setContactWayName(String contactWayName) {
        this.contactWayName = contactWayName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalCd() {
        return postalCd;
    }

    public void setPostalCd(String postalCd) {
        this.postalCd = postalCd;
    }

    public String getPrefName() {
        return prefName;
    }

    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAddressDetailName() {
        return addressDetailName;
    }

    public void setAddressDetailName(String addressDetailName) {
        this.addressDetailName = addressDetailName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getMemberGroupKbnName() {
        return memberGroupKbnName;
    }

    public void setMemberGroupKbnName(String memberGroupKbnName) {
        this.memberGroupKbnName = memberGroupKbnName;
    }
    
    
}
