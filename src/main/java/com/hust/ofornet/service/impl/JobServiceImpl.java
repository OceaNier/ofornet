package com.hust.ofornet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.ofornet.mapper.JobMapper;
import com.hust.ofornet.pojo.Category;
import com.hust.ofornet.pojo.Company;
import com.hust.ofornet.pojo.Job;
import com.hust.ofornet.pojo.JobExample;
import com.hust.ofornet.service.CategoryService;
import com.hust.ofornet.service.CompanyService;
import com.hust.ofornet.service.JobService;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	JobMapper jobMapper;
	@Autowired
	CategoryService categoryService;
	@Autowired
	CompanyService companyService;
	
	@Override
	public List<Job> search(String keyword) {
		JobExample example = new JobExample();
		example.createCriteria().andNameLike("%"+keyword+"%");
		example.setOrderByClause("id desc");
		List<Job> result = jobMapper.selectByExample(example);
		setCategory(result);
		setCompany(result);
		return result;
	}
	
	@Override
	public void add(Job p) {
		// TODO Auto-generated method stub
		jobMapper.insert(p);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		jobMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Job p) {
		// TODO Auto-generated method stub
		jobMapper.updateByPrimaryKeySelective(p);
	}

	@Override
	public Job get(int id) {
		// TODO Auto-generated method stub
		Job p = jobMapper.selectByPrimaryKey(id);
		setCategory(p);
		setCompany(p);
		return p;
	}
	
	public void setCategory(List<Job> ps) {
		for (Job p : ps)
			setCategory(p);
	}
	
	public void setCategory(Job p) {
		int cid = p.getCid();
		Category c = categoryService.get(cid);
		p.setCategory(c);	
	}
	
	public void setCompany(List<Job> ps) {
		for (Job p : ps)
			setCompany(p);
	}
	
	public void setCompany(Job p) {
		int coid = p.getCoid();
		Company co = companyService.get(coid);
		p.setCompany(co);	
	}
	
	@Override
	public List listByCategory(int cid) {
		// TODO Auto-generated method stub
		JobExample example = new JobExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        List result = jobMapper.selectByExample(example);
        setCategory(result);
        setCompany(result);
		return result;
	}
	
	@Override
	public List<Job> listByCompany(int coid) {
		// TODO Auto-generated method stub
		JobExample example = new JobExample();
        example.createCriteria().andCoidEqualTo(coid);
        example.setOrderByClause("id desc");
        List<Job> result = jobMapper.selectByExample(example);
        setCategory(result);
        setCompany(result);
		return result;
	}

	@Override
	public List<Job> list() {
		// TODO Auto-generated method stub
		JobExample example = new JobExample();
        example.setOrderByClause("id desc");
        List<Job> result = jobMapper.selectByExample(example);
        setCategory(result);
        setCompany(result);
		return result;
	}

	@Override
	public int getCollectTime(int jobid) {
		Job p = jobMapper.selectByPrimaryKey(jobid);
		if(p!=null) {
			int collectTime = p.getCollecttime();
			return collectTime;
		}
		return 0;
	}

	@Override
		public void fill(List<Category> cs) {
			for (Category c : cs) {
	            fill(c);
	        }
		}

		@Override
		public void fill(Category c) {
			// TODO Auto-generated method stub
			List<Job> jobs = list(c.getId());
	        c.setJobs(jobs);
		}
		
		@Override
		public List<Job> list(int id) {
			// TODO Auto-generated method stub
			JobExample example = new JobExample();
			example.createCriteria().andCidEqualTo(id);
			example.setOrderByClause("id desc");
			List<Job> result = jobMapper.selectByExample(example);
			setCategory(result);
			setCompany(result);
			return result;
		}
		@Override
		public void fillByRow(List<Category> cs) {
			// TODO Auto-generated method stub
			int jobNumberEachRow = 8;
	        for (Category c : cs) {
	            List<Job> jobs =  c.getJobs();
	            List<List<Job>> productsByRow =  new ArrayList<>();
	            for (int i = 0; i < jobs.size(); i+=jobNumberEachRow) {
	                int size = i+jobNumberEachRow;
	                size= size>jobs.size()?jobs.size():size;
	                List<Job> productsOfEachRow =jobs.subList(i, size);
	                productsByRow.add(productsOfEachRow);
	            }
	            c.setJobsByRow(productsByRow);
	        }
		}

}
