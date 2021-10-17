package com.scx.practice;

import com.scx.practice.entity.EduTeacher;
import com.scx.practice.service.EduTeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class PracticeApplicationTests {

    @Autowired
    private EduTeacherService teacherService;

    @Test
    void contextLoads() {

    }

    @Test
    public void teacherTest() {
        EduTeacher teacher = new EduTeacher();
        teacher.setId("333");
        teacher.setName("888");
        teacher.setIntro("999");
        teacher.setCareer("111");
        teacher.setLevel(1);
        teacher.setAvatar("");
        teacher.setSort(0);
        teacher.setIsDeleted(false);
        teacher.setGmtCreate(new Date());
        teacher.setGmtModified(new Date());
        teacherService.addOrUpdate(teacher);
    }

}
