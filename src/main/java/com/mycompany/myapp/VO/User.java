package com.mycompany.myapp.VO;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {

	int id;
	@NotEmpty
	String email;
	@NotEmpty
	String nickname;
	@Size(min=6)
	String password;
	Boolean enabled;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", nickname=" + nickname + ", password=" + password + "]";
	}



}
