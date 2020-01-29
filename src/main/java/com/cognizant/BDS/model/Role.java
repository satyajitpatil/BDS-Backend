package com.cognizant.BDS.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private long id;
	
	@Column(name="role_name")
	private String name;
	
	/*@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private Set<User> userList;*/
	/*
	 * @ManyToMany(mappedBy = "roleList",fetch = FetchType.EAGER) private Set<User>
	 * userList;
	 */

	public Role() {
		super();
	}

	public Role(String name, Set<User> userList) {
		super();
		this.name = name;
		//this.userList = userList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public Set<User> getUserList() { return userList; }
	 * 
	 * public void setUserList(Set<User> userList) { this.userList = userList; }
	 */


	

}

