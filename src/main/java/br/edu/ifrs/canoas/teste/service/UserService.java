/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.teste.service;

import br.edu.ifrs.canoas.teste.domain.User;

public interface UserService {

	/**
	 * Find by email.
	 *
	 * @param email
	 *            the email
	 * @return the user
	 */	
	public User findByEmail(String email);
	
	

}
