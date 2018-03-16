package com.hust.ofornet.mapper;

import com.hust.ofornet.pojo.Information;
import com.hust.ofornet.pojo.InformationExample;
import java.util.List;

public interface InformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Information record);

    int insertSelective(Information record);

    List<Information> selectByExample(InformationExample example);

    Information selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
}