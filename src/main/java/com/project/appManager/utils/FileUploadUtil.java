package com.project.appManager.utils;


import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.io.File;
import java.util.UUID;

/**
 * @author:MMW
 * @package: com.project.appManager.utils
 * @time: 2021/6/27 16:10
 * @day: 星期日
 */
@SuppressWarnings("All")
public class FileUploadUtil {
    /**
     * 实现文件上传
     * @param savePath 保存路径
     * @param file     上传文件
     * @return          文件名
     */
    public static String uploadFile(String savePath, CommonsMultipartFile file){
        try{
            // 生成唯一文件名
            String originalFilename = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString() + "-" + originalFilename;
            // 上传文件
            File saveFile = new File(savePath + "/" + fileName);
            file.transferTo(saveFile);
            return fileName;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除指定文件
     * @param path
     */
    public static void deleteFile(String path){
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
    }

}
