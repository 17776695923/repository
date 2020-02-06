package com.gg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gg.pojo.User;
import com.gg.service.UserServiceImpl;

@Controller
@RequestMapping("/View/manager")
public class UserController {
	@Autowired
	private UserServiceImpl userservice;
	
	@RequestMapping("/userLogin")
	public String userLogin(String username,String password,HttpSession session) {
		User user = userservice.login(username, password);
		session.setAttribute("user", user);
		return "redirect:/View/manager/Index.jsp";
	}
}
