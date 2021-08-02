package com.project.appManager.service;

import com.project.appManager.entity.DataDictionary;
import com.project.appManager.entity.DataDictionaryExample;

import java.util.List;

/**
 * @author:MMW
 * @package: com.project.appManager.service
 * @time: 2021/6/22 14:28
 * @day: 星期二
 */
public interface DataDictionaryService {

    int deleteByPrimaryKey(Long id);

    int insert(DataDictionary record);

    int insertSelective(DataDictionary record);

    List<DataDictionary> selectByExample(DataDictionaryExample example);

    DataDictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataDictionary record);

    int updateByPrimaryKey(DataDictionary record);

    List<DataDictionary> getDataDictionaryInfo(String typeName);
}
