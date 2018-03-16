package com.hust.ofornet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hust.ofornet.dto.JobDto;
import com.hust.ofornet.pojo.Category;
import com.hust.ofornet.pojo.Collection;
import com.hust.ofornet.pojo.Company;
import com.hust.ofornet.pojo.Employment;
import com.hust.ofornet.pojo.Job;
import com.hust.ofornet.pojo.Resume;
import com.hust.ofornet.pojo.User;
import com.hust.ofornet.service.CategoryService;
import com.hust.ofornet.service.CollectionService;
import com.hust.ofornet.service.CompanyService;
import com.hust.ofornet.service.EmploymentService;
import com.hust.ofornet.service.JobService;
import com.hust.ofornet.service.ResumeService;
import com.hust.ofornet.service.UserService;
import com.hust.ofornet.util.Page;
import com.hust.ofornet.util.SearchHelper;

@Controller
@RequestMapping("")
public class ForeController {
	
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
	@Autowired
	ResumeService resumeService;
	@Autowired
	CompanyService companyService;
	
	@RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();
        jobService.fill(cs);
        jobService.fillByRow(cs);
        System.out.println(cs);
        model.addAttribute("cs", cs);
        return "fore/home";
    }
	
	@RequestMapping("foresearch")
    public String search( String keyword,Model model,Page page){
        /*PageHelper.offsetPage(0,20);*/
//		page.setCount(8);
//		PageHelper.offsetPage(page.getStart(), page.getCount());
//        List<Job> job= jobService.search(keyword);
//        int total = (int) new PageInfo<>(job).getTotal();//通过PageInfo获取总数
//		page.setTotal(total);
//        //jobService.setSaleAndReviewNumber(ps);
//        System.out.println(job);
//        model.addAttribute("page",page);
//        model.addAttribute("ps",job);
//        model.addAttribute("keywords", keyword);
//        return "fore/searchResult";
		page.setCount(4);
        List<Job> jobs= jobService.list();
        try {
        SearchHelper.createIndex(jobs);
            } catch (Exception e) {
   // TODO Auto-generated catch block
            e.printStackTrace();
           }
        List<JobDto> jobDtos = SearchHelper.doSearch(keyword, page);
        
        model.addAttribute("page",page);
        model.addAttribute("ps",jobDtos);
        System.out.println(keyword);
        model.addAttribute("keywords", keyword);
        return "fore/searchResult";
    }
	
	@RequestMapping("forejob")
	public String Job(int jobid, Model model) {
		
		Job p = jobService.get(jobid);
        model.addAttribute("p", p);
        return "fore/product";
	}
	
	@RequestMapping("foreapply")
	public String apply(Model model, HttpSession session, int jobid){
		User user = (User)session.getAttribute("user");
		int uid = user.getId();
	    List<Resume> rs = resumeService.listByUser(uid);
	    Job job = jobService.get(jobid);
	    int coid = job.getCoid();
	    model.addAttribute("rs", rs);
	    model.addAttribute("jobid", jobid);
	    model.addAttribute("uid", uid);
	    model.addAttribute("coid", coid);
	    
		return "fore/selectResume";
	}
	
	@RequestMapping("forecollect")
	public String forecollect(Model model, HttpSession session, int jobid) {
		Job job = jobService.get(jobid);
		User user = (User)session.getAttribute("user");
		boolean found = false;
		List<Collection> cs = collectionService.listByUser(user.getId());
		for(Collection c : cs) {
			if(c.getJobid()==jobid)
				found = true;
		}
		if(!found) {
			Collection c = new Collection();
			c.setJobid(jobid);
			c.setUid(user.getId());
			collectionService.add(c);
			int collecttime = job.getCollecttime();
			collecttime++;
			job.setCollecttime(collecttime);
			jobService.update(job);
		}
		System.out.println("okokok");
		return "redirect:foreuserCollection";
	}
	
	@RequestMapping("foreCreateResume")
	public String createResume(Model model, HttpSession session) {
		User user = (User)session.getAttribute("user");
		model.addAttribute("user", user);
		return "fore/userCenterNewResume";
	}
	
	@RequestMapping("foreuserCollection")
	public String userCollection(Model model, HttpSession session, Page page){
		page.setCount(4);
		PageHelper.offsetPage(page.getStart(), page.getCount());
		User user = (User)session.getAttribute("user");
		int uid = user.getId();
		List<Collection> cs = collectionService.listByUser(uid);
		
		int total = (int) new PageInfo<>(cs).getTotal();//通过PageInfo获取总数
		page.setTotal(total);
        model.addAttribute("page",page);
        model.addAttribute("cs",cs);
		return "fore/userCenterCollection";
	}
	
	@RequestMapping("forelogin")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        if(username.equals("admin")&&password.equals("admin")) {
             return "redirect:admin_category_list";
        }
        username = HtmlUtils.htmlEscape(username);
        User user = userService.get(username,password);

        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        else {
         session.setAttribute("usertype", "u");
           session.setAttribute("user", user);
           return "redirect:forehome";
        }
    }
    
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
     if(session.getAttribute("usertype")=="u") {
            User user =(User)  session.getAttribute("user");
            if(null!=user)
            return "success";
            return "fail";
     }
     else {
      Company user  =(Company)  session.getAttribute("company");
            if(null!=user)
            return "success";
            return "fail";
     }

    }
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("username") String username, @RequestParam("password") String password,HttpSession session) {
        if(session.getAttribute("usertype")=="u") {
         username = HtmlUtils.htmlEscape(username);
            User user = userService.get(username,password);

            if(null==user){
                return "fail";
            }
            session.setAttribute("user", user);
            return "success"; 
        }
        else {
         username = HtmlUtils.htmlEscape(username);
            Company user = companyService.get(username,password);

            if(null==user){
                return "fail";
            }
            session.setAttribute("user", user);
            return "success"; 
        }

    }
    
    @RequestMapping("foreloginCompany")
    public String loginCompany(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        if(username.equals("admin")&&password.equals("admin")) {
             return "redirect:admin_category_list";
        }
        username = HtmlUtils.htmlEscape(username);
        Company user = companyService.get(username,password);

        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            
            return "fore/loginCompany";
        }
        else {
           session.setAttribute("usertype", "c");
           session.setAttribute("user",user);
           return "redirect:forehome";
        }
    }
    
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
     if(session.getAttribute("usertype")=="u") {
         session.removeAttribute("user");
         session.removeAttribute("usertype");
            return "redirect:loginPage";
     }
     else if(session.getAttribute("usertype")=="c"){
      session.removeAttribute("usertype");
         session.removeAttribute("user");
            return "redirect:loginPageCompany";
     }
     else {return "redirect:loginPage";}
    }
    
    
}
