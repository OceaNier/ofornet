package com.hust.ofornet.mapper;

import com.hust.ofornet.pojo.Job;
import com.hust.ofornet.pojo.JobExample;
import java.util.List;

public interface JobMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Job record);

    int insertSelective(Job record);

    List<Job> selectByExample(JobExample example);

    Job selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}