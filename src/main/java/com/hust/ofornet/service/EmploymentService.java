package com.hust.ofornet.service;

import java.util.List;

import com.hust.ofornet.pojo.Employment;

public interface EmploymentService {

	void add(Employment e);
	void delete(int id);
	void update(Employment e);
	
	Employment get(int id);
	List<Employment> listByUser(int uid);
	List<Employment> listByCompany(int coid);
	List<Employment> list();
	
//	String waitComfirm = "waitConfirm";
//	String waitTest = "waitTest";
//	String waitInerview = "waitInerview";
//	String employed = "employed";
//	String rejected = "rejected";
}
