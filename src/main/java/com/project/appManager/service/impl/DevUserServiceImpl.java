package com.project.appManager.service.impl;

import com.project.appManager.entity.DevUser;
import com.project.appManager.entity.DevUserExample;
import com.project.appManager.mapper.DevUserMapper;
import com.project.appManager.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;

/**
 * @author:MMW
 * @package: com.project.appManager.service.impl
 * @time: 2021/6/21 19:42
 * @day: 星期一
 */
@SuppressWarnings("All")
@Transactional
@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {
    @Autowired
    private DevUserMapper devUserMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(DevUser record) {
        return 0;
    }

    @Override
    public int insertSelective(DevUser record) {
        return 0;
    }

    @Override
    public List<DevUser> selectByExample(DevUserExample example) {
        return devUserMapper.selectByExample(example);
    }

    @Override
    public DevUser selectByPrimaryKey(Long id) {
        return devUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DevUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(DevUser record) {
        return 0;
    }

    /**
     *
     * @param devCode
     * @return Integer
     */
    @Override
    public Integer selectByDevCode(String devCode) {
       return devUserMapper.selectByDevCode(devCode);
    }
    

    @Override
    public DevUser loginCheck(String devCode, String devPassword) {
        DevUserExample devUserExample = new DevUserExample();
        DevUserExample.Criteria criteria = devUserExample.createCriteria();
        criteria.andDevcodeEqualTo(devCode);
        criteria.andDevpasswordEqualTo(devPassword);
        List<DevUser> devUsers = devUserMapper.selectByExample(devUserExample);
        if(devUsers!=null&&devUsers.size()==1){
            return devUsers.get(0);
        }
        return null;
    }
}
