/*
 * 
 */
package br.edu.ifrs.canoas.teste.controller;
import java.text.MessageFormat;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.canoas.teste.domain.User;
import br.edu.ifrs.canoas.teste.service.UserProfileService;

// TODO: Auto-generated Javadoc
@Controller
@RequestMapping("/user")
public class UserController {

	private UserProfileService service;
	private MessageSource messageSource;

	/**
	 * Instantiates a new user controller.
	 *
	 * @param service
	 *            the service
	 */
	@Autowired
	public UserController(UserProfileService service, MessageSource messageSource) {
		this.service = service;
		this.messageSource = messageSource;
	}
	
	/**
	 * Retorna o a página do formulário de
	 * cadastro de usuários
	 * @param model
	 * @return
	 */
	@RequestMapping("/create")
	public String create(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("readonly", false);
		return "/user/form-cadastro";
	}

	/**
	 * Grava as informações recebidas,
	 * via método post pelo formulário.
	 * @param doacao
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid User user, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs,
			Locale locale){
		
		if (!bindingResult.hasErrors()) {			
			User savedUser =service.save(user);
			redirectAttrs.addFlashAttribute("message", messageSource.getMessage("user.saved", null, locale));
			return "redirect:/user/view/" + savedUser.getId() + "?success";
		}
		model.addAttribute("readonly", false);
		return "/user/form-cadastro";

	}
	
	/**
	 * Permite a visualização do cadastro
	 * de um usuário, referente ao id recebido,
	 * via URL
	 * @param id
	 * @param model
	 * @param redirectAttrs
	 * @param locale
	 * @return
	 */
	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs, Locale locale) {
		User user = service.get(id);

		if (user == null) {
			redirectAttrs.addFlashAttribute("message",
					MessageFormat.format(messageSource.getMessage("user.notFound", null, locale), id));
			return "redirect:/";
		}

		model.addAttribute("user", service.get(id));
		model.addAttribute("readonly", true);

		return "/user/form-cadastro";
	}

}
