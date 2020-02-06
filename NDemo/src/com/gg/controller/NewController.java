package com.gg.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gg.pojo.News;
import com.gg.pojo.Type;
import com.gg.service.NewServiceImpl;
import com.gg.service.TypeServiceImpl;
import com.gg.util.Page;

@Controller
@RequestMapping("/View")
public class NewController {
	@Resource
	private NewServiceImpl newService;
	@Resource
	private TypeServiceImpl typeService;
	
	@RequestMapping("/manager/News/getNewByPage")
	public String getNewByPage(Integer curPage,HttpSession session) {
		if(curPage == null || curPage < 1)
			curPage = 1;
		Page<News> page = newService.getNewByPage(curPage);
		session.setAttribute("NewPage", page);
		session.setAttribute("NewTotalPage", page.getTotalPage());
		return "forward:NewsList.jsp";
	}
	
	@RequestMapping("/manager/News/findType")
	public String findType(HttpSession session,Integer n_id) {
		if(n_id != null && n_id >0)
			session.setAttribute("N_ID", n_id);
		List<Type> list = typeService.findAllType();
		if(list != null && list.size() >0)
			session.setAttribute("AllTypeList", list);
		return "forward:NewsModify.jsp";
	}
	
	@RequestMapping("/manager/News/addOrUpdateNews")
	public void addOrUpdateNews(News news,HttpSession session,HttpServletResponse response) throws IOException {
		session.removeAttribute("N_ID");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		if(news.getN_id() > 0) {
			int result = newService.updateNew(news);
			if(result > 0)
				response.getWriter().print("<script>"
						+ "alert('修改成功');"
						+ "window.location.href='http://localhost:8080/NDemo/View/manager/News/getNewByPage.do';"
						+ "</script>");
			else
				response.getWriter().print("<script>"
						+ "alert('修改失败，请重新尝试');"
						+ "window.location.href='http://localhost:8080/NDemo/View/manager/News/getNewByPage.do';"
						+ "</script>");
		}
		else {
			newService.addNews(news);
			response.getWriter().print("<script>"
					+ "alert('添加成功');"
					+ "window.location.href='http://localhost:8080/NDemo/View/manager/News/getNewByPage.do';"
					+ "</script>");
		}
	}
	
	@RequestMapping("/manager/News/deleteNewById")
	public void deleteNewById(Integer n_id,HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int result = newService.deleteNewById(n_id);
		if(result > 0)
			response.getWriter().print("<script>"
					+ "alert('删除成功');"
					+ "window.location.href='http://localhost:8080/NDemo/View/manager/News/getNewByPage.do';"
					+ "</script>");
		else
			response.getWriter().print("<script>"
					+ "alert('删除失败，请重新尝试');"
					+ "window.location.href='http://localhost:8080/NDemo/View/manager/News/getNewByPage.do';"
					+ "</script>");
	}
	
	@RequestMapping("/loadIndex")
	public String loadIndex(HttpSession session) {
		List<Type> typeList = typeService.findAllType();
		session.setAttribute("AllTypeList", typeList);
		List<News> queryHot = newService.queryHot();
		session.setAttribute("QueryHotList", queryHot);
		List<News> queryNew = newService.queryNew();
		session.setAttribute("QueryNewList", queryNew);
		return "forward:Index.jsp";
	}
	
	@RequestMapping("/findNewsByType")
	public String findNewsByType(Integer t_id,Integer curPage,HttpSession session) {
		if(curPage == null || curPage <0 )
			curPage = 1;
		Page<News> page = newService.findNewsByType(t_id,curPage);
		session.setAttribute("NewsByTypePage", page);
		session.setAttribute("TotalPage", page.getTotalPage());
		return "forward:List.jsp?t_id="+t_id+"&curPage="+curPage;
	}
	
	@RequestMapping("/SearchNew")
	public String SearchNew(String select,String key,Integer curPage,HttpSession session) {
		Page<News> page = new Page<>();
		if(curPage == null || curPage <=0)
			curPage = 1;
		if(select.equals("标题")) {
			page = newService.findNewsByKey("n_title", key, curPage);
		}
		else {
			page = newService.findNewsByKey("n_content", key, curPage);
		}
		session.setAttribute("NewPageBySearch", page);
		session.setAttribute("TotalPage", page.getTotalPage());
		return "forward:Search.jsp?curPage="+page.getCurPage()+"&select="+select+"&key="+key;
	}
}
