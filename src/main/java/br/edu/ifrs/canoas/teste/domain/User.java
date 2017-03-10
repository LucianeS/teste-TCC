/*
 * 
 */
package br.edu.ifrs.canoas.teste.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.validator.constraints.Email;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String nome;

	@Column(unique = true, nullable = false)
	@Email
	private String email;

	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private String instituicao;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })

	private Set<Role> roles = new HashSet<Role>();

	/**@Column(columnDefinition = "boolean default true")
	private Boolean active;
	
	public User() {
		this.active = true;
	}**/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", senha=" + senha + "]";
	}


}
