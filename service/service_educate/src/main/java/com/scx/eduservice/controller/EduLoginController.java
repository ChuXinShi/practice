package com.scx.eduservice.controller;

import com.scx.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @auther scx
 * @date 2021/10/17 - 12:27
 */
@RestController
@RequestMapping("eduservice/user")
@CrossOrigin
@Api(description = "后台管理登陆")
public class EduLoginController {

    @ApiOperation("登陆")
    @PostMapping("login")
    public R login() {
        return R.ok().data("token", "admin");
    }

    @ApiOperation(value = "获取登陆后信息")
    @GetMapping("info")
    public R getInfo() {
        return R.ok().data("roles", "[admin]").data("name", "admin").data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }


    @ApiOperation("登出")
    @PostMapping("logout")
    public R logout() {
        return R.ok();
    }
}
