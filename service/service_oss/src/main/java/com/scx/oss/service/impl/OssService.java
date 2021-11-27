package com.scx.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.scx.oss.utils.ConstantPropertiesUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @auther scx
 * @date 2021/11/27 - 21:46
 */
@Service
public class OssService implements com.scx.oss.service.OssService {
    @Override
    public String uploadFileAvatar(MultipartFile file) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = ConstantPropertiesUtil.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ConstantPropertiesUtil.KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;


        try {
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
            InputStream inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            //1、避免相同的头像被覆盖
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");

            fileName = uuid + fileName;

            //2、把头像按年月日分类 2021/8/4/01.jpg
            String datePath = new DateTime().toString("yyyy/MM/dd");

            fileName = datePath + "/" + fileName;
            // 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
            /**
             * 第一个参数 Bucket名称
             * 第二个参数 上传到oss文件路径和文件名称
             * 第三个参数 上传文件输入流
             */
            ossClient.putObject(bucketName, fileName, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
            String url = "https://" + bucketName + "." + endpoint + "/" + fileName;
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("上传头像失败..........");
            return null;
        }

    }
}
