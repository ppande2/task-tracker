package com.tt.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tt.domain.User;
import com.tt.services.api.LoginService;
import com.tt.utils.JsonUtil;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginservice;

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public String displayLoginPage() throws JsonGenerationException, JsonMappingException, IOException
	{
		
		return "Pankaj Pandey !!!!";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String validateUser(@RequestBody User user) throws JsonGenerationException, JsonMappingException, IOException {		
		
		User usr=loginservice.validate(user.getUserId(),user.getPassword());
		User newUser=new User();
		
		if((usr)!=null)
		{
			newUser.setUserId(user.getUserId());
			newUser.setPassword(user.getPassword());
			newUser.setRole(user.getRole());
			return JsonUtil.buildJsonFromObject(newUser);
					
		}
		else 
			return JsonUtil.buildJsonFromObject(newUser);
					
	}
	
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView displayLoginPage()
	{
		
		ModelAndView model=new ModelAndView("LoginPage");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView validateUser(@RequestParam String userId,@RequestParam String password,HttpServletRequest request) {
			
		ModelAndView model=new ModelAndView("LoginStatus");
		if(loginservice.validate(userId,password))
		{
			request.getSession().setAttribute("isSession", true);
			model.addObject("msg","Welcome Pankaj!How are you?");		
				
		}
		else 
			model.addObject("msg","Oops Pankaj! WrongPassword");
			
		return model;
		
	}*/

}
