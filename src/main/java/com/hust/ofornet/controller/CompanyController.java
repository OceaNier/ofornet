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
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hust.ofornet.mapper.CompanyMapper;
import com.hust.ofornet.pojo.Company;
import com.hust.ofornet.service.CompanyService;
import com.hust.ofornet.util.ImageUtil;
import com.hust.ofornet.util.Page;
import com.hust.ofornet.util.UploadedImageFile;

@Controller  //声明控制器
@RequestMapping("")  //访问时无需额外地址
public class CompanyController {
	
	@Autowired  //自动装配CompanyServiceImpl进入接口
	CompanyService companyService;
	
	@RequestMapping("admin_company_list")
	public String list(Model model, Page page) {
		PageHelper.offsetPage(page.getStart(), page.getCount());//通过分页插件指定分页参数
		List<Company> cs = companyService.list();//调用list() 获取对应分页的数据
		int total = (int) new PageInfo<>(cs).getTotal();//通过PageInfo获取总数
		page.setTotal(total);
		
		model.addAttribute("cs", cs);
		model.addAttribute("page", page);
		
		return "admin/listCompany";
	}
	
	@RequestMapping("admin_company_add")
	public String add(Company c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
	    System.out.println(c.getId());
	    companyService.add(c);
		System.out.println(c.getId());
	    //通过session获取ControllerContext,再通过getRealPath定位存放分类图片的路径
	    File imageFolder= new File(session.getServletContext().getRealPath("img/company"));
	    if(imageFolder.exists()) {
			System.out.println(imageFolder.getAbsolutePath());
			System.out.println(imageFolder.getName());
		}
	    File file = new File(imageFolder,c.getId()+".jpg");
	    if(!file.getParentFile().exists())
	        file.getParentFile().mkdirs();
	    System.out.println(uploadedImageFile);
	    System.out.println(uploadedImageFile.getImage());
	    System.out.println(file);
	    uploadedImageFile.getImage().transferTo(file);
	    //通过ImageUtil.change2jpg(file); 确保图片格式一定是jpg，而不仅仅是后缀名是jpg.
	    BufferedImage img = ImageUtil.change2jpg(file);
	    ImageIO.write(img, "jpg", file);
	    return "redirect:/admin_company_list";
	}
	
	@RequestMapping("admin_company_delete")
	public String delete(int id,HttpSession session) throws IOException {
        companyService.delete(id);
        File  imageFolder= new File(session.getServletContext().getRealPath("img/company"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
 
        return "redirect:/admin_company_list";
    }
	
	@RequestMapping("admin_company_edit")
    public String edit(int id,Model model) throws IOException {
        Company c= companyService.get(id);
        model.addAttribute("c", c);
        return "admin/editCompany";
    }
	
	@RequestMapping("admin_company_update")
    public String update(Company c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        companyService.update(c);
        MultipartFile image = uploadedImageFile.getImage();
        if(null!=image &&!image.isEmpty()){
            File  imageFolder= new File(session.getServletContext().getRealPath("img/company"));
            File file = new File(imageFolder,c.getId()+".jpg");
            image.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        }
        return "redirect:/admin_company_list";
    }

}
