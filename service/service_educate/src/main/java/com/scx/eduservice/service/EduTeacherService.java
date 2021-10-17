package com.scx.eduservice.service;

import com.scx.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-10-10
 */
public interface EduTeacherService extends IService<EduTeacher> {

    Integer addOrUpdate(EduTeacher teacher);

    boolean delTeacher(String id);
}
