package com.hust.ofornet.service;

import java.util.List;

import com.hust.ofornet.pojo.Collection;

public interface CollectionService {

	void add(Collection c);
    void delete(int id);
    void update(Collection c);

    Collection get(int id);
    
    List<Collection> listByUser(int uid);
 
}
