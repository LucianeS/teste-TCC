/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.teste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.teste.domain.User;
import br.edu.ifrs.canoas.teste.repository.UserRepository;


// TODO: Auto-generated Javadoc
@Service
public class UserProfileService {

	private UserRepository userRepository;

	/**
	 * Instantiates a new user profile service.
	 *
	 * @param usuarioRepository
	 *            the usuario repository
	 */
	@Autowired
	public UserProfileService(UserRepository usuarioRepository) {
		this.userRepository = usuarioRepository;
	}

	/**
	 * List.
	 *
	 * @return the iterable
	 */
	public Iterable<User> list() {
		return userRepository.findAll();
	}

	/**
	 * Find by email.
	 *
	 * @param email
	 *            the email
	 * @return the user
	 */
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	

	public User findByNome(String nome) {
		return userRepository.findByNome(nome);
	}
	
	/**
	 * Save.
	 *
	 * @param user
	 *            the user
	 * @return the user
	 */
	public User save(User user) {
		return userRepository.save(user);
	}

	public UserDetailsImpl getPrincipal() {
		if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null)
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetailsImpl)
				return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return null;
	}

	/**
	 * Gets the.
	 *
	 * @param id
	 *            the id
	 * @return the user
	 */
	// tenativa 09/03
	public User get(Long id) {
		return userRepository.findOne(id);
	}

	/**
	 * List.
	 *
	 * @param parameter
	 *            the parameter
	 * @return the list
	 */
	public List<User> list(String parameter) {
		return userRepository.findAllByNomeContainingOrEmailContainingAllIgnoreCase(parameter, parameter);
	}

	/**
	 * Find all trainers.
	 *
	 * @return the list
	 */
	public List<User> findAllTrainers() {
		return userRepository.findAllByRoles_Id(3L);
	}

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 */
	public void delete(Long id) {
		userRepository.delete(id);
	}
}