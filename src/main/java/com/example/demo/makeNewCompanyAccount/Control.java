package com.example.demo.makeNewCompanyAccount;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/makeNewCompanyAccount")
public class Control {	
	@GetMapping
	public String showDisplay(Model model) {		
		return "/makeNewCompanyAccount";
	}
}