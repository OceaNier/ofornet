package com.hust.ofornet.mapper;

import com.hust.ofornet.pojo.Resume;
import com.hust.ofornet.pojo.ResumeExample;
import java.util.List;

public interface ResumeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resume record);

    int insertSelective(Resume record);

    List<Resume> selectByExample(ResumeExample example);

    Resume selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKey(Resume record);
}