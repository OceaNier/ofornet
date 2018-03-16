package com.hust.ofornet.mapper;

import com.hust.ofornet.pojo.Employment;
import com.hust.ofornet.pojo.EmploymentExample;
import java.util.List;

public interface EmploymentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employment record);

    int insertSelective(Employment record);

    List<Employment> selectByExample(EmploymentExample example);

    Employment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employment record);

    int updateByPrimaryKey(Employment record);
}