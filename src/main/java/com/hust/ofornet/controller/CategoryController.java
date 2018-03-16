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
import com.hust.ofornet.pojo.Category;
import com.hust.ofornet.service.CategoryService;
import com.hust.ofornet.util.ImageUtil;
import com.hust.ofornet.util.Page;
import com.hust.ofornet.util.UploadedImageFile;

@Controller
@RequestMapping("")
public class CategoryController {
	
	@Autowired  //自动装配CompanyServiceImpl进入接口
	CategoryService categoryService;
	
	@RequestMapping("admin_category_list")
    public String list(Model model,Page page){
		
		PageHelper.offsetPage(page.getStart(), page.getCount());//通过分页插件指定分页参数
		List<Category> cs = categoryService.list();//调用list() 获取对应分页的数据
		int total = (int) new PageInfo<>(cs).getTotal();//通过PageInfo获取总数
		page.setTotal(total);
		
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }
 
    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session) throws IOException {
        categoryService.add(c);
        return "redirect:/admin_category_list";
    }
 
    @RequestMapping("admin_category_delete")
    public String delete(int id,HttpSession session) throws IOException {
        categoryService.delete(id);
        return "redirect:/admin_category_list";
    }
 
    @RequestMapping("admin_category_edit")
    public String edit(int id,Model model) throws IOException {
        Category c= categoryService.get(id);
        model.addAttribute("c", c);
        return "admin/editCategory";
    }
 
    @RequestMapping("admin_category_update")
    public String update(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        categoryService.update(c);
        return "redirect:/admin_category_list";
    }

	
}
