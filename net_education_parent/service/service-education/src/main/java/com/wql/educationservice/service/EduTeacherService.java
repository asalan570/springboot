package com.wql.educationservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wql.educationservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wql.educationservice.entity.vo.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author wql
 * @since 2020-04-13
 */
public interface EduTeacherService extends IService<EduTeacher> {

    void pageQuery(Page<EduTeacher> page, TeacherQuery teacherQuery);
}
