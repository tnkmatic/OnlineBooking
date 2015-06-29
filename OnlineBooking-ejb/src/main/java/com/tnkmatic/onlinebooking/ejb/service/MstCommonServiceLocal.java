/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tnkmatic.onlinebooking.ejb.service;

import com.tnkmatic.onlinebooking.ejb.entity.MstCourse;
import com.tnkmatic.onlinebooking.ejb.entity.MstEmploy;
import com.tnkmatic.onlinebooking.ejb.entity.MstGender;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tnkmatic@outlook.jp
 */
@Local
public interface MstCommonServiceLocal {
    public List<MstGender> mstGenderSelectAll();
    public List<MstEmploy> mstEmploySelectAll();
    public List<MstCourse> mstCourseSelectAll();
}
