package com.hust.ofornet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.ofornet.mapper.CompanyMapper;
import com.hust.ofornet.pojo.Company;
import com.hust.ofornet.pojo.CompanyExample;
import com.hust.ofornet.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyMapper companyMapper;
	
	@Override
	public List<Company> list() {
		CompanyExample example =new CompanyExample();
        example.setOrderByClause("id desc");
        return companyMapper.selectByExample(example);
	}
	
	@Override
	public void add(Company company) {
		companyMapper.insert(company);
	}
	
	@Override
	public void delete(int id) {
		companyMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public Company get(int id) {
		return companyMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public void update(Company company) {
		companyMapper.updateByPrimaryKeySelective(company);
	}
	
	@Override
	 public boolean isExist(String username) {
	  CompanyExample example = new CompanyExample();
	  example.createCriteria().andUsernameEqualTo(username);
	  List<Company> result = companyMapper.selectByExample(example);
	  if(!result.isEmpty())
	   return true;
	  return false;
	 }

	 @Override
	 public Company get(String username, String password) {
	  CompanyExample example = new CompanyExample();
	  example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
	        List<Company> result= companyMapper.selectByExample(example);
	        if(result.isEmpty())
	            return null;
	        return result.get(0);
	 }
	 
}
