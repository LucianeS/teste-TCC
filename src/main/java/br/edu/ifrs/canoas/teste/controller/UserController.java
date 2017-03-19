package br.edu.ifrs.canoas.teste.controller;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.canoas.teste.domain.User;
import br.edu.ifrs.canoas.teste.service.UserProfileService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserProfileService userService;
	private MessageSource messageSource;
	
	@Autowired
	public UserController(UserProfileService service, MessageSource messageSource) {
		this.userService=service;
		this.messageSource = messageSource;
	}
	
	@RequestMapping("/create")
	public String create(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("readonly", false);
		return "/page-register";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid User user, BindingResult bindingResult, HttpSession session, Model model) throws IOException{

		if (bindingResult.hasErrors()) {
			return "/page-register";
		} else {
			User savedUser = userService.save(user);
			return "/";
		}
	}

}
