package com.project.appManager.service.impl;

import com.project.appManager.entity.BackendUser;
import com.project.appManager.entity.BackendUserExample;
import com.project.appManager.mapper.BackendUserMapper;
import com.project.appManager.service.BackendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:MMW
 * @package: com.project.appManager.service.impl
 * @time: 2021/6/22 16:11
 * @day: 星期二
 */
@SuppressWarnings("All")
@Service
@Transactional
public class BackendUserServiceImpl implements BackendUserService {

    @Autowired
    private BackendUserMapper backendUserMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(BackendUser record) {
        return 0;
    }

    @Override
    public int insertSelective(BackendUser record) {
        return 0;
    }

    @Override
    public List<BackendUser> selectByExample(BackendUserExample example) {
        return null;
    }

    @Override
    public BackendUser selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BackendUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(BackendUser record) {
        return 0;
    }

    @Override
    public BackendUser backendLogin(String userCode, String userPassword) {
        BackendUserExample backendUserExample = new BackendUserExample();
        BackendUserExample.Criteria criteria = backendUserExample.createCriteria();
        criteria.andUsercodeEqualTo(userCode);
        criteria.andUserpasswordEqualTo(userPassword);
        List<BackendUser> backendUsers = backendUserMapper.selectByExample(backendUserExample);
        if(backendUsers!=null&&backendUsers.size()==1){
            return backendUsers.get(0);
        }else {
            return null;
        }
    }
}
