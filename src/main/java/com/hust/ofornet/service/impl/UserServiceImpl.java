package com.hust.ofornet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.ofornet.mapper.UserMapper;
import com.hust.ofornet.pojo.User;
import com.hust.ofornet.pojo.UserExample;
import com.hust.ofornet.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public void add(User c) {
		// TODO Auto-generated method stub
		userMapper.insert(c);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(User c) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKeySelective(c);
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		example.setOrderByClause("id desc");
		return userMapper.selectByExample(example);
	}

	@Override
	public boolean isExist(String username) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<User> result = userMapper.selectByExample(example);
		if(!result.isEmpty())
			return true;
		return false;
	}

	@Override
	public User get(String username, String password) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> result= userMapper.selectByExample(example);
        if(result.isEmpty())
            return null;
        return result.get(0);
	}

	
}
