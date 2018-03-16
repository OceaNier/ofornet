package com.hust.ofornet.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hust.ofornet.pojo.Job;
import com.hust.ofornet.pojo.User;
import com.hust.ofornet.service.UserService;
import com.hust.ofornet.util.Page;

@Controller
@RequestMapping("")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("admin_user_add")
	public String add(Model model, User c) {
        userService.add(c);
        return "redirect:admin_user_list?";
	}
	
	@RequestMapping("fore_regist_user")
	public String register_user(Model model, User user) {
		String username =  user.getUsername();
		System.out.println(username);
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        boolean exist = userService.isExist(username);
        
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
            return "fore/register";
        }
        userService.add(user);
        System.out.println("okok");

        return "fore/registerSuccess";
	}
	
	@RequestMapping("admin_user_delete")
    public String delete(int id) {
        userService.delete(id);
//        return "redirect:admin_job_list?cid="+p.getCid();
        return "redirect:admin_user_list";
    }
	
	@RequestMapping("admin_user_list")
    public String list(Model model, Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
 
        List<User> us= userService.list();
 
        int total = (int) new PageInfo<>(us).getTotal();
        page.setTotal(total);
 
        model.addAttribute("us", us);
        model.addAttribute("page", page);
 
        return "admin/listUser";
    }
}
