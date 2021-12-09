package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String redirect() {
		
		System.out.println("redirect() method is invoking");
		return "viewpage";
	}

	@RequestMapping("/helloagain")
	public String display() {
		System.out.println("display() method invoking");
		return "final";
	}
	
	@RequestMapping("/mypage")
	public String show()
	{
		return "mypage";
	}
}