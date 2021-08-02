package com.project.appManager.utils;

/**
 * @author:MMW
 * @package: com.project.appManager.utils
 * @time: 2021/6/22 17:33
 * @day: 星期二
 */

import org.springframework.stereotype.Component;

/**
 *  系统常量
 */
@Component("constant")
public final class SystemConstant {
    public static final String APP_STATUS = "APP状态";
    public static final String USER_TYPE = "用户状态";
    public static final String APP_PLATFORM = "所属平台";
    // logo上传相对路径
    public static final String UPLOADPATH = "statics/uploadFiles/logo";
    // apk 上传相对路径
    public static final String APKUPLOADPATH = "statics/uploadFiles/apk";
}
