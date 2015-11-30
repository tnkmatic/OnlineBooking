/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tnkmatic.onlinebooking.ejb.service.impl;

import com.tnkmatic.onlinebooking.ejb.common.ConstantValue;
import com.tnkmatic.onlinebooking.ejb.dao.BookingMemberFacadeLocal;
import com.tnkmatic.onlinebooking.ejb.dao.MemberStudentFacadeLocal;
import com.tnkmatic.onlinebooking.ejb.dao.MemberTeacherFacadeLocal;
import com.tnkmatic.onlinebooking.ejb.dao.RMemberMemberGroupFacadeLocal;
import com.tnkmatic.onlinebooking.ejb.dao.custom.BookingMemberCustom;
import com.tnkmatic.onlinebooking.ejb.entity.BookingMember;
import com.tnkmatic.onlinebooking.ejb.entity.MemberStudent;
import com.tnkmatic.onlinebooking.ejb.entity.MemberTeacher;
import com.tnkmatic.onlinebooking.ejb.entity.RMemberMemberGroup;
import com.tnkmatic.onlinebooking.ejb.entity.RMemberMemberGroupPK;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.reference.MemberReferenceCondition;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.register.MemberRegisterRequest;
import com.tnkmatic.onlinebooking.ejb.service.MemberServiceLocal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Eiichi
 */
@Stateless
@Local(MemberServiceLocal.class)
public class MemberService implements MemberServiceLocal {
    @EJB private BookingMemberFacadeLocal bookingMemberDao;
    @EJB private RMemberMemberGroupFacadeLocal rMemberMemberGroupDao;
    @EJB private MemberTeacherFacadeLocal memberTeacherDao;
    @EJB private MemberStudentFacadeLocal memberStudenDao;
    @EJB private BookingMemberCustom bookingMemberCustomDao;
    
    // TODO リファクタリング(多態性)
    
    @Override
    public BookingMember memberRegist(MemberRegisterRequest memberRegister) throws Exception {
        Integer memberId = null;
        BookingMember bookingMember = null;
        
        try {
            // 処理基準日
//            Date processDate = new Date();

            // メンバーエンティティの生成
            bookingMember = new BookingMember();
            BeanUtils.copyProperties(bookingMember, memberRegister);
            // ハッシュ化(SHA-256)をパスワード設定
            bookingMember.setLoginPassword(
                    DigestUtils.sha256Hex(memberRegister.getLoginPassword()));
            
            // メンバーの永続化
            bookingMemberDao.create(bookingMember);
            // 強制的にFlushすることでメンバーIDを採番
            bookingMemberDao.flush();
            // 生成されたメンバーIDを取得
            memberId = bookingMember.getMemberId();
            
            // TODO ロガーによる出力に変更
            System.out.println("memberId = " + memberId);

            // メンバーグループ関連PKエンティティの生成
            final RMemberMemberGroupPK rMemberMemberGroupPk = new RMemberMemberGroupPK();
            rMemberMemberGroupPk.setMemberId(memberId);
            BeanUtils.copyProperties(rMemberMemberGroupPk, memberRegister);
            // メンバーグループ関連エンティティの生成
            final RMemberMemberGroup rMemberMemberGroup = new RMemberMemberGroup(processDate);
            BeanUtils.copyProperties(rMemberMemberGroup, memberRegister);
            rMemberMemberGroup.setRMemberMemberGroupPK(rMemberMemberGroupPk);

            // メンバーグループ関連の永続化
            rMemberMemberGroupDao.create(rMemberMemberGroup);
            
            if (!StringUtils.isEmpty(memberRegister.getMemberGroupKbn())) {
                if (ConstantValue.MEMBER_GROUP_KBN_TEACHER.equals(
                        memberRegister.getMemberGroupKbn())) {
                    // 講師エンティティの永続化
                    memberTeacherDao.create(
                            createMemberTeacher(memberId, processDate));
                } else if (ConstantValue.MEMBER_GROUP_KBN_STUDENT.equals(
                        memberRegister.getMemberGroupKbn())) {
                    // 生徒エンティティの永続化
                    memberStudenDao.create(
                            createMemberStudent(memberId, processDate));
                } else {
                    //
                }
            }
        } catch (Exception e) {
            if (e.getCause().getCause() instanceof javax.validation.ConstraintViolationException) {
                ConstraintViolationException cve = (ConstraintViolationException) e.getCause().getCause();
                System.out.println("size:" + cve.getConstraintViolations().size());
                for (Iterator<ConstraintViolation<?>> it 
                        = cve.getConstraintViolations().iterator(); it.hasNext();) {
                    ConstraintViolation cv = it.next();
                    System.out.println("class:" + cv.getRootBeanClass().getSimpleName());
                    System.out.println("field:" + cv.getPropertyPath().toString());
                    System.out.println("type:" + cv.getConstraintDescriptor().getAnnotation().annotationType());
                    System.out.println("message:" + cv.getMessage());
                }
            }
        }
        
        return bookingMember;
    }

    @Override
    public List<BookingMember> memberReference(MemberReferenceCondition memberCondition) throws Exception {
        return bookingMemberCustomDao.findCondition(memberCondition);
    }
    
    private MemberTeacher createMemberTeacher(
            final Integer memberId, final Date processDate) throws Exception {
        // 講師エンティティクラスの生成
        final MemberTeacher memberTeacher = new MemberTeacher();
        memberTeacher.setMemberId(memberId);
        memberTeacher.setInsDate(processDate);
        memberTeacher.setUpdDate(processDate);
        return memberTeacher;
   }
    
    private MemberStudent createMemberStudent(
            final Integer memberId, final Date processDate) throws Exception {
        // 生徒エンティティクラスの生成
        final MemberStudent memberStudent = new MemberStudent();
        memberStudent.setMemberId(memberId);
        memberStudent.setInsDate(processDate);
        memberStudent.setUpdDate(processDate);
        return memberStudent;
    }
}
