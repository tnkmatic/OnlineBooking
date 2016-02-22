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
import com.tnkmatic.onlinebooking.ejb.entity.RMemberMemberGroup_;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.reference.MemberReferenceCondition;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
        
        //From句の設定
        Root<BookingMember> root = criteriaQuery.from(BookingMember.class);
        //結合の定義
        Join<BookingMember, RMemberMemberGroup> join = root.join(BookingMember_.rMemberMemberGroup);
        //Select句の設定
        criteriaQuery = criteriaQuery.select(root);        
        //動的条件設定用のオブジェクト生成(Where句の生成)
        List<Predicate> whereConditions = new ArrayList<>();
        if (memberCondition.getLoginId() != null) { //ログインID
            whereConditions.add(
                    builder.equal(root.get(BookingMember_.loginId), 
                            memberCondition.getLoginId()));
        }
        if (memberCondition.getFirstName() != null) {   //氏名(名)
            whereConditions.add(
                    builder.equal(root.get(BookingMember_.firstName), 
                            memberCondition.getFirstName()));
        }
        if (memberCondition.getLastName() != null) {    //氏名(姓)
            whereConditions.add(
                    builder.equal(root.get(BookingMember_.lastName),
                            memberCondition.getLastName()));
        }
        if (memberCondition.getMemberGroupKbn() != null) {  //グループ区分(講師 or 生徒 or 管理者)
            whereConditions.add(
                    builder.equal(join.get(RMemberMemberGroup_.memberGroupKbn), 
                            memberCondition.getMemberGroupKbn()));
        }
        criteriaQuery.where(
                builder.and(whereConditions.toArray(new Predicate[]{})));

        //JPQLの発行
        Query q = em.createQuery(criteriaQuery);
        List<BookingMember> resultList = q.getResultList();
        
        return resultList;
    }
}
