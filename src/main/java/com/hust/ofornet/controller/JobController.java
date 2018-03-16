package com.hust.ofornet.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hust.ofornet.pojo.Category;
import com.hust.ofornet.pojo.Company;
import com.hust.ofornet.pojo.Job;
import com.hust.ofornet.service.CategoryService;
import com.hust.ofornet.service.CompanyService;
import com.hust.ofornet.service.JobService;
import com.hust.ofornet.util.Page;

@Controller
@RequestMapping("")
public class JobController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	CompanyService companyService;
	@Autowired
	JobService jobService;
	
	@RequestMapping("createJob")
    public String add(Model model, Job p, HttpSession session) {
		Company c = (Company)session.getAttribute("user");
        p.setCreateDate(new Date());
        p.setCollecttime(0);
        jobService.add(p);
        return "redirect:job_listByCompany?coid="+c.getId();
    }
 
    @RequestMapping("job_delete")
    public String delete(Model model, int id, HttpSession session) {
        jobService.delete(id);
//        return "redirect:admin_job_list?cid="+p.getCid();
        Company c = (Company)session.getAttribute("user");
        return "redirect:job_listByCompany?coid="+c.getId();
    }
 
    @RequestMapping("admin_job_edit")
    public String edit(Model model, int id) {
        Job p = jobService.get(id);
        Category c = categoryService.get(p.getCid());
        p.setCategory(c);
        model.addAttribute("p", p);
        return "admin/editJob";
    }
 
    @RequestMapping("admin_job_update")
    public String update(Job p) {
        jobService.update(p);
        return "redirect:admin_job_list?";
    }
 
    @RequestMapping("job_listByCompany")
    public String listByCompany(HttpSession session, Model model, Page page) {
    	    Company c = (Company)session.getAttribute("user");
        int coid = c.getId();
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Job> cs = jobService.listByCompany(coid);
 
        int total = (int) new PageInfo<>(cs).getTotal();
        page.setTotal(total);
        page.setParam("&coid="+c.getId());
 
        model.addAttribute("cs", cs);
        model.addAttribute("c", c);
        model.addAttribute("page", page);
        
        return "fore/companyCenterJob";
    }
    
    @RequestMapping("admin_job_list")
    public String list(Model model, Page page) {
 
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Job> ps = jobService.list();
        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        model.addAttribute("ps", ps);
        model.addAttribute("page", page);
 
        return "admin/listJob";
    }
	
}
