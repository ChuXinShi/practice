package com.scx.eduservice.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scx.commonutils.R;
import com.scx.eduservice.entity.EduTeacher;
import com.scx.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
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
@Api(value = "讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;


    @PostMapping("addOrUpdateTeacher")
    public R addOrUpdateTeacher(@RequestBody EduTeacher teacher) {
        Integer i = teacherService.addOrUpdate(teacher);
        return i == 1 ? R.ok() : R.error();
    }

    @DeleteMapping("delTeacher")
    public R delTeacher(@RequestParam String id){
        boolean flag = teacherService.delTeacher(id);
        return R.ok().data("flag",flag);
    }

    /**
     * 分页查询讲师
     */
    @GetMapping("getPageTeacher/{current}/{limit}")
    public R getPageTeacher(@RequestBody(required = false) EduTeacher teacher,
                            @PathVariable Integer current,
                            @PathVariable Integer limit){
        Page<EduTeacher> teacherPage = new Page<>(current,limit);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(teacher.getName())){
            wrapper.like("name",teacher.getName());
        }
        Page<EduTeacher> page = (Page<EduTeacher>) teacherService.page(teacherPage,wrapper);
        long total = page.getTotal();
        long pages = page.getPages();
        System.out.println("total = "+total);
        System.out.println("pages = "+pages);
        return R.ok().data("page",page).data("total",total).data("pages",pages);
    }

    /**
     * 查询所有讲师
     */
    @GetMapping("getAllTeacher")
    public R getAllTeacher(){
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("list",list);
    }

}

