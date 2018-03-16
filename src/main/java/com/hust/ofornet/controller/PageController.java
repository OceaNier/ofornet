package com.hust.ofornet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hust.ofornet.pojo.Category;
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

@Controller
@RequestMapping("")
public class PageController {
	
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
	
    @RequestMapping("registerPageUser")
    public String registerPage() {
        return "fore/register";
    }
    @RequestMapping("registerSuccessPage")
    public String registerSuccessPage() {
        return "fore/registerSuccess";
    }
    @RequestMapping("loginPage")
    public String loginPage() {
        return "fore/login";
    }
    @RequestMapping("edituser")
    public String edituser(Model model, HttpSession session) {
    	    User u = (User)session.getAttribute("user");
    	    model.addAttribute("u", u);
        return "fore/userCenterEdit";
    }
    
    @RequestMapping("createJob_edit")
    public String createJob(Model model, HttpSession session) {
    	    List<Category> cs = categoryService.list();
    	    model.addAttribute("cs", cs);
        return "fore/companyCenterNewJob";
    }
    
    @RequestMapping("myresume")
    public String myresume(Model model, HttpSession session, Page page) {
    	    page.setCount(4);
    	    PageHelper.offsetPage(page.getStart(), page.getCount());
    	    User user = (User)session.getAttribute("user");
    	    int uid = user.getId();
    	    List<Resume> rs = resumeService.listByUser(uid);
    	    int total = (int)new PageInfo<>(rs).getTotal();
    	    page.setTotal(total);
    	    model.addAttribute("page",page);
    	    model.addAttribute("rs", rs);
    	    return "fore/userCenterResume";
    }
    
    @RequestMapping("resumeview")
    public String resumeview(Model model, HttpSession session, int rid) {
    	    Resume r = resumeService.get(rid);
    	    model.addAttribute("r", r);
    	    return "fore/resumeView";
    }
    
    @RequestMapping("myemployment")
    public String myemployment(Model model, HttpSession session, Page page) {
    	    page.setCount(4);
		PageHelper.offsetPage(page.getStart(), page.getCount());
    	    User user = (User)session.getAttribute("user");
    	    int uid = user.getId();
    	    List<Employment> es = employmentService.listByUser(uid);
    	    
    	    int total = (int) new PageInfo<>(es).getTotal();//通过PageInfo获取总数
    		page.setTotal(total);
        model.addAttribute("page",page);
            
    	    model.addAttribute("es",es);
    	    return "fore/userCenterEmployment";
    }
    
    @RequestMapping("loginPageCompany")
    public String loginPageCompany(){
     return "fore/loginCompany";
    }
  
}


