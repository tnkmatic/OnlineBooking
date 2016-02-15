/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.dao.custom;

import com.tnkmatic.onlinebooking.ejb.common.ConstantValue;
import com.tnkmatic.onlinebooking.ejb.entity.BookingMember;
import com.tnkmatic.onlinebooking.ejb.entity.BookingMember_;
import com.tnkmatic.onlinebooking.ejb.entity.RMemberMemberGroup;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.reference.MemberReferenceCondition;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

/**
 *
 * @author tnkmatic@outlook.jp
 */
@Stateless
@LocalBean
public class BookingMemberCustom {
    @PersistenceContext(unitName = "com.tnkmatic_OnlineBooking-ejb_PU")
    private EntityManager em;
    
    public List<BookingMember> findCondition(MemberReferenceCondition memberCondition) {
        //クエリオブジェクトの取得
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<BookingMember> criteriaQuery = builder.createQuery(BookingMember.class);
        //JPQLでの別名取得
        Root<BookingMember> bm = criteriaQuery.from(BookingMember.class);
        SetJoin<BookingMember, RMemberMemberGroup> bmg = bm.join(BookingMember_.rMemberMemberGroup);
        
        //JPQLの生成
        criteriaQuery = criteriaQuery.select(bm);
        if (memberCondition.getLoginId() != null) { //ログインID
            criteriaQuery = criteriaQuery.where(
                    builder.equal(bm.get(ConstantValue.MEMBER_CONDITION_LOGIN_ID), 
                            memberCondition.getLoginId()));
        }
        if (memberCondition.getFirstName() != null) {   //氏名(名)
            criteriaQuery = criteriaQuery.where(
                    builder.equal(bm.get(ConstantValue.MEMBER_CONDITION_FIRST_NAME),
                            memberCondition.getFirstName()));
        }
        if (memberCondition.getLastName() != null) {    //氏名(姓)
            criteriaQuery = criteriaQuery.where(
                    builder.equal(bm.get(ConstantValue.MEMBER_CONDITION_LAST_NAME),
                            memberCondition.getLastName()));
        }
        if (memberCondition.getMemberGroupKbn() != null) {  //グループ区分(講師 or 生徒 or 管理者)
            criteriaQuery = criteriaQuery.where(
                    builder.equal(bm.get("bm.rMemberMemberGroup.memberGroupKbn"),
                            memberCondition.getMemberGroupKbn()));
        }

        //JPQLの発行
        Query q = em.createQuery(criteriaQuery);
        List<BookingMember> resultList = q.getResultList();
        
        return resultList;
    }
}
