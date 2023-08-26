package com.stackroute.myfirstspringbootrest.DTO;

public class LoginUserDTO {
	
	private String username;
	private String password;
	public LoginUserDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public LoginUserDTO() {}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginUserDTO [username=" + username + ", password=" + password + "]";
	}	

}
