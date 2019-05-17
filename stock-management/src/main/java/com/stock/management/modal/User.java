package com.stock.management.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	UserAddress userAddress;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	List<UserTelephone> usertelephones;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public List<UserTelephone> getUsertelephones() {
		return usertelephones;
	}

	public void setUsertelephones(List<UserTelephone> usertelephones) {
		this.usertelephones = usertelephones;
	}
	
	
	
	
	
	
	

}
