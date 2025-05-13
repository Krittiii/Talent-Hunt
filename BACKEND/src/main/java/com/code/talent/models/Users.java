package com.code.talent.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	//member variable
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int user_id;
	@Column(name="name",nullable = false,length=50)
	private String name;
	@Column(name="emailid",nullable = false,length=50,unique = true)
	private String emailid;
	@Column(name="password",nullable = false,length=20)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name="role",nullable = false,length=20)
	private Role role;
	

	
	public enum Role {
		ADMIN, PARTICIPANT, JUDGE
	}
	
	public Users()
	{
		this.emailid=null;
		this.name=null;
		this.password= null;
		this.role=null;
		this.user_id=0;
		
	}
	public Users(String name, String emailid, String password, Role role) {
		super();
		this.name = name;
		this.emailid = emailid;
		this.password = password;
		this.role = role;
		
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	
	
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", name=" + name + ", emailid=" + emailid + ", password=" + password
				+ ", role=" + role + " ]";
	}

}

