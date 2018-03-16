package com.hust.ofornet.service;

import java.util.List;

import com.hust.ofornet.pojo.Category;
import com.hust.ofornet.pojo.Job;

public interface JobService {
	
	void add(Job p);
    void delete(int id);
    void update(Job p);

    Job get(int id);
    
    List<Job> listByCategory(int cid);
    List<Job> listByCompany(int coid);
    
    List<Job> list();
    
    public List<Job> search(String keyword);
    
    public int getCollectTime(int jobid);
    
    List<Job> list(int id);
    
    void fill(List<Category> cs);

    void fill(Category c);

    void fillByRow(List<Category> cs);
    
}
