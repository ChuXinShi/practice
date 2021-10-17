package com.scx.eduservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scx.eduservice.entity.EduTeacher;
import com.scx.eduservice.mapper.EduTeacherMapper;
import com.scx.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-10-10
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Autowired
    private EduTeacherMapper teacherMapper;

    @Override
    public Integer addOrUpdate(EduTeacher teacher) {
        //根据teacher是否有id，判断为添加还是修改
        int i;
        if (StringUtils.isEmpty(teacher.getId())) {
            i = teacherMapper.insert(teacher);
            return i;
        } else {
            i = teacherMapper.updateById(teacher);
            return i;
        }

    }

    @Override
    public boolean delTeacher(String id) {
        int i = teacherMapper.deleteById(id);
        return i == 1 ? true : false;
    }
}
