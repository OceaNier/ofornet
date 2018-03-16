package com.hust.ofornet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hust.ofornet.service.CategoryService;
import com.hust.ofornet.service.CollectionService;
import com.hust.ofornet.service.EmploymentService;
import com.hust.ofornet.service.JobService;
import com.hust.ofornet.service.UserService;

@Controller
@RequestMapping
public class CollectionController {

	@Autowired
	JobService jobService;
	@Autowired
	UserService userService;
	@Autowired
	CollectionService collectionService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	EmploymentService employmentService;
	
	@RequestMapping("deleteCollection")
	public String deleteCollection(Model model ,int cid) {
		collectionService.delete(cid);
		return "redirect:userCollection";
	}
}
