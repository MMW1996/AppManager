import com.github.pagehelper.PageInfo;
import com.project.appManager.entity.AppCategory;
import com.project.appManager.entity.AppQueryInfo;
import com.project.appManager.entity.AppQueryResult;
import com.project.appManager.service.AppCategoryService;

import com.project.appManager.service.AppInfoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

/**
 * @author:MMW
 * @package: PACKAGE_NAME
 * @time: 2021/6/21 21:51
 * @day: 星期一
 */
public class MyTest {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AppInfoService appInfoService = context.getBean("appInfoService", AppInfoService.class);
        AppQueryInfo appQueryInfo = new AppQueryInfo();
        appQueryInfo.setPageIdx(1);
        appQueryInfo.setQueryCategoryLevel1(1L);
    }

    public static void main(String[] args) {

    }
}
