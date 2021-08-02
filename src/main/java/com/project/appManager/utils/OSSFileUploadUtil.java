package com.project.appManager.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.project.appManager.entity.AppInfo;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @author:MMW
 * @package: com.project.appManager.utils
 * @time: 2021/6/29 10:56
 * @day: 星期二
 */
@SuppressWarnings("All")
public class OSSFileUploadUtil {
    private static String endpoint;
    private static String accessId;
    private static String accessSecret;
    private static String bucketName;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("OSS.properties");
        endpoint = bundle.getString("endpoint");
        accessId = bundle.getString("accessId");
        accessSecret = bundle.getString("accessSecret");
        bucketName = bundle.getString("bucketName");
    }
    private static OSS ossClient = new OSSClientBuilder().build(endpoint, accessId, accessSecret);

    /**
     * upload image to aliyun oss
     * @param file
     * @param appInfo
     * @return ObjectName
     * @throws IOException
     */
    public static String upload(CommonsMultipartFile file, AppInfo appInfo) {
        String fileName = file.getOriginalFilename();
        if(typeCheck(fileName)){
            String objectName = "root/images/" + appInfo.getId() + "/" + fileName;
            PutObjectRequest putObjectRequest = null;
            try {
                putObjectRequest = new PutObjectRequest(bucketName, objectName, file.getInputStream());
            } catch (IOException e) {
                System.err.println("上传异常");
            }
            ossClient.putObject(putObjectRequest);
            return objectName;
        }
        return null;
    }

    /**
     * delete devUser's original logo in aliyun oss
     * @param appInfo
     */
    public static void delete(String objectName){
        if(objectName!=null&&!objectName.isEmpty()){
            ossClient.deleteObject(bucketName,objectName);
        }
    }

    /**
     * appInfo logo update
     * @param file
     * @param appInfo 
     */
    public static String logoUpdate(CommonsMultipartFile file,AppInfo appInfo){
        delete(appInfo.getLogopicpath());
        String objectName = upload(file, appInfo);
        URL url = accessLink(objectName, 2);
        appInfo.setLogopicpath(objectName);
        appInfo.setLogolocpath(url.toString());
        System.out.println("上传文件:" + url.toString());
        return objectName;
    }

    /**
     *  文件下载
     *
     */



    /**
     * get access link of oss's object
     * @param objectName oss objectName
     * @param validTime  validTime/hour
     * @return URL
     */
    public static URL accessLink(String objectName,int validTime){
        int hour = 3600000;
        Date expiration = new Date(new Date().getTime() + hour * validTime);
        URL url = ossClient.generatePresignedUrl(bucketName, objectName, expiration);
        return url;
    }

    /**
     * ossClient close
     */
    public static void shutDown(){
       ossClient.shutdown();
    }

    private static boolean typeCheck(String fileName){
        ArrayList<String> type = new ArrayList<>();
        type.add("jpg");
        type.add("png");
        type.add("jpeg");
        int point = fileName.lastIndexOf(".");
        String fileType = fileName.toLowerCase().substring(point+1);
        return type.contains(fileType);
    }

}
