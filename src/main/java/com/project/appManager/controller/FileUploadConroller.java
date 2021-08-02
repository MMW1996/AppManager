package com.project.appManager.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author:MMW
 * @package: com.project.appManager.controller
 * @time: 2021/6/29 9:38
 * @day: 星期二
 */
@Controller
public class FileUploadConroller {
    private static final String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
    private static final String accessId = "LTAI5tFYEnuqZuvAdrDk9NLg";
    private static final String accessSecret = "w37FHHTkhoMKKTrXYqRyDPtqOWXiKQ";
    private static final String bucketName = "mmw-1996";
    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "file")CommonsMultipartFile file){
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessId, accessSecret);
        System.out.println(file.getName()); // 文件域表单名
        System.out.println(file.getOriginalFilename());
        ArrayList<String> type = new ArrayList<>();
        type.add("jpg");
        type.add("png");
        type.add("jpeg");

        if(!file.isEmpty()){
            String uploadPath = "root/images/" + UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
            String fileType = file.getOriginalFilename().toString().toLowerCase().substring(file.getOriginalFilename().toString().lastIndexOf(".")+1);
            System.out.println(fileType);
            if(!type.contains(fileType)){
                return "redirect:index.jsp?info=文件类型不支持";
            }
            try {
                PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uploadPath, file.getInputStream());
                ossClient.putObject(putObjectRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ossClient.shutdown();
        return "redirect:index.jsp?info=文件上传成功";
    }

    @RequestMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        // 解决中文乱码问题
        // attachment 附件
        response.setHeader("Content-Disposition","attachment;filename = " + java.net.URLEncoder.encode("北大青鸟.mp3","UTF-8"));
        // 设置响应数据类型
        response.setContentType("audio/mp3");
        File file = new File("D:\\Downloads\\aa.mp3");
        // 文件写入输入流
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();
        // 输出
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);
    }
}
