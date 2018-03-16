package com.hust.ofornet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.ofornet.mapper.CollectionMapper;
import com.hust.ofornet.pojo.Collection;
import com.hust.ofornet.pojo.CollectionExample;
import com.hust.ofornet.pojo.Job;
import com.hust.ofornet.service.CollectionService;
import com.hust.ofornet.service.JobService;
@Service
public class CollectionServiceImpl implements CollectionService{

	@Autowired
	CollectionMapper collectionMapper;
	@Autowired
	JobService jobService;
	@Override
	public void add(Collection c) {
	    collectionMapper.insert(c);
	}

	@Override
	public void delete(int id) {
		collectionMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void update(Collection c) {
		collectionMapper.updateByPrimaryKeySelective(c);
	}

	@Override
	public Collection get(int id) {
		
		return collectionMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Collection> listByUser(int uid) {//通过用户id显示收藏项
		CollectionExample example = new CollectionExample();
		example.createCriteria().andUidEqualTo(uid);//条件查询，满足用户id为uid
		List<Collection> result = collectionMapper.selectByExample(example);
		setJob(result);
		return result;
	}
	
	void setJob(Collection c) {//为收藏项设置非数据库字段变量Job的值
		Job job = jobService.get(c.getJobid());
		c.setJob(job);
	}
	void setJob(List<Collection> cs) {//为查询结果统一设置Job
		for(Collection c : cs)
			setJob(c);
	}

}
