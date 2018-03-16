package com.hust.ofornet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.ofornet.mapper.EmploymentMapper;
import com.hust.ofornet.pojo.Company;
import com.hust.ofornet.pojo.Employment;
import com.hust.ofornet.pojo.EmploymentExample;
import com.hust.ofornet.pojo.Job;
import com.hust.ofornet.pojo.Resume;
import com.hust.ofornet.pojo.User;
import com.hust.ofornet.service.JobService;
import com.hust.ofornet.service.CompanyService;
import com.hust.ofornet.service.EmploymentService;
import com.hust.ofornet.service.ResumeService;
import com.hust.ofornet.service.UserService;

@Service
public class EmploymentServiceImpl implements EmploymentService{

	@Autowired
	EmploymentMapper employmentMapper;
	
	@Autowired
	UserService userService;
	
	@Autowired
	JobService jobService;
	
	@Autowired
	ResumeService resumeService;
	
	@Autowired
	CompanyService companyService;
	
	@Override
	public void add(Employment e) {
		employmentMapper.insert(e);
	}

	@Override
	public Employment get(int id) {
		return employmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(int id) {
		employmentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Employment e) {
		employmentMapper.updateByPrimaryKeySelective(e);
	}

	@Override
	public List<Employment> list() {
		EmploymentExample example = new EmploymentExample();
		example.setOrderByClause("id desc");
		List<Employment> result = employmentMapper.selectByExample(example);
		setJob(result);
		setResume(result);
		setUser(result);
		setCompany(result);
		return result;
	}

	@Override
	public List<Employment> listByUser(int uid) {
		EmploymentExample example = new EmploymentExample();
		example.createCriteria().andUidEqualTo(uid);
		List<Employment> result = employmentMapper.selectByExample(example);
		setCompany(result);
		setJob(result);
		setUser(result);
		setResume(result);
		return result;
	}

	@Override
	public List<Employment> listByCompany(int coid) {
		EmploymentExample example = new EmploymentExample();
		example.createCriteria().andCoidEqualTo(coid);
		List<Employment> result = employmentMapper.selectByExample(example);
		setCompany(result);
		setJob(result);
		setUser(result);
		setResume(result);
		return result;
	}
	
	public void setUser(List<Employment> es){
        for (Employment e : es)
            setUser(e);
    }
    public void setUser(Employment e){
        int uid = e.getUid();
        User u = userService.get(uid);
        e.setUser(u);
    }
    
    public void setJob(List<Employment> es){
        for (Employment e : es)
            setJob(e);
    }
    public void setJob(Employment e){
        int jobid = e.getJobid();
        Job c = jobService.get(jobid);
        e.setJob(c);
    }
    
    public void setResume(List<Employment> es){
        for (Employment e : es)
            setResume(e);
    }
    public void setResume(Employment e){
        int rid = e.getRid();
        Resume r = resumeService.get(rid);
        e.setResume(r);
    }
    
    public void setCompany(List<Employment> es) {
    	    for (Employment e : es)
    	    	    setCompany(e);
    }
    public void setCompany(Employment e) {
    	    int coid = e.getCoid();
    	    Company c = companyService.get(coid);
    	    e.setCompany(c);
    }
    
}
