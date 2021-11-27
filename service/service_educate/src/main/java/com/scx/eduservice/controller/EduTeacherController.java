package com.scx.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scx.commonutils.R;
import com.scx.eduservice.entity.EduTeacher;
import com.scx.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-10-10
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;


    @ApiOperation(value = "添加或修改讲师")
    @PostMapping("addOrUpdateTeacher")
    public R addOrUpdateTeacher(@RequestBody EduTeacher teacher) {
        Integer i = teacherService.addOrUpdate(teacher);
        return i == 1 ? R.ok() : R.error();
    }

    @ApiOperation(value = "删除讲师")
    @DeleteMapping("delTeacher")
    public R delTeacher(@RequestParam String id) {
        boolean flag = teacherService.delTeacher(id);
        return R.ok().data("flag", flag);
    }

    /**
     * 分页查询讲师
     */
    @ApiOperation(value = "分页查询讲师")
    @PostMapping("getPageTeacher/{current}/{limit}")
    public R getPageTeacher(@RequestBody(required = false) EduTeacher teacher,
                            @PathVariable Integer current,
                            @PathVariable Integer limit) {
        Page<EduTeacher> teacherPage = new Page<>(current, limit);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(teacher.getName())) {
            wrapper.like("name", teacher.getName());
        }
        teacherService.page(teacherPage, wrapper);
        long total = teacherPage.getTotal();
        List<EduTeacher> records = teacherPage.getRecords();
        System.out.println("total = " + total);
        return R.ok().data("total", total).data("records", records);
    }

    /**
     * 查询所有讲师
     */
    @ApiOperation(value = "查询所有讲师")
    @GetMapping("getAllTeacher")
    public R getAllTeacher() {
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("list", list);
    }

}

