package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView helloWorld() {

		ModelAndView model = new ModelAndView("HelloWorldPage");
		model.addObject("msg", "Hello World!!");

		return model;
	}

}
