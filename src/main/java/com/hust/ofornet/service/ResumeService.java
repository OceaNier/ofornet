package com.hust.ofornet.service;

import java.util.List;

import com.hust.ofornet.pojo.Resume;

public  interface ResumeService {
	
	void add(Resume c);
	void delete(int id);
	void update(Resume c);
	
	Resume get(int id);
	
	List<Resume> list();
	List<Resume> listByUser(int uid);
}
