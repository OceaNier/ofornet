package com.hust.ofornet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.ofornet.mapper.ResumeMapper;
import com.hust.ofornet.pojo.Employment;
import com.hust.ofornet.pojo.EmploymentExample;
import com.hust.ofornet.pojo.Resume;
import com.hust.ofornet.pojo.ResumeExample;
import com.hust.ofornet.pojo.User;
import com.hust.ofornet.service.ResumeService;
import com.hust.ofornet.service.UserService;


@Service
public class ResumeServiceImpl implements ResumeService{

	@Autowired
	ResumeMapper resumeMapper;
	@Autowired
	UserService userService;
	
	@Override
	public void add(Resume c) {
		// TODO Auto-generated method stub
		resumeMapper.insert(c);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		resumeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Resume c) {
		// TODO Auto-generated method stub
		resumeMapper.updateByPrimaryKeySelective(c);
	}

	@Override
	public Resume get(int id) {
		// TODO Auto-generated method stub
		return resumeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Resume> list() {
		ResumeExample example = new ResumeExample();
		example.setOrderByClause("id desc");
		List<Resume> result = resumeMapper.selectByExample(example);
		setUser(result);
		return result;
	}

	@Override
	public List<Resume> listByUser(int uid) {
		ResumeExample example = new ResumeExample();
		example.createCriteria().andUidEqualTo(uid);
		List<Resume> result = resumeMapper.selectByExample(example);
		setUser(result);
		return result;
	}
	
	public void setUser(List<Resume> cs) {
		for(Resume c : cs)
			setUser(c);
	}
	
	public void setUser(Resume c) {
		int uid = c.getUid();
		User user = userService.get(uid);
		c.setUser(user);
	}

}
