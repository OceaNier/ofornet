package com.hust.ofornet.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hust.ofornet.pojo.Company;
import com.hust.ofornet.pojo.Employment;
import com.hust.ofornet.pojo.Job;
import com.hust.ofornet.pojo.User;
import com.hust.ofornet.service.CompanyService;
import com.hust.ofornet.service.EmploymentService;
import com.hust.ofornet.service.JobService;
import com.hust.ofornet.service.UserService;
import com.hust.ofornet.util.Page;

@Controller
@RequestMapping("")
public class EmploymentController {

	@Autowired
	EmploymentService employmentService;
	@Autowired
	UserService userService;
	@Autowired
	CompanyService companyService;
	@Autowired
	JobService jobService;
	
	@RequestMapping("Employment_list")
	public String listEmployment(Model model, Page page) {
		
		PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Employment> es = employmentService.list();
 
        int total = (int) new PageInfo<>(es).getTotal();
        page.setTotal(total);
 
        model.addAttribute("es", es);
        model.addAttribute("page", page);
 
        return "admin/listEmployment";
	}
	
	@RequestMapping("Employment_listByUser")
	public String listByUser(int uid, Model model, Page page) {
		User u = userService.get(uid);
		
		PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Employment> ps = employmentService.listByUser(uid);
 
        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        page.setParam("&uid="+u.getId());
 
        model.addAttribute("ps", ps);
        model.addAttribute("u", u);
        model.addAttribute("page", page);
 
        return "admin/listEmploymentByUser";
	}
	
	@RequestMapping("Employment_listByCompany")
	public String listByCompany(HttpSession session, Model model, Page page) {
		Company co = (Company)session.getAttribute("user");
		PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Employment> es = employmentService.listByCompany(co.getId());
 
        int total = (int) new PageInfo<>(es).getTotal();
        page.setTotal(total);
        page.setParam("&coid="+co.getId());
 
        model.addAttribute("es", es);
        model.addAttribute("co", co);
        model.addAttribute("page", page);
 
        return "fore/companyCenterEmployment";
	}
	
	@RequestMapping("Employment_updateStatus")
	public String updateStatus(Model model, int eid, String status) throws IOException{
		Employment e = employmentService.get(eid);
		e.setEmployStatus(status);
		employmentService.update(e);
		return "redirect:Employment_listByCompany?coid="+e.getCoid();
	}
	
	@RequestMapping("createEmployment")
	public String genarateEmployment(int jobid, int rid, Model model, HttpSession session) {
		Job job = jobService.get(jobid);
		User user = (User)session.getAttribute("user");
		Employment e = new Employment();
		e.setCoid(job.getCoid());
		e.setUid(user.getId());
		e.setJobid(jobid);
		e.setRid(rid);
		e.setCreateDate(new Date());
		e.setEmployStatus("简历已投递");
		
		List<Employment> es = employmentService.listByUser(user.getId());
		for(Employment p : es) {
			if(jobid == p.getJobid())
				return "redirect:myemployment";
		}
		
 		employmentService.add(e);
		return "redirect:myemployment";
	}
	
	@RequestMapping("deleteEmployment")
	public String deleteEmployment(Model model, int eid){
		employmentService.delete(eid);
		return "redirect:myemployment";
	}
	
}
