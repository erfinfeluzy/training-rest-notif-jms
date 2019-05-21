package com.training.msa.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@Value("${hello.world.message}")
	private String helloMessage;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		System.out.println("index controller");
		
		String result = helloMessage + " Erfin";
		
		return result;
	}
}
