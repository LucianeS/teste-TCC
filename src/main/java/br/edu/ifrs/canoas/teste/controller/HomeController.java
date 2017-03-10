package br.edu.ifrs.canoas.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.teste.service.UserService;

@Controller
public class HomeController {
	
	UserService userService;
	
	@Autowired
	public HomeController(UserService doacaoService){
		this.userService = doacaoService;
	}
	

	@RequestMapping("/")
	public String home(Model model){
		//model.addAttribute("doacoes", userService.listStatusDisponivel());
		return "index";
	}

}
