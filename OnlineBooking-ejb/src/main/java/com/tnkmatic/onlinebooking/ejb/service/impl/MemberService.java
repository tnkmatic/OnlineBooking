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
import com.tnkmatic.onlinebooking.ejb.dao.RMemberStudentCourseFacadeLocal;
import com.tnkmatic.onlinebooking.ejb.dao.RMemberTeacherCourseFacadeLocal;
import com.tnkmatic.onlinebooking.ejb.entity.BookingMember;
import com.tnkmatic.onlinebooking.ejb.entity.MemberStudent;
import com.tnkmatic.onlinebooking.ejb.entity.MemberTeacher;
import com.tnkmatic.onlinebooking.ejb.entity.RMemberMemberGroup;
import com.tnkmatic.onlinebooking.ejb.entity.RMemberStudentCourse;
import com.tnkmatic.onlinebooking.ejb.entity.RMemberStudentCoursePK;
import com.tnkmatic.onlinebooking.ejb.entity.RMemberTeacherCourse;
import com.tnkmatic.onlinebooking.ejb.entity.RMemberTeacherCoursePK;
import com.tnkmatic.onlinebooking.ejb.entity.TrnReserve_;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.MemberRegisterRequest;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.MemberStudentCourseRequest;
import com.tnkmatic.onlinebooking.ejb.resource.request.member.MemberTeacherCourseRequest;
import com.tnkmatic.onlinebooking.ejb.service.MemberServiceLocal;
import java.lang.reflect.InvocationTargetException;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import org.apache.commons.beanutils.BeanUtils;
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
    @EJB private RMemberTeacherCourseFacadeLocal rMemberTeacherCourseDao;
    @EJB private RMemberStudentCourseFacadeLocal rMemberStudentCourseDao;
    
    @Override
    public void memberRegist(final MemberRegisterRequest memberRegister)
            throws IllegalAccessException, InvocationTargetException {
        // パスワードをハッシュ化(SHA-256)
        
        
        // メンバーエンティティクラスの生成
        final BookingMember bookingMember = new BookingMember();
        BeanUtils.copyProperties(bookingMember, memberRegister);

        // メンバーグループ関連クラスの生成
        final RMemberMemberGroup rMemberMemberGroup = new RMemberMemberGroup();
        BeanUtils.copyProperties(rMemberMemberGroup, memberRegister);
        
        // メンバー・メンバーグループ関連の永続化
        bookingMemberDao.create(bookingMember);
        rMemberMemberGroupDao.create(rMemberMemberGroup);
        
        // 生成されたメンバーIDを取得
        final Integer memberId = bookingMember.getMemberId();

        if (!StringUtils.isEmpty(memberRegister.getMemberGroupKbn())) {
            if (ConstantValue.MEMBER_GROUP_KBN_TEACHER.equals(
                    memberRegister.getMemberGroupKbn())) {
                // 講師エンティティクラスの生成
                final MemberTeacher memberTeacher = new MemberTeacher();
                BeanUtils.copyProperties(
                        memberTeacher, memberRegister.getMemberTeacherRequest());
                memberTeacher.setMemberId(memberId);
                // 講師エンティティの永続化
                memberTeacherDao.create(memberTeacher);
                
                // 講師コースエンティティクラスの生成
                for (final MemberTeacherCourseRequest memberTeacherCourseRequest
                        : memberRegister.getMemberTeacherRequest().getMemberTeacherCourseRequestList()) {
                    final RMemberTeacherCourse rMemberTeacherCourse =
                            new RMemberTeacherCourse();
                    BeanUtils.copyProperties(
                        rMemberTeacherCourse, memberTeacherCourseRequest);
                    final RMemberTeacherCoursePK pk = new RMemberTeacherCoursePK();
                    pk.setMemberId(memberId);
                    pk.setCourseId(memberTeacherCourseRequest.getCourseId());
                    rMemberTeacherCourse.setRMemberTeacherCoursePK(pk);
                    // 永続化
                    rMemberTeacherCourseDao.create(rMemberTeacherCourse);
                }
            } else if (ConstantValue.MEMBER_GROUP_KBN_STUDENT.equals(
                    memberRegister.getMemberGroupKbn())) {
                // 生徒エンティティクラスの生成
                final MemberStudent memberStudent = new MemberStudent();
                BeanUtils.copyProperties(
                        memberStudent, memberRegister.getMemberStudentRequest());
                memberStudent.setMemberId(memberId);
                // 生徒エンティティの永続化
                memberStudenDao.create(memberStudent);
                
                // 生徒コースエンティティクラスの生成
                for (final MemberStudentCourseRequest memberStudentCourseRequest
                        : memberRegister.getMemberStudentRequest().getMemberStudentCourseRequestList()) {
                    final RMemberStudentCourse rMemberStudentCourse =
                            new RMemberStudentCourse();
                    BeanUtils.copyProperties(
                            rMemberStudentCourse, memberStudentCourseRequest);
                    final RMemberStudentCoursePK pk = new RMemberStudentCoursePK();
                    pk.setMemberId(memberId);
                    pk.setCourseId(memberStudentCourseRequest);
                }

                INS_DATE, UPD_DATEのコメント
                シーケンスが取得できるか（メンバーID）
                
            } else {
                //
            }
        }
                
                
 
        
        
        // Entityオブジェクトにコピー
        
        
        
        
        
        
    }
}
