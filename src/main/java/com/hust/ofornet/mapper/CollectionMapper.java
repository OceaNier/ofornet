package com.hust.ofornet.mapper;

import com.hust.ofornet.pojo.Collection;
import com.hust.ofornet.pojo.CollectionExample;
import java.util.List;

public interface CollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collection record);

    int insertSelective(Collection record);

    List<Collection> selectByExample(CollectionExample example);

    Collection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);
}