package com.hust.ofornet.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import com.hust.ofornet.pojo.Resume;
import com.hust.ofornet.pojo.User;
import com.hust.ofornet.service.ResumeService;
import com.hust.ofornet.service.UserService;
import com.hust.ofornet.util.ImageUtil;
import com.hust.ofornet.util.Page;
import com.hust.ofornet.util.UploadedImageFile;

@Controller
@RequestMapping
public class ResumeController {

	@Autowired
	ResumeService resumeService;
	@Autowired
	UserService userService;
	
	@RequestMapping("asdad")
	public String add(Model model, Resume c) {
		resumeService.add(c);
		return "redirect:qewqe";
	}
	
	@RequestMapping("admin_resume_delete")
    public String delete(int id) {
        Resume c = resumeService.get(id);
        resumeService.delete(id);
//        return "redirect:admin_job_list?cid="+p.getCid();
        return "redirect:aewrea";
    }
 
    @RequestMapping("admin_resume_edit")
    public String edit(Model model, int id) {
        Resume c = resumeService.get(id);
        User p = userService.get(c.getUid());
        c.setUser(p);
        model.addAttribute("c", c);
        return "admin/editResume";
    }
 
    @RequestMapping("admin_resume_update")
    public String update(Resume p) {
        resumeService.update(p);
        return "redirect:admin_resume_list?";
    }
    
    @RequestMapping("createResume")
    public String createResume(Resume r, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
      	System.out.println(r.getId());
	    resumeService.add(r);
	    //通过session获取ControllerContext,再通过getRealPath定位存放分类图片的路径
	    File imageFolder= new File(session.getServletContext().getRealPath("img/resume"));
	    if(imageFolder.exists()) {
			System.out.println(imageFolder.getAbsolutePath());
			System.out.println(imageFolder.getName());
		}
	    File file = new File(imageFolder,r.getId()+".jpg");
	    if(!file.getParentFile().exists())
	        file.getParentFile().mkdirs();
	    System.out.println(uploadedImageFile);
	    System.out.println(uploadedImageFile.getImage());
	    System.out.println(file);
	    uploadedImageFile.getImage().transferTo(file);
	    //通过ImageUtil.change2jpg(file); 确保图片格式一定是jpg，而不仅仅是后缀名是jpg.
	    BufferedImage img = ImageUtil.change2jpg(file);
	    ImageIO.write(img, "jpg", file);
    	    return "redirect:/myresume";
    }
 
    
    @RequestMapping("admin_resume_list")
    public String list(Model model, Page page) {
 
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Resume> ps = resumeService.list();
        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        model.addAttribute("ps", ps);
        model.addAttribute("page", page);
 
        return "admin/listResume";
    }
}
