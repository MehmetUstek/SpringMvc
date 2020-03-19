package com.JavaTest.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.JavaTest.dao.UserDao;
import com.JavaTest.model.User;

public class Controller {
	@Autowired
	private UserDao empDao;

	@RequestMapping(value = "/fetch")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {

		List<User> listEmp= new ArrayList<User>();
		User user1 = new User();
		user1.setId(10);
		user1.setBody("asda");
		user1.setPostId(12);
		listEmp.add(user1);
		listEmp.add(new User(1,"asd",1));
		listEmp.add(new User());
		model.addObject("listEmp", listEmp);
		model.setViewName("index");

		return model;
	}
}
