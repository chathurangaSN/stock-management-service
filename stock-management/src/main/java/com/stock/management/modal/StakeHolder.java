
//nilaksha
package com.stock.management.modal;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class StakeHolder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id = 0;
	String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	StakeHolderAddress address;
	
	@OneToMany(mappedBy = "stakeholder", cascade = CascadeType.ALL)
	List<StakeHolderTelephone> telephones;

	public List<StakeHolderTelephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<StakeHolderTelephone> telephones) {
		this.telephones = telephones;
	}

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

	public StakeHolderAddress getAddress() {
		return address;
	}

	public void setAddress(StakeHolderAddress address) {
		this.address = address;
	}

}
