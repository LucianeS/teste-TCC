package br.edu.ifrs.canoas.teste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	/**ObjetoService objetoService; FUTURAMENTE! 
	
	@Autowired
	public HomeController(ObjetoService objetoService){
		this.objetoService = objetoService;
	}**/
	

	@RequestMapping("/")
	public String home(Model model){
		//model.addAttribute("doacoes", userService.listStatusDisponivel());
		return "/index";
	}

}
