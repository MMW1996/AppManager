package com.project.appManager.service.impl;

import com.project.appManager.entity.DataDictionary;
import com.project.appManager.entity.DataDictionaryExample;
import com.project.appManager.mapper.DataDictionaryMapper;
import com.project.appManager.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author:MMW
 * @package: com.project.appManager.service.impl
 * @time: 2021/6/22 14:29
 * @day: 星期二
 */
@SuppressWarnings("All")
@Service
@Transactional
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(DataDictionary record) {
        return 0;
    }

    @Override
    public int insertSelective(DataDictionary record) {
        return 0;
    }

    @Override
    public List<DataDictionary> selectByExample(DataDictionaryExample example) {
        return null;
    }

    @Override
    public DataDictionary selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(DataDictionary record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(DataDictionary record) {
        return 0;
    }

    @Override
    public List<DataDictionary> getDataDictionaryInfo(String typeName) {
        DataDictionaryExample dataDictionaryExample = new DataDictionaryExample();
        DataDictionaryExample.Criteria criteria = dataDictionaryExample.createCriteria();
        criteria.andTypenameEqualTo(typeName);
        return dataDictionaryMapper.selectByExample(dataDictionaryExample);
    }


}
