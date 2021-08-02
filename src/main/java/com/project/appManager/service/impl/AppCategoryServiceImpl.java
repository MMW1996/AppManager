package com.project.appManager.service.impl;

import com.project.appManager.entity.AppCategory;
import com.project.appManager.entity.AppCategoryExample;
import com.project.appManager.mapper.AppCategoryMapper;
import com.project.appManager.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author:MMW
 * @package: com.project.appManager.service.impl
 * @time: 2021/6/22 19:12
 * @day: 星期二
 */
@SuppressWarnings("All")
@Service("appCategoryService")
@Transactional
public class AppCategoryServiceImpl implements AppCategoryService {
    @Autowired
    private AppCategoryMapper appCategoryMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(AppCategory record) {
        return 0;
    }

    @Override
    public int insertSelective(AppCategory record) {
        return 0;
    }

    @Override
    public List<AppCategory> selectByExample(AppCategoryExample example) {
        return null;
    }

    @Override
    public AppCategory selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(AppCategory record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(AppCategory record) {
        return 0;
    }

    /**
     * 获取所有一级分类
     * @return
     */
    @Override
    public List<AppCategory> getCategoryLevelOne() {
        return appCategoryMapper.getCategoryLevelOne();
    }

    /**
     * 获取所有二级分类
     * @return
     */
    @Override
    public List<AppCategory> getCategoryLevelTwo() {
        return appCategoryMapper.getCategoryLevelTwo();
    }

    /**
     * 根据id获取二级分类
     * @param id
     * @return
     */
    @Override
    public List<AppCategory> getCategoryLevelTwoById(Long id) {
        Long parentId = appCategoryMapper.selectByPrimaryKey(id).getParentid();
        return appCategoryMapper.getLevelsByParentid(parentId);
    }
    /**
     * 获取所有三级分类
     * @return
     */
    @Override
    public List<AppCategory> getCategoryLevelThree() {
        return appCategoryMapper.getCategoryLevelThree();
    }

    @Override
    public List<AppCategory> getCategoryLevelThreeById(Long id) {
        Long parentId = appCategoryMapper.selectByPrimaryKey(id).getParentid();
        return appCategoryMapper.getLevelsByParentid(parentId);
    }


    /**
     * level1 对应 level2 level3 对应分类信息
     * @param id
     * @return
     */
    @Override
    public HashMap< String, Object > levleOneChangeInfo(Long id) {
        HashMap<String,Object> map = new HashMap<>();
        List<AppCategory> levelsTwo = appCategoryMapper.getLevelsByParentid(id);
        map.put("levelsTwo",levelsTwo);
        ArrayList<Long> list = new ArrayList<>();
        for(AppCategory appCategory:levelsTwo){
            list.add(appCategory.getId());
        }
        AppCategoryExample example = new AppCategoryExample();
        example.createCriteria().andParentidIn(list);
        List<AppCategory> levelsThree = appCategoryMapper.selectByExample(example);
        map.put("levelsThree",levelsThree);
        return map;
    }

    /**
     * level2 对应 level1 和 level3 信息
     * @param id
     * @return
     */
    @Override
    public HashMap<String,Object> levleTwoChangeInfo(Long id) {
        HashMap<String,Object> map = new HashMap<>();
        // 查询当前levelTwo 获取 parentId
        AppCategory levelTwo = appCategoryMapper.selectByPrimaryKey(id);
        map.put("levelTwo",levelTwo);
        // 查level3  level2 对应多个level3
        List<AppCategory> levelsThree = appCategoryMapper.getLevelsByParentid(id);
        map.put("levelsThree",levelsThree);
        return map;
    }

    /**
     * level3 对应 level 和 level2信息
     * @param id
     * @return
     */
    @Override
    public HashMap<String, Object> levleThreehangeInfo(Long id) {
        HashMap<String,Object> map = new HashMap<>();
        // 查询当前levelThree 获取parentid
        AppCategory levelThree = appCategoryMapper.selectByPrimaryKey(id);
        map.put("levelThree",levelThree);
        // 根据 parentid查 level2 的parentid
        AppCategory levelOne = appCategoryMapper.selectByPrimaryKey(appCategoryMapper.getLevelsById(levelThree.getParentid()).get(0).getParentid());
        map.put("levelOne",levelOne);
        return map;
    }


}
