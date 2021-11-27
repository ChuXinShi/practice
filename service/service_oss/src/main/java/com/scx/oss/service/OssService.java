package com.scx.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @auther scx
 * @date 2021/11/27 - 21:46
 */
public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
