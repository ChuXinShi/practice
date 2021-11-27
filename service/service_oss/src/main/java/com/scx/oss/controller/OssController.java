package com.scx.oss.controller;

import com.scx.commonutils.R;
import com.scx.oss.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @auther scx
 * @date 2021/11/27 - 21:47
 */
@Api(description = "上传头像")
@RestController
@CrossOrigin
@RequestMapping("/eduoss/fileoss")
public class OssController {

    @Autowired
    private OssService ossService;

    @ApiOperation(value = "上传头像")
    @PostMapping("uploadFile")
    public R uploadFile(MultipartFile file) {
        String url = ossService.uploadFileAvatar(file);
        return R.ok().data("url", url);
    }
}
