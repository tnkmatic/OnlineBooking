/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.dao.custom;

import com.tnkmatic.onlinebooking.ejb.dao.impl.BookingMemberFacade;
import com.tnkmatic.onlinebooking.ejb.entity.BookingMember;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.reference.MemberReferenceCondition;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
        //JPQLでの別名取得
        Root<BookingMember> bm = criteriaQuery.from(BookingMember.class);
        //JPQLの生成
        criteriaQuery = criteriaQuery.select(bm);
        if (memberCondition.getLoginId() != null) {
            criteriaQuery = criteriaQuery.where(
                    builder.equal(bm.get("loginId"), memberCondition.getLoginId()));
        }
        //JPQLの発行
        Query q = em.createQuery(criteriaQuery);
        List<BookingMember> resultList = q.getResultList();
        
        return resultList;
    }
}
