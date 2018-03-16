package com.hust.ofornet.mapper;

import com.hust.ofornet.pojo.Jobimage;
import com.hust.ofornet.pojo.JobimageExample;
import java.util.List;

public interface JobimageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jobimage record);

    int insertSelective(Jobimage record);

    List<Jobimage> selectByExample(JobimageExample example);

    Jobimage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jobimage record);

    int updateByPrimaryKey(Jobimage record);
}