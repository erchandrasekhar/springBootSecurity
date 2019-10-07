package com.springbootsecurity.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value={"/login","/"})
	public ModelAndView home(Principal p)
	{
	    
		return new ModelAndView("login");
		
	}
	
	@RequestMapping(value={"/index/","/home"})
    public ModelAndView home(Principal principal,HttpServletRequest request,Model modelMap)
	{

		System.out.println(principal.getName());
        return new ModelAndView("home");
    }
}
