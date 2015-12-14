/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eiichi
 */
@Entity
@Table(name = "member")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingMember.findAll", query = "SELECT b FROM BookingMember b"),
    @NamedQuery(name = "BookingMember.findByMemberId", query = "SELECT b FROM BookingMember b WHERE b.memberId = :memberId"),
    @NamedQuery(name = "BookingMember.findByLoginId", query = "SELECT b FROM BookingMember b WHERE b.loginId = :loginId"),
    @NamedQuery(name = "BookingMember.findByLoginPassword", query = "SELECT b FROM BookingMember b WHERE b.loginPassword = :loginPassword"),
    @NamedQuery(name = "BookingMember.findByLastName", query = "SELECT b FROM BookingMember b WHERE b.lastName = :lastName"),
    @NamedQuery(name = "BookingMember.findByFirstName", query = "SELECT b FROM BookingMember b WHERE b.firstName = :firstName"),
    @NamedQuery(name = "BookingMember.findByLastNameKana", query = "SELECT b FROM BookingMember b WHERE b.lastNameKana = :lastNameKana"),
    @NamedQuery(name = "BookingMember.findByFirstNameKana", query = "SELECT b FROM BookingMember b WHERE b.firstNameKana = :firstNameKana"),
    @NamedQuery(name = "BookingMember.findByGender", query = "SELECT b FROM BookingMember b WHERE b.gender = :gender"),
    @NamedQuery(name = "BookingMember.findByBirthday", query = "SELECT b FROM BookingMember b WHERE b.birthday = :birthday"),
    @NamedQuery(name = "BookingMember.findBySkypeId", query = "SELECT b FROM BookingMember b WHERE b.skypeId = :skypeId"),
    @NamedQuery(name = "BookingMember.findByContactWayKbn", query = "SELECT b FROM BookingMember b WHERE b.contactWayKbn = :contactWayKbn"),
    @NamedQuery(name = "BookingMember.findByTel", query = "SELECT b FROM BookingMember b WHERE b.tel = :tel"),
    @NamedQuery(name = "BookingMember.findByEmail", query = "SELECT b FROM BookingMember b WHERE b.email = :email"),
    @NamedQuery(name = "BookingMember.findByPostalCd", query = "SELECT b FROM BookingMember b WHERE b.postalCd = :postalCd"),
    @NamedQuery(name = "BookingMember.findByPrefName", query = "SELECT b FROM BookingMember b WHERE b.prefName = :prefName"),
    @NamedQuery(name = "BookingMember.findByCityName", query = "SELECT b FROM BookingMember b WHERE b.cityName = :cityName"),
    @NamedQuery(name = "BookingMember.findByAddressDetailName", query = "SELECT b FROM BookingMember b WHERE b.addressDetailName = :addressDetailName"),
    @NamedQuery(name = "BookingMember.findByBuildingName", query = "SELECT b FROM BookingMember b WHERE b.buildingName = :buildingName"),
    @NamedQuery(name = "BookingMember.findByInsDate", query = "SELECT b FROM BookingMember b WHERE b.insDate = :insDate"),
    @NamedQuery(name = "BookingMember.findByUpdDate", query = "SELECT b FROM BookingMember b WHERE b.updDate = :updDate")})
public class BookingMember extends Base implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MEMBER_ID")
    private Integer memberId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LOGIN_ID")
    private String loginId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "LOGIN_PASSWORD")
    private String loginPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "LAST_NAME_KANA")
    private String lastNameKana;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "FIRST_NAME_KANA")
    private String firstNameKana;
    @Size(max = 1)
    @Column(name = "GENDER")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "SKYPE_ID")
    private String skypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CONTACT_WAY_KBN")
    private String contactWayKbn;
    @Size(max = 13)
    @Column(name = "TEL")
    private String tel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="無効な電子メール")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 256)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "POSTAL_CD")
    private String postalCd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "PREF_NAME")
    private String prefName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CITY_NAME")
    private String cityName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ADDRESS_DETAIL_NAME")
    private String addressDetailName;
    @Size(max = 100)
    @Column(name = "BUILDING_NAME")
    private String buildingName;

    //追加プロパティ
    @OneToOne
    @JoinColumn(name = "CONTACT_WAY_KBN", nullable = false, insertable = false, updatable = false)
    private MstContactWay mstContactWay;
    @OneToOne
    @JoinColumn(name = "GENDER", nullable = false, insertable = false, updatable = false)
    private MstGender mstGender;
    @OneToOne
    @JoinColumn(name = "MEMBER_ID", nullable = false, insertable = false, updatable = false)
    private RMemberMemberGroup rMemberMemberGroup;

    public BookingMember() {
    }
    
    public BookingMember(Integer memberId) {
        this.memberId = memberId;
    }

    public BookingMember(Integer memberId, String loginId, String loginPassword, String lastName, String firstName, String lastNameKana, String firstNameKana, Date birthday, String skypeId, String contactWayKbn, String postalCd, String prefName, String cityName, String addressDetailName, Date insDate, Date updDate) {
        this.memberId = memberId;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.lastName = lastName;
        this.firstName = firstName;
        this.lastNameKana = lastNameKana;
        this.firstNameKana = firstNameKana;
        this.birthday = birthday;
        this.skypeId = skypeId;
        this.contactWayKbn = contactWayKbn;
        this.postalCd = postalCd;
        this.prefName = prefName;
        this.cityName = cityName;
        this.addressDetailName = addressDetailName;
        this.insDate = insDate;
        this.updDate = updDate;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getContactWayKbn() {
        return contactWayKbn;
    }

    public void setContactWayKbn(String contactWayKbn) {
        this.contactWayKbn = contactWayKbn;
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
    
    public MstContactWay getMstContactWay() {
        return mstContactWay;
    }

    public void setMstContactWay(MstContactWay mstContactWay) {
        this.mstContactWay = mstContactWay;
    }

    public MstGender getMstGender() {
        return mstGender;
    }

    public void setMstGender(MstGender mstGender) {
        this.mstGender = mstGender;
    }
    
    public RMemberMemberGroup getrMemberMemberGroup() {
        return rMemberMemberGroup;
    }

    public void setrMemberMemberGroup(RMemberMemberGroup rMemberMemberGroup) {
        this.rMemberMemberGroup = rMemberMemberGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberId != null ? memberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingMember)) {
            return false;
        }
        BookingMember other = (BookingMember) object;
        if ((this.memberId == null && other.memberId != null) || (this.memberId != null && !this.memberId.equals(other.memberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tnkmatic.onlinebooking.ejb.entity.BookingMember[ memberId=" + memberId + " ]";
    }
    
    @PrePersist
    public void onPrePersist() {
        persistEmbeddableDate();
    }
    
    @PreUpdate
    public void onPreUpdate() {
        updateEmbeddableDate();
    }
}
