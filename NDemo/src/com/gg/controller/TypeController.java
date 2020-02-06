package com.gg.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gg.pojo.Type;
import com.gg.service.TypeServiceImpl;
import com.gg.util.Page;

@Controller
@RequestMapping("/View/manager/News")
public class TypeController {
	@Autowired
	private TypeServiceImpl typeService;
	
	@RequestMapping("/getTypeByPage")
	public String getTypeByPage(Integer curPage,HttpSession session) {
		if(curPage == null || curPage <= 0)
			curPage = 1;
		Page<Type> page = typeService.getTypeByPage(curPage);
		session.setAttribute("TypePage", page);
		session.setAttribute("TotalPage", page.getTotalPage());
		return "forward:CategoryList.jsp";
	}
	
	@RequestMapping("/addOrUpdate")
	public void addOrUpdate(Type type,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		if(type.getT_id() >= 1) {
			int result = typeService.updateType(type);
			if(result > 0)
				response.getWriter().print("<script>"
						+ "alert('修改成功');"
						+ "window.location.href='http://localhost:8080/NDemo/View/manager/News/getTypeByPage.do?curPage=1';"
						+ "</script>");
			else
				response.getWriter().print("<script>"
						+ "alert('修改失败，请重新尝试');"
						+ "window.location.href='http://localhost:8080/NDemo/View/manager/News/getTypeByPage.do?curPage=1';"
						+ "</script>");
		}else {
			typeService.addType(type);
			response.getWriter().print("<script>"
					+ "alert('添加成功');"
					+ "window.location.href='http://localhost:8080/NDemo/View/manager/News/getTypeByPage.do?curPage=1';"
					+ "</script>");
		}
	}
	
	@RequestMapping("/deleteTypeById")
	public void deleteTypeById(int t_id,HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int result = typeService.deleteTypeById(t_id);
		if(result > 0)
			response.getWriter().print("<script>"
					+ "alert('删除成功');"
					+ "window.location.href='http://localhost:8080/NDemo/View/manager/News/getTypeByPage.do?curPage=1';"
					+ "</script>");
		else
			response.getWriter().print("<script>"
					+ "alert('删除失败，请重新尝试');"
					+ "window.location.href='http://localhost:8080/NDemo/View/manager/News/getTypeByPage.do?curPage=1';"
					+ "</script>");
	}
}
