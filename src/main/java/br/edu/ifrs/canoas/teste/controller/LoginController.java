package br.edu.ifrs.canoas.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.teste.service.UserService;

@Controller
public class LoginController {
	
	UserService userService;
	
	@Autowired
	public LoginController(UserService doacaoService){
		this.userService = doacaoService;
	}
	

	@RequestMapping("/page-register")
	public String home(Model model){
		//model.addAttribute("doacoes", userService.listStatusDisponivel());
		return "page-register";
	}
	
	@RequestMapping("/page-forgot-password")
	public String page(Model model){
		//model.addAttribute("doacoes", userService.listStatusDisponivel());
		return "page-forgot-password";
	}

}
