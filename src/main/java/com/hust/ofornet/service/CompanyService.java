package com.hust.ofornet.service;

import java.util.List;

import com.hust.ofornet.pojo.Company;

public interface CompanyService {
	
	List<Company> list();

	void add(Company company);
	void delete(int id);
	
	Company get(int id);
	void update(Company company);
	
	boolean isExist(String username);

    Company get(String username, String password);
}
