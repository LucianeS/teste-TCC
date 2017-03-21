/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.teste.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.edu.ifrs.canoas.teste.domain.Role;
import br.edu.ifrs.canoas.teste.domain.User;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = -8448427523761739807L;

	private User user;

	/**
	 * Instantiates a new user details impl.
	 *
	 * @param user
	 *            the user
	 */
	public UserDetailsImpl(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		new BCryptPasswordEncoder().encode(user.getSenha());
		return user.getSenha();
	}

	public String getNome() {
		return (user != null) ? user.getNome() : "";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
