package com.stock.management.modal;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//----- Sahan Part -----
@Entity
public class OpenStock {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id = 0;

    ZonedDateTime date;
    String user;
    String reason;

    @OneToMany(mappedBy = "openStock", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<OpenStockDetails> openStockDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public int getDate() {
//        return date;
//    }
//
//    public void setDate(int date) {
//        this.date = date;
//    }
    
    public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}
	
    public String getUser() {
        return user;
    }

	public void setUser(String user) {
        this.user = user;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<OpenStockDetails> getOpenStockDetails() {
        return openStockDetails;
    }

    public void setOpenStockDetails(List<OpenStockDetails> openStockDetails) {
        this.openStockDetails = openStockDetails;
    }
}
