package com.yq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.weixin.util.StringUtil;

@Controller
@RequestMapping
public class AbountCtrl extends StringUtil{
	@RequestMapping(value = "/main/about.html")
	public ModelAndView addjsp() {
		return new ModelAndView("main/about");
	}
}
