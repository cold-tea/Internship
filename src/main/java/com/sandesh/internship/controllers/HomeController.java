package com.sandesh.internship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller class has mapping for index page or home page.
 * The request with /home is mapped by this controller. 
 * @author Sandesh
 *
 */

@Controller
public class HomeController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	}
	
	@RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
	public String goHome() {
		return "index";
	}
}
