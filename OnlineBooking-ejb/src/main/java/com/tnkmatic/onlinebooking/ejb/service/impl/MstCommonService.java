/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.service.impl;

import com.tnkmatic.onlinebooking.ejb.dao.MstBusinessHoursFacadeLocal;
import com.tnkmatic.onlinebooking.ejb.dao.MstCourseFacadeLocal;
import com.tnkmatic.onlinebooking.ejb.dao.MstEmployFacadeLocal;
import com.tnkmatic.onlinebooking.ejb.dao.MstGenderFacadeLocal;
import com.tnkmatic.onlinebooking.ejb.dao.MstLessonTimespaceFacadeLocal;
import com.tnkmatic.onlinebooking.ejb.entity.MstBusinessHours;
import com.tnkmatic.onlinebooking.ejb.entity.MstCourse;
import com.tnkmatic.onlinebooking.ejb.entity.MstEmploy;
import com.tnkmatic.onlinebooking.ejb.entity.MstGender;
import com.tnkmatic.onlinebooking.ejb.entity.MstLessonTimespace;
import com.tnkmatic.onlinebooking.ejb.service.MstCommonServiceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author tnkmatic@outlook.jp
 */
@Stateless
public class MstCommonService implements MstCommonServiceLocal {
    @EJB MstGenderFacadeLocal mstGenderDao;
    @EJB MstCourseFacadeLocal mstCourseDao;
    @EJB MstEmployFacadeLocal mstEmployDao;
    @EJB MstBusinessHoursFacadeLocal mstBusinessHoursDao;
    @EJB MstLessonTimespaceFacadeLocal mstLessonTimespaceDao;

    @Override
    public List<MstGender> mstGenderSelectAll() {
        final List<MstGender> listMstGender = mstGenderDao.findAll();
        return listMstGender;
    }

    @Override
    public List<MstEmploy> mstEmploySelectAll() {
        final List<MstEmploy> listMstEmploy = mstEmployDao.findAll();
        return listMstEmploy;
    }

    @Override
    public List<MstCourse> mstCourseSelectAll() {
        final List<MstCourse> listMstCourse = mstCourseDao.findAll();
        return listMstCourse;
    }

    @Override
    public List<MstBusinessHours> mstBusinessHoursSelectAll() {
        final List<MstBusinessHours> listMstBusinessHours = mstBusinessHoursDao.findAll();
        return listMstBusinessHours;
    }

    @Override
    public List<MstLessonTimespace> mstLessonTimespaceSelectAll() {
        final List<MstLessonTimespace> listMstLessonTimespace = mstLessonTimespaceDao.findAll();
        return listMstLessonTimespace;
    }
}
