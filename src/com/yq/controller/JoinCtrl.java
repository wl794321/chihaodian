package com.yq.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.weixin.util.StringUtil;
import com.yq.service.JoinusService;

@Controller
@RequestMapping
public class JoinCtrl extends StringUtil{
	@Autowired
	private JoinusService joinusService;
	@RequestMapping(value = "/main/join.html")
	public ModelAndView addjsp() {
		return new ModelAndView("main/join");
	}
	Map<String, Object> map = new HashMap<String, Object>();
	@ResponseBody
	@RequestMapping(value = "/main/joinInsert.html")
	public String insert(String name , String phone ,
	String address ,String sex,String age,
			HttpSession session) {
			map.put("name", name);
			map.put("phone", phone);
			map.put("address", address);
			map.put("sex", sex);
			map.put("age", Integer.valueOf(age));
			return joinusService.insert(map)+"";
	}
}
